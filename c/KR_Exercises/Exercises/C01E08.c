/*
* ----------------------------------------------------------------------------
* "THE BEER-WARE LICENSE" (Revision 42R):
* <rflec028@uottawa.ca> wrote this file. As long as you retain this notice you
* can do whatever you want with this stuff. If we meet some day, and you think
* this stuff is worth it, you can buy me a beer in return  -Ryan Fleck
* ----------------------------------------------------------------------------
*
* Ryan Fleck - Learning C - Textbook Exercise
* BEERWARE license written by Poul-Henning Kamp <phk@FreeBSD.ORG> 
* Exercises from "THE C PROGRAMMING LANGUAGE" 2E, K&R
*/

#include<stdio.h>
#define CHAPTER  1		
#define EXERCISE 8

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	// Beginning of exercise code.

  int c, blanks=0, tabs=0, newlines=0;

  while(  (c=getchar()) != EOF  ){
    if( c==' ')
      ++blanks;
    if( c=='\t')
      ++tabs;
    if( c=='\n')
      ++newlines;
    }

  

  printf("\nCharacter breakdown:\n\nBlanks:\t\t%d\nTabs:\t\t%d\nNewlines:\t%d\n",blanks,tabs,newlines);

	// End of exersise code.
	printf("\n\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

