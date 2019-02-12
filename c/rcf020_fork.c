/*
 *  fork.c
 *  Copyright (C) 2019 Ryan Fleck under the GNU GPLv3.
 *
 *  http://man7.org/linux/man-pages/man2/dup.2.html
 */

#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>

int main(int argc, char **argv)
{
    int fd[2], pid, ret; // fd[] -> File descriptor.

    /* fd[0] is the read end of the pipe.
     * fd[1] is the write end of the pipe.
     * fd[2] is... I'm not sure. TODO: Lookup.
     */

    ret = pipe(fd);
    if( ret < 0 ) {
        return 1;
    }

    printf("PIPE: r:%i w:%i x:%i\n",fd[0],fd[1],fd[2]);

    pid = fork();

    if( pid == 0 ) {
        printf("Child closes %i\n",fd[1]);
        close(fd[1]); // Close writing end.
        // dup2(fd[0],1);
        exit(0);
    } else {
        printf("Parent closes %i\n",fd[0]);
        close(fd[0]); // Close reading end.
        // dup2(0,fd[1]);
    }

    return 0;
}
