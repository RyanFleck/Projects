/*
 *  zombie.c - desc
 *  Copyright (C) 2019 Ryan Fleck under the GNU GPLv3.
 */

#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>

int main(int argc, char **argv)
{
    puts("Parent sleeps forever, press CTRL+C to kill.");
    printf("Parent PID: %d\n", getpid());

    pid_t pid;
    pid = fork();

    if( pid == 0 ) {
        printf("Child PID: %d\n", getpid());
        sleep(2);
        puts("Child exit.");
        exit(0);
    }

    while(1) {
        sleep(1);
    }

    return 0;
}
