#include <stdio.h>

typedef struct {
    float x;
    float y;
    float z;
} vec;

vec addVec();
int helloLoop();

int main(int argc, char** argv) {
    puts("Hello, World!");

    vec a;
    a.x = 1;
    a.y = 2;
    a.z = 3;

    vec b;
    b.x = 4;
    b.y = 3;
    b.z = 6;

    vec c = addVec(a,b);

    printVec(a);
    printVec(b);
    printVec(c);

    /*
     * Just a little code to satisfy the bonus marks section on this page:
     *   www.buildyourownlisp.com/chapter3_basics
     *  
     */

    puts("Bonus Marks:");

    // 5 Hello, World with for loop:
    for(int i=0; i < 5; i++){
        printf("for\t %i Hello, World!\n",(i+1));
    }
    
    // 5 Hello, world with while loop:
    int j = 0;
    while( j < 5 ){
        j++;
        printf("while\t %i Hello, World!\n",j);
    }

    // function helloLoop defined below
    helloLoop(3);
    helloLoop(4);

    /* What other types are there in C?
     *
     * Fundamental Types:
     *  - Integers
     *  - Floating Points
     *  - Characters
     *
     * Derived Types:
     *  - Arrays
     *  - Pointers
     *  - Structures
     *  - Enumarations
     *
     */

    int x, y, z;
    float g, h, i;  // 4 bytes, 6 digit precision.
    double j, k, l; // 8 Bytes, 14 digit precision.

    long double m, n; // long can increase the size of numbers.  
    short float l, o; // short can decrease the size of numbers. 
    unsigned int p; // Can only hold positive numbers, but x^2 more.
    const int r; // Cannot be changed later.
    
    char q; // 1 byte character.

    // What other conditional operators are there other than >, < ?


    // What other mathematical operators are there other than +, - ?


    // What is the += operator, and how does it work?


    // What is the do loop, and how does it work?


    // What is the switch statement and how does it work?


    // What is the break keyword and what does it do?


    // What is the continue keyword and what does it do?


    // What does the typedef keyword do exactly?
    //  As seen above when defining vec, a 3-dimensional vector, typedef
    //  enables the creation and renaming of builtin types.

    return 0;
}

vec addVec(vec a, vec b) {
    vec c;
    c.x = a.x + b.x;
    c.y = a.y + b.y;
    c.z = a.z + b.z;
    return c;
}

int printVec(vec vecA) {
    printf("Vector: %f %f %f\n", vecA.x, vecA.y, vecA.z);
}

int helloLoop(int n){
    printf("Hello, World %i Times:\n", n);
    for(int i=0; i < n; i++){
        printf("func\t %i Hello, World!\n",(i+1));
    }
}
