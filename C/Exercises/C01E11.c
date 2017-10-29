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
#define EXERCISE 11

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	// Beginning of exercise code.

  int c, blanks=0, tabs=0, newlines=0, characters=0;

  while(  (c=getchar()) != EOF  ){
    
    
    if( c==' ')
      ++blanks;
    else if( c=='\t')
      ++tabs;
    else if( c=='\n')
      ++newlines;
    else
      ++characters;
   
    }

  

  printf("\nCharacter breakdown:\n\nBlanks:\t\t%d\nTabs:\t\t%d\nNewlines:\t%d\nCharacters:\t%d\n"
    ,blanks,tabs,newlines,characters);

	// End of exersise code.
	printf("\n\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

