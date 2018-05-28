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
* Simple Celsius to Fahrenheit conversion table generator.
*/

#include<stdio.h>
#define CHAPTER  01		
#define EXERCISE 04

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	// Beginning of exercise code.
  
  float fht, cls;
  int lower, upper, step;

  fht = 0;
  lower = -100;
  upper = 100;
  step = 20;

  cls = lower;

  printf("Temperature Conversion Table:\nCel:\tFahr:\n");

  while (  cls <= upper  ){
    fht = ((9.0/5.0)*cls)+32;
    printf("%3.0f\t%6.2f\n", cls, fht);
    cls = cls + step; 
    }  

	// End of exersise code.
	printf("\n\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

