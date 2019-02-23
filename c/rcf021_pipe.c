/*
 *  pipe.c - Replication of a CSI lab.
 *  Copyright (C) 2019 Ryan Fleck under the GNU GPLv3.
 *  
 *  DUP2()
 *  http://man7.org/linux/man-pages/man2/dup.2.html
 *   Usage: dup2( fdSrc, fdDst );
 *    Replaces fdDst with fdSrc.
 *
 *  
 *  PIPE()
 *  https://linux.die.net/man/2/pipe
 *   Usage: pipe(pipefd) 
 *    Writes pipe i/o descriptors to pipefd array.
 *    pipefd[0] -> Read end of pipe.
 *    pipefd[1] -> Write end of pipe.
 * 
 *    Data written to the write end of the pipe is buffered by the
 *      kernel until it is read from the read end of the pipe.
 * 
 *  Process files:
 *   0 - STDIN.
 *   1 - STDOUT.
 */

#define _POSIX_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <signal.h>

int main(int argc, char **argv)
{
    char * program;
    int prpid, monpid, fpid;
    char pidStr[32];
    int pipefd[2];

    program = "calcloop"; //"randforever";
    printf("Using %s as test program.\n", program);

    // Fork and start test process.
    prpid = fork();
    if( prpid < 0 ) {
        printf("First fork (prpid) has failed.\n");
        exit(-1);
    } else if (prpid == 0) { // Run if child.
        puts("First fork, test program, is fine.");
        execl(program,program,NULL); // Run test program.
        exit(-1); // execl should exit by itself.
    }

    // Create pipe, safe details to pipefd array.
    if( pipe(pipefd) == -1 ) {
        printf("Pipe creation has failed.\n");
        exit(-1);
    } else {
        puts("Pipe created.");
    }

    // Output of procmon should be directed to input of filter.

    // Run process filter.
    fpid = fork();
    if( fpid < 0 ) {
        printf("Second fork (fpid) has failed.\n");
        kill(prpid, SIGTERM); // Had a runaway process. No more.
        exit(-1);
    } else if (fpid == 0) { // Run if child.
        puts("Second fork, filter program, is fine.");

        // Direct stdin of child to pipe.
        // (Plug Pipe/Read into STDIN.)
        if( dup2(pipefd[0], 0) == -1 ) { // Stdin -> 0
            perror("Second fork dup2: ");
            exit(-1);
        }

        //close(pipefd[0]);
        //close(pipefd[1]);
        execlp("filter","filter",NULL);
        puts("Filter active.");
        exit(-1);
    }

    // Run process monitor.
    sprintf(pidStr, "%d", prpid);
    monpid = fork();
    if( monpid < 0 ) {
        printf("Third fork (monpid) has failed.\n");
        kill(fpid, SIGTERM);
        kill(prpid, SIGTERM);
        exit(-1);
    } else if ( monpid == 0 ) { // Run if child.
        puts("Third fork, monitor program, is fine.");
        printf("Attempting to monitor PID %s\n",pidStr);
        // Direct stdout of child to pipe.
        // ( Plug Pipe/Write to STDOUT )
        dup2(pipefd[1], 1); // Stdout -> 1
        puts("Stdout should be IN PIPE? Good.");
        //close(pipefd[0]);
        //close(pipefd[1]);
        execlp("procmon","procmon", pidStr, NULL);
        exit(-1);
    }

    close(pipefd[0]);
    close(pipefd[1]);
    sleep(3); //20

    puts("Killing program.");
    kill(prpid, SIGTERM);
    sleep(1);
    puts("Killing progmon.");
    kill(monpid, SIGTERM);
    sleep(1);
    puts("Killing filter.");
    kill(fpid, SIGTERM);
    sleep(1);

    return 0;
}

