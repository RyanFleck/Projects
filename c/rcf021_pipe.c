/*
 *  pipe.c - Replication of a CSI lab.
 *  Copyright (C) 2019 Ryan Fleck under the GNU GPLv3.
 *
 *  http://man7.org/linux/man-pages/man2/dup.2.html
 *   Usage: dup2( fdSrc, fdDst );
 *     Copies fdSrc to fdDst.
 *  
 *  Process files:
 *   0 - STDIN.
 *   1 - STDOUT.
 */

#define _POSIX_SOURCE
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#include<signal.h>

int main(int argc, char **argv)
{
    char * program;
    int prpid, monpid, fpid;
    char pidStr[32];
    int pipefd[2];

    program = "calcloop";
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
        if( dup2(pipefd[0], 0) == -1 ) {
            perror("Second fork dup2: ");
            exit(-1);
        }

        close(pipefd[0]);
        close(pipefd[1]);
        execlp("filter","filter",NULL);
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
        dup2(pipefd[1], 1);
        close(pipefd[0]);
        close(pipefd[1]);
        execlp("procmon","procmon", pidStr, NULL);
        exit(-1);
    }
    
    close(pipefd[0]);
    close(pipefd[1]);
    sleep(5); //20

    puts("Killing program.");
    kill(prpid, SIGTERM);
    sleep(3);
    puts("Killing progmon.");
    kill(monpid, SIGTERM);
    sleep(3);
    puts("Killing filter.");
    kill(fpid, SIGTERM);
    sleep(3);

    return 0;
}
