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
#define EXERCISE 06

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	// Beginning of exercise code.
  
  int c;

  /*c = (getchar() != EOF);

  printf("c==0?: %d\n",  c==0  );

  printf("c==1?: %d\n",  c==1  );*/

  while((c = getchar()) != EOF)
    putchar(c);

  // End of exersise code.
	printf("\n\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

