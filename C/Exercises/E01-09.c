#include<stdio.h>

//Ryan Fleck - Learning C - Practice Exercise.
//From "The C Programming Language" 2e, K&R

#define CHAPTER  1		
#define EXERCISE 9

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	//Beginning of exercise code: Program returns input with minimized whitespace.
  
  int c;
  int bl;

  while( (c=getchar()) != EOF ){
    if(c==' '){
      if(bl==0){putchar(c);}
      bl=1;
      }else{
      bl=0;
      putchar(c);
      }

    }  

	//End of exersise code.
	printf("\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

