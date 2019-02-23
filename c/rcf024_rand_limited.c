/*
 *  rand_limited.c - Sends two batches of 5 random ints to STDOUT.
 *  Copyright (C) 2019 Ryan Fleck under the GNU GPLv3.
 */

#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<time.h>

int main(int argc, char **argv)
{
    int c = 0;
    srand(time(NULL));

    while(c<5) {
        printf("%i %i\n",c++,rand());
    }
    sleep(1);
    while(c<10) {
        printf("%i %i\n",c++,rand());
    }

    return 0;
}
