
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

/*
 * Prints squares like the following.
 * Reads the n depth of the square from STDIN.
 *
 * 5 5 5 5 5 5 5 5 5
 * 5 4 4 4 4 4 4 4 5
 * 5 4 3 3 3 3 3 4 5
 * 5 4 3 2 2 2 3 4 5
 * 5 4 3 2 1 2 3 4 5
 * 5 4 3 2 2 2 3 4 5
 * 5 4 3 3 3 3 3 4 5
 * 5 4 4 4 4 4 4 4 5
 * 5 5 5 5 5 5 5 5 5
 */

int main()
{
    int n;
    scanf ( "%d", &n );
    int frame_size = ( n*2 ) - 1;
    int y_depth = 0;
    int x_depth;
    int printed_int;

    // For each row in the output.
    for ( int y=0; y<frame_size; y++ )
    {
        x_depth = 0;
        printed_int = n;
        // For each col in each row.
        for ( int x=0; x<frame_size; x++ )
        {
            printf ( "%i ", printed_int );

            // Adjust printed integer.
            if ( x_depth < y_depth && x < n )
                printed_int--;
            else if ( x_depth <= y_depth && x >= ( n-1 ) )
                printed_int++;

            // Adjust x-depth.
            if ( x >= ( n - 1 ) )
                x_depth--;
            else
                x_depth++;
        }

        // Shift to next line.
        printf ( "\n" );

        // Adjust y-depth.
        if ( y >= ( n-1 ) )
            y_depth--;
        else
            y_depth++;
    }
    return 0;
}

