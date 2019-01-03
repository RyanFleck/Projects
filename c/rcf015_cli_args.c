#include <stdio.h>

/*
 * Same as RCF014, but expanded to read arguments after flags.
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
