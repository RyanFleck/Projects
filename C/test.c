#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

/*
 * Ryan's 'C' language learning file.
 * 
 * This program contains a great number of simple functions
 * intended to dip a toe in the water regarding the 
 * usefulness, strengths and ease of integration of c.
 *
 * Notes often appear between functions, and simply state
 * the things that I have learned while browsing these sources:
 * -linuxconfig.org/c-development-on-linux-introduction-i
 *  (and pages following this one,)
 * -The C programming language, second edition. 
 *  (The venerable Kernighan/Ritchie version.)
 * -Stack overflow and similar forums. 
 */

//Functions below main, in order:
int sum(int a,int b);
int varTypes();
int ifStatements();
int casting();
int tempTable();

int main()
{
	printf("\nTEST PROGRAM ONE\nRyan's C learning file.\n\n");
	int sumx = sum(1,2);
	int sumy = sum(sumx,4);
	int sumz = sum(sumx,sumy);
	sum(sumy,sumz);	
	
	varTypes();
	ifStatements();
	casting();
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


//My first simple function.
int sum(int a,int b)
{
	//Sum Variable
	int sumv = a+b;
	printf("The sum of %d and %d is %d.\n",a,b,sumv);
	return sumv;
}

/*
 * Quick note on data types:
 * 
 * TYPES: char,int,float,double
 * MODIFIERS: signed, unsigned, const
 *
 * TYPES are data containers with a specific kind of data.
 * MODIFIERS signify if a number can be less than zero (signed) or above (un)
 * const means a varible cannot be changed after it is set.
 * short and long are kinds of ints that have a different amount of storage.
 * 
 */
 
int varTypes()
{
	printf("\nTEST: Variable types:\n");	
	/* These are just here to ensure that I'm assigning types correctly,
	 * and to ensure I don't get any compile-time errors.*/
	char c = 'a';
	int i = 123;
	float f = 12314.123;
	long double ld = 71098437019832740187432.093284;

	printf("Ay! I can assign variables! But can I print them?\n");
	printf("c:%c\ni:%i\nf:%f\nld:%Lf\n",c,i,f,ld);

	return 0;
}

int ifStatements()
{	
	printf("\nTEST: If Statements:\n");	
	bool verifySum = false;
	
	//Checks if sum function works:
	if ( sum(1,4)==5 )
		verifySum=true;
	else
		verifySum=false;
	
	//Reports if sum function/booleans work:
	if ( verifySum==true )	
		printf("Sum function works! 1+4 is equal to 5!\n");
	else
		printf("Sum function failed! 1+4 is not equal to 5!\n");
	
	
	return 0;
}

int casting()
{
	printf("\nTEST: Casting variables:\n");
	char c = 'a';
	int b = (int)c;
	printf("If casting works, %d==%d\n",(int)c,b);	
	printf("RYAN in ASCII nums: %d, %d, %d, %d.\n",
		(int)'r',(int)'y',(int)'a',(int)'n');
	//FAIL: printf("RYAN in ASCII nums: %d, %d, %d, %d.\n",(int)"ryan");
	
	return 0;
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


/*
 * Final comments:
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
