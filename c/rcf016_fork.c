/*
 *  rcf016_fork.c - Experimental program that uses UNIX sys calls.
 *  Copyright (C) 2018 Ryan Fleck under the GNU GPLv3.
 *  Compiled & tested using GCC.
 */

#include<stdio.h>
#include<unistd.h>   // Provides fork()
#include<stdlib.h>   // Provides exit()
// sys/types and sys/wait provides wait()
#include <sys/types.h>
#include <sys/wait.h>

int main(int argc, char **argv)
{
    puts("I am a process, about to fork().");
    int pid = fork(); //Forks _at this point_ in execution.

    if( pid == 0 ) {
        puts("I am child.");
        exit(0);
    } else {
        int status;
        wait(&status);
        printf("I am parent. Child exited with status %i.",status);
    }
    return 0;
}
