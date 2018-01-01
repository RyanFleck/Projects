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
* PROGRAM: Copies input to output, replacing some keys with characters:
* -Tabs replaced with \t
* -Backspaces replaced with \b
* -Backslashes replaced with \\
*/

#include<stdio.h>
#define CHAPTER  1		
#define EXERCISE 10

int main(void){
	printf("RCF.KR_Exercise.%d-%d.BEGIN\n\n",CHAPTER,EXERCISE);
	// Beginning of exercise code.
  
  int c;

  while((c=getchar()) != EOF){
    
    putchar(c); //I'm not sure how to 'type' a backspace. I'll come back.
  }

	// End of exersise code.
	printf("\n\nRCF.KR_Exercise.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

