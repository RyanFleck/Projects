#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

int functionTakesArray(int arr[]);
int functionTakesArrayPointer(int *arr);
// int functionReturnsArray(); // Not possible?
int * functionReturnsArrayPointer();

int main(){
    puts("Array + pointer experiment.");

    int one[4]; // Array of 4 ints.

    for(int x=0;x<4;x++){
        printf("one[%i] -> %i\n",x, one[x]);
    }

    // Hm, random data already exists in the array 'one'?

    int two[4] = { 0 }; // Set all elements to zero?

    for(int x=0;x<4;x++){
        printf("two[%i] -> %i\n",x, two[x]); // Yep. Strange.
    }

    // Pointer to an array:

    int three[] = { 12, 14, 19, 22, 84, 13 };
    int *p;

    p = three; // P now points to memaddr of three[0]

    for( int x=0;x<6;x++ ){
        printf("p -> i: %i\n",*p);
        p++;
    }
    
    //Hmmm... 

    int *p2;
    p2 = three;

    while( *p2 != NULL ){ // Ha, so THAT's how I see all my RAM...
        printf("p2 -> i: %i\n",*p2);
        p2++;
    }

    return 0;
}

int functionTakesArray(int arr[]){
    puts("functionTakesArray()");
    return 0;
}

int functionTakesArrayPointer(int *arr){
    puts("functionTakesArrayPointer()");
    return 0;
}

int * functionReturnsArrayPointer(){
    puts("functionReturnsArrayPointer()");
    int x[] = { 4 };
    int *xp = x;
    return xp;
}

