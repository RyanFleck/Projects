#include<stdio.h>

//Ryan Fleck - Learning C - Practice Exercise.
//From "The C Programming Language" 2e, K&R
//PROGRAM DESC:
//

#define CHAPTER 01		
#define EXERCISE 15

#define LOWER 0
#define UPPER 300
#define STEP 20


int main(void){
	printf("RCF.TestProg.%d-%d.START\n\n",CHAPTER,EXERCISE);
	//Beginning of exercise code:

  int fahr = LOWER;

	printf("FAHRENHEIT TO CELSIUS TABLE:\nF:\tC:\n");

	while(fahr<=UPPER){
    printf("%i\t%i\n",fahr,(int)toCelsius(fahr));
    fahr = fahr + STEP;
    }






	//End of exersise code.
	printf("\n\nRCF.TestProg.%d-%d.END\n",CHAPTER,EXERCISE);
	return 0;
}

int toCelsius(int fahr){
  int celsius = (5.0/9.0)*(fahr-32);
  return celsius;
}

