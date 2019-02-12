/*
 *  rcf017_scanf.c - Learn to use ScanF.
 *  Copyright (C) 2019 Ryan Fleck under the GNU GPLv3.
 */

#include<stdio.h>

int main(int argc, char **argv)
{
    char buf[100];
    scanf("%s",buf);
    puts(buf);
    return 0;
}
