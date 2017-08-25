#include<stdio.h>

//Ryan Fleck - Learning C - Practice Exercise.
//From "The C Programming Language" 2e, K&R

#define CHAPTER  1		
#define EXERCISE 6

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	//Beginning of exercise code:

	int c;

	while( (c=getchar()) != EOF){
		putchar(c);
		}	
  if(c==EOF){
		printf("EOF Registered! EOF=%d\n",c);
		}else{
		printf("%d\n",c);    
    }

	//End of exersise code.
	printf("\n\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
  return 0;
}

