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
* PROGRAM: Verify that getchar != EOF is 0 or 1.
*/

#include<stdio.h>
#define CHAPTER  1		
#define EXERCISE 6

int main(void){
	printf("RCF.KR_Exercise.%d-%d.BEGIN\n\n",CHAPTER,EXERCISE);
	// Beginning of exercise code.
  
  int c;

  c = getchar();
  while( c != EOF ){
    putchar(c);
    c = getchar();
  }
  
  if( c==0 ){
    printf("EOF = 0");
  }
  else if ( c==1 ){
    printf("EOF = 1");
  }
  else{
    printf("EOF != 0 or 1"); //This always triggers.
  }
 
  printf("\nEOF = %d",c);
  
  
	// End of exersise code.
	printf("\n\nRCF.KR_Exercise.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

