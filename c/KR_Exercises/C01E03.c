#include<stdio.h>
#define CHAPTER  1		
#define EXERCISE 3

int main(void){
	printf("\nK&R Exercise %d.%d\n\n",CHAPTER,EXERCISE);
 
    float f, c, lower, upper, step;

    lower = -100;
    upper = 100;
    step = 10;

    f = lower;

    printf("  F\t   C\n");    

    while( f <= upper ){
        c = (5.0 / 9.0) * (f - 32.0);
        printf("%3.0f\t%6.1f\n",f,c);
        f = f + step;
    }
 
	return 0;
}

