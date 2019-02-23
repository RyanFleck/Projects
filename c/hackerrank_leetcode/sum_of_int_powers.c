#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

/*
 * Fun note: I failed an interview once, where they asked
 * me how I would convert an int to a string in C. The
 * process here could be easily adapted to throw each 
 * calculated int, here added to acc, into a char array.
 */

int main()
{
    int n;
    int acc = 0;
    scanf("%d", &n);
    //Complete the code to calculate the sum of the five digits on n.

    for (int i = 4; i >= 0; i--)
    {
        acc += n % 10;
        n = n / 10; // Discards rightmost number.
    }

    printf("%i", acc);
    return acc;
}