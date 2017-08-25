#include<stdio.h>

//Ryan Fleck - Learning C - Practice Exercise.
//From "The C Programming Language" 2e, K&R

#define CHAPTER  1		
#define EXERCISE 10

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
  //Yeesh, this one was kind of a stretch. I couldn't figure out how to enter 'backspace characters.' another time.	

  int c=0;

  while( (c=getchar()) != EOF ){
    if(c=='\b'){printf(" backspace ");}
    else if(c=='\t'){printf(" tab ");} 
    else if(c=='\n'){printf(" newline ");}
    else{putchar(c);}
    }

	//End of exersise code.
	printf("\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

