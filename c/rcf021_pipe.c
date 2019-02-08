/*
 *  pipe.c - Replication of a CSI lab.
 *  Copyright (C) 2019 Ryan Fleck under the GNU GPLv3.
 *
 *  http://man7.org/linux/man-pages/man2/dup.2.html
 */

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

    program = "./randforever";
    printf("Using %s as test program.\n", program);
    
    // Fork and start test process.
    prpid = fork();
    if( prpid < 0 ) {
        printf("First fork has failed.\n");
        exit(-1);
    } else {
        execl(program,program,NULL); // Run test program.
        exit(-1); // execl should exit by itself.
    }

    // Create pipe, safe details to pipefd array.
    if( pipe(pipefd) == -1 ){
        printf("Pipe creation has failed.\n");
        exit(-1); 
    }

    // 

    return 0;
}
