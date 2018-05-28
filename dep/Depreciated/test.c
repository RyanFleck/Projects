#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

/* THE C PROGRAMMING LANGUAGE
 * Kernighan/Ritchie 2ed
 * Ryan Fleck's Spaghetti File. */

int announceTest();

//Functions based on problems in the textbook:
int tempTable();
int tempTableAlternate();
int stdIOTest();


int main(){
  printf("C program 'test.c' compiled correctly.\nRunning test functions:\n");
  
  //CHAPTER ONE
  tempTable();
  tempTableAlternate();
  //stdIOTest(); 
	return 0;
}
int announceTest(char testName[]){
  printf( "\nFunction '%s' output:\n\n",testName );
  return 0;
}

//CHAPTER ONE FUNCTIONS

int tempTable(){ //(1.2) Prints deg F/deg C table for 0,20...200.
  announceTest("Fahrenheit to Centigrade converter");
  int fahr, celsius;
  int lower, upper, step;

  lower = 0;
  upper = 200;
  step = 20;

  fahr = lower;
  printf(  "TEMP CONVERSION:\nF:\tC:\n"  );
  while(fahr <= upper) {
    celsius = (  5.0/9 * (fahr-32)  );
    printf(  "%d\t%d\n", fahr, celsius  );
    fahr = fahr + step ;
  }

  return 0;
}

int tempTableAlternate(){ //(1.3) Temp table with for loop.
  announceTest("Fahrenheit to Centigrade converter w/ for loop");
  int fahr;
  printf(  "TEMP CONVERSION:\nF:\t   C:\n"  );
  for(  fahr=0 ; fahr<=200 ; fahr=fahr+20  ){
    printf( "%d\t%6.1f\n", fahr, ( (5.0/9.0)*(fahr-32) ) );
  } 
  return 0;
}

int stdIOTest(){
  announceTest("Standard input and output test.");
  int c;
  while((c = getchar())!= EOF){
    putchar(c);}
  return 0;
}	

//CURRENT PAGE: 15
