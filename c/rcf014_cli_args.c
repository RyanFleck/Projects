#include <stdio.h>

/*
 * Reads single-character arguments.
 * Executing 'prog -x test -v why -n ha' returns:
 *   Argument -x in use.
 *   Argument -v in use.
 *   Argument -n in use.
 */

int main(int argc, char *argv[]){
    if( argc < 2 ){
        puts("Usage: Returns number of arguments. Use -v for verbose, -n for numbering.");
    }

    int r = 1; // First arg is program name:

    printf("\n%s\n\n",*argv);

    while( r++ < argc ){
        if( (*++argv)[0] == '-' ){
          int c;
          while( c = *++argv[0] ){
              printf("Argument -%c in use.\n",c);
          }
        }
    } 

    return 0;
}
