#include <stdio.h>

//RCF - The 'Arrays' program from K&R 1.6

int main(){ //Counts digits, whitespace and others.
  printf("RCF - K&R Arrays Demo START:\n\n");


  //Instantiate variables.
  int c, i, nwhite, other;
  int ndigit[10];

  //Initialize all vars to 0.
  c= i= nwhite= other= 0; 
  
  //Clear array.
  for ( i=0; i<10; ++i ){
    ndigit[i] = 0;
  }

  //Cycle through words in input.
  while ( (c=getchar()) != EOF ){
    if ( c >= '0' && c <= '9' ){
      ++ndigit[ c-'0' ]; //Increments 0-9 by 1.
    } else if ( c == ' ' || c == '\n' || c == '\t' ){
      ++nwhite;
    } else {
      ++other;
    }
  }
  
  //Recite counts of each digit in input:
  printf("\n\nRCF - Digits in input - DIGIT:INSTANCES\n");
  for ( i=0; i<10; ++i ){
    printf(" %d:%d ", i, ndigit[i] );
  }

  printf("\n\nRCF - Others in input\nWhitespace: %d\nOther: %d",nwhite,other);



  return 0;
}
