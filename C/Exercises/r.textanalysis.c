#include<stdio.h>

//Ryan Fleck - Learning C - Practice Exercise.
//From "The C Programming Language" 2e, K&R
//PROGRAM DESC:
//Counter, per-line, returns info about the text file.

#define CHAPTER  01		
#define EXERCISE 00

int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);

	int c=0, lc=0, nl=0, totalc=0, spaces=0, periods=0;

  while(  (c=getchar()) != EOF  ){
    ++lc;

		if(  c == '\n'  ){
      printf("\nLine %i had %i spaces, %i periods and %i characters.",nl,spaces,periods,lc);
	    totalc=totalc+lc;
      lc=0;
      spaces=0;
      periods=0;
      ++nl;
      } 
    
    if(  c == ' '  )
			++spaces;
		

    if(  c == '.'  )
			++periods;

		}

  printf("\nLines in input: %i\n", nl);
  printf("Characters in input: %i\n", totalc);
	printf("\n\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

