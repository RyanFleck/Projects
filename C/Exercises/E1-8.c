#include<stdio.h>

//Ryan Fleck - Learning C - Practice Exercise.
//From "The C Programming Language" 2e, K&R

#define CHAPTER  1		
#define EXERCISE 8

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	//Beginning of exercise code: Program counts blanks, tabs and newlines for a given input file.

  int c,
      bl, //Blanks
      tb, //Tabs
      nl; //Newlines

  while( (c=getchar()) != EOF ){
    if(c==' '){++bl;}
    if(c=='\t'){++tb;} 
    if(c=='\n'){++nl;}
    }

  printf("Blanks:%i\nTabs:%i\nNewlines:%i\n",bl,tb,nl);

	//End of exersise code.
	printf("\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

