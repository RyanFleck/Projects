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
*
* PROGRAM: Counts blanks, tabs and newlines from input.
*/

#include<stdio.h>
#define CHAPTER  1		
#define EXERCISE 8

int main(void){
	printf("RCF.KR_Exercise.%d-%d.BEGIN\n\n",CHAPTER,EXERCISE);
	// Beginning of exercise code.
  
  int c, nl, bl, tb;

  nl = bl = tb = 0;
  

  while (  (c = getchar()) != EOF  ){
    if(c == '\n'){
      ++nl;
    }else if( c == '\t'){
      ++tb;
    }else if( c == ' '){
      ++bl;
    }
  }
  printf("\nContents:\n%d new lines\n%d blanks\n%d tabs\n",nl,bl,tb);
  
  
  
  
  
	// End of exersise code.
	printf("\n\nRCF.KR_Exercise.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

