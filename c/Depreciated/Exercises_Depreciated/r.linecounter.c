#include<stdio.h>

//Ryan Fleck - Learning C - Practice Exercise.
//From "The C Programming Language" 2e, K&R
//PROGRAM DESC:
//Line counter.

#define CHAPTER  01		
#define EXERCISE 00

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	//Beginning of exercise code:

	int c=0, nl=0;

  while(  (c=getchar()) != EOF  ){
		if(  c == '\n'  )
			++nl;
		}

  printf("Lines in input: %i\n", nl);


	//End of exersise code.
	printf("\n\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

