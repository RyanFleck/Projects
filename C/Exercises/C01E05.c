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
#define CHAPTER   01		
#define EXERCISE  05
#define STEP      20

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	// Beginning of exercise code.
  
  for( float f=300 ; f>=0 ; f=f-STEP  ){
    printf("%3.0f\t%3.2f\n",f, ((5.0/9.0)*(f-32)) );
    }

	// End of exersise code.
	printf("\n\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

