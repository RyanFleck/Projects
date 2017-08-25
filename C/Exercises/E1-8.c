#include<stdio.h>

//Ryan Fleck - Learning C - Practice Exercise.
//From "The C Programming Language" 2e, K&R

#define CHAPTER  1		
#define EXERCISE 8

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	//Beginning of exercise code: Program counts blanks, tabs and newlines for a given input file.

  int c=0,
      bl=0, //Blanks
      tb=0, //Tabs
      nl=0; //Newlines

  while( (c=getchar()) != EOF ){
    if(c==' '){++bl;  printf("Processed: Blank.\tTotal Blanks: %i\n",bl);} 
    if(c=='\t'){++tb; printf("Processed: Tab. \tTotal Tabs: %i\n",tb);} 
    if(c=='\n'){++nl; printf("Processed: Newline. \tTotal Newlines: %i\n",nl);}
    }

  printf("\nItems in file:\nBlanks:%i\nTabs:%i\nNewlines:%i\n",bl,tb,nl);

  //I apologize for the verbosity, but I had an error where 'nl' would start counting from 3700.

	//End of exersise code.
	printf("\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

