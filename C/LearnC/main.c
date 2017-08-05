#include <stdio.h>
#include <stdlib.h>

int testFunction();
int tempTable();

int main()
{
    printf("Hello world!\n");

    //Chapter one functions:
    testFunction();
    tempTable();

    return 0;
}

/*
Ryan Fleck, Aug 01 2017.
Notes from 'THE C PROGRAMMING LANGUAGE' 2e, Kernighan/Ritchie.

Notes on preface:

-C is important because UNIX.
-C has grown beyond UNIX.
-ANSI C is a standard definition of C.
-Appendix A is a reference.
-C is as small and general purpose language.
-C is low level and has a wide range of applications.
-Find a 'knowledgable colleague'.

Notes on introduction:
-C is  general-purpose and low-level.
-C uses data types.
-Pointers provide for address arithmetic.
-C provides good fundamental control flow.
    -if/else
    -switch
    -while
    -for
    -do
    -break
-C provides functions that can be called recursively.
-C only offers single-thread control flow.
    -No synchronizations or parallel operations.
*/


int testFunction()  //A function takes a set of arguments.
{
    //every c program is a combination of functions and variables.
    printf("Functions are...\t functional.\n"); //Main lib calls printf function on string constant.
    // C provides \t for tab, \n for newline, \b for backspace, \" for double quote.
    return 0; //A function often returns a value.
}


int tempTable() //Prints deg F/deg C table for 0,20...300.
{
    //All variables are declared at the beginning of a function.
    int fahr, celsius;
    int lower, upper, step;

    lower = 0;
    upper = 300;
    step = 20;

    fahr = lower;
    printf(  "\nTEMP CONVERSION:\nF:\tC:\n"  );
    while(fahr <= upper) {
        celsius = (  5.0/9 * (fahr-32)  );
        printf(  "%d\t%d\n", fahr, celsius  );
        fahr = fahr + step ;
    }

    return 0;
}


