/*
 *  rand_forever.c - Sends rand tuple to stdout every second.
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

    while(1) {
        printf("%i %i\n",c++,rand());
        sleep(1);
    }

    return 0;
}
