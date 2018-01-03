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
* PROGRAM: Prints C -> F table.
*/

#include<stdio.h>
#define CHAPTER  0		
#define EXERCISE 0

int main(void){
	printf("RCF.KR_Exercise.%d-%d.BEGIN\n\n",CHAPTER,EXERCISE);
	// Beginning of exercise code.
  
  int lower, upper, step;
  float degf, degc;

  lower=0;
  upper=300;
  step=20;

  degc=lower;

  printf("C\tF\n");

  while( degc <= upper ){
    degf = ((9.0/5.0)*degc)+32;
    printf("%3.0f\t%3.3f\n",degc,degf);
    degc=degc+step;
  }
  
  
  
	// End of exersise code.
	printf("\n\nRCF.KR_Exercise.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}
