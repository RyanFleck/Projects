/*
 *  rcf003_conditionals_loops.c - Tests if/else, while and for loops. 
 *  Copyright (C) 2018 Ryan Fleck under the GNU GPLv3.
 */

#include<stdio.h> 

int main(int argc, char** argv){

  int x = 4;

  //If
  if (30 > x && 40 < x) {
    puts("...If you can see this, try turning the universe OFF, then ON."); 
  }else{
    puts("Systems functioning according to conventional logic.");
  }

  printf("Whoo, numbers! 1, 2, 3, %d",x); 
  
  //While
  while ( x < 100 ) {
    printf(", %d",++x); 
  }
 
  //For
  for ( int y=10; y > 0; y-- ){
    printf("\n\n%d bottles of beer on the wall, %d bottles of beer!",y,y);
    printf("\nTake one down, pass it around, %d bottles of beer on the wall!",(y-1));
  }

  return 0;
}
