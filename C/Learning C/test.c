#include <stdio.h>

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

int main()
{
	printf("\nTEST PROGRAM ONE\nRyan's C learning file.\n\n");
	int sumx = sum(1,2);
	int sumy = sum(sumx,4);
	int sumz = sum(sumx,sumy);
	sum(sumy,sumz);	
	
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
 */
