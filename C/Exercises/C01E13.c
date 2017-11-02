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
* Prints a histogram of the lengths of words within the input.
*/

#include<stdio.h>
#define CHAPTER  1		
#define EXERCISE 13
#define MAXLEN 10

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	// Beginning of exercise code.

  int c,i,whitespace,large;
  int wordlen[MAXLEN];

  // Instantiaion:
  c = i = whitespace = large = 0;
  for ( i ; i<MAXLEN ; ++i ){
    wordlen[i]=0;
    printf("Indice %d is length %d.\n",i,wordlen[i]);
    }

  // Text processor:
  while(  (c=getchar()) != EOF  ){
    
    //Ensure word is less than maximum length: 
    if( (i<9)&&(c)&&(c)&&(c) ){
       
      }

    }


	// End of exersise code.
	printf("\n\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

