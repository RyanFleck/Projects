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
* PROGRAM: Copies input to output, replacing sequential spaces with a single.
*/

#include<stdio.h>
#define CHAPTER  1		
#define EXERCISE 9

int main(void){
	printf("RCF.KR_Exercise.%d-%d.BEGIN\n\n",CHAPTER,EXERCISE);
	// Beginning of exercise code.
  
  int c;
  int flag; //Flag is 1 when a space is detected, 0 when regular char.

  c = getchar();

  while( c != EOF ){
    
    if( c != ' ' ){
    flag = 0;
    putchar(c);
    }

    else if(c==' ' && !flag){
      putchar(c);
      flag=1;
    }

    c = getchar();
  }
  
  
  
  
	// End of exersise code.
	printf("\n\nRCF.KR_Exercise.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

