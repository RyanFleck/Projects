#include <stdio.h>
#include <stdbool.h>

/*
 * Ryan's 'C' language learning file.
 * 
 * This program contains a great number of simple functions
 * intended to dip a toe in the water regarding the 
 * usefulness, strengths and ease of integration of c.
 *
 * Notes often appear between functions, and simply state
 * the things that I have learned while browsing these sites:
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


int main()
{
	printf("\nTEST PROGRAM ONE\nRyan's C learning file.\n\n");
	int sumx = sum(1,2);
	int sumy = sum(sumx,4);
	int sumz = sum(sumx,sumy);
	sum(sumy,sumz);	
	
	varTypes();
	ifStatements();
	
	
	return 0;
}


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
