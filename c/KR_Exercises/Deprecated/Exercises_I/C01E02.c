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
#define CHAPTER  01		
#define EXERCISE 02

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	// Beginning of exercise code.
  
  printf("TEST \tTEST \b\b\b\bTEST \\TEST \"TEST \nTEST \aTEST \bTEST \cTEST \dTEST \eTEST \fTEST \gTEST \hTEST");
  
  printf("\n\nTEST\fING");

  printf("\n\nDown\fthe\frabbit\fhole");
  
	// End of exersise code.
	printf("\n\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

