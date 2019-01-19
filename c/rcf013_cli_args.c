/*
 * Prints Arguments:
 *
 *   Arguments given: 3
 *    1: pretty
 *    2: freakin
 *    3: neato
 */


#include <stdio.h>

int main( int argc, char *argv[] )
{

    if( argc == 1 ) {
        puts("No arguments supplied.");
        return 1;
    }

    printf("Arguments given: %i\n",(argc-1));

    for( int i = 1; i < argc; i++ ) {
        printf( " %i: %s\n", i, argv[i] );
    }

    return 0;
}
