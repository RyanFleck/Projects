# Programming in C++

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/cpp](https://ryanfleck.github.io/cpp)
  

```cpp
#include <iostream>
int main(){
  std::cout << "Hello, C++!\n";
}
```


<br />



<br />

## What is C++?
C with a billion things stuck on. A whole different beast.

## Why I am Writing Programs in C++
To keep up with my friends in advanced programming courses at *uOttawa* at the time of writing.

Also, seeing as I'm no C++ *aficionado*, I saw that the hackerrank challenge for Kinaxis could only be written in C++, so I'm taking some notes and binge studying today.



## Core C++

Every C++ program must have **main**, the entry point. A nonzero value returned from `main()` indicates failure. Compile with `g++`.

```cpp
int main(){}
```

Simple standard output:
```cpp
#include <iostream>

int main(){
  // <<  is the PUT TO operator, and writes the second arg into the first.
  std::cout << "Hello, World!\n";
  // std::  specifies that cout is found in the standard library namespace.
  // cout  is the standard output stream.
}
```

Simple functions:
```cpp
#include <iostream>
using namespace std; //Methods can be called without specifying namespace.

double square(double x){
  return x*x;
}

void print_square(double x){
  cout << "The square of " << x << " is " << square(x) << ".\n";
}

int main(){
  cout << "Hello, World!\n";
  print_square(3);
  print_square(4);
  print_square(5);
  print_square(6);
}
```

Just like C. Neato.

Common types:

int | 0, 19
double | 3.14, 239.2
char | 'a', '\n'
string | "Hello, World."
bool | true, false

Simple input:

```cpp
#include <iostream>

int main() {
  int tip = 0;
  std::cout << "Enter tip amount: ";
  std::cin >> tip;
  std::cout << "You paid " << tip << " dollars.\n";
}
```

Simple random:

```cpp
#include <iostream>
#include <stdlib.h>
#include <ctime>

// 50% chance of returning true.
bool fiftyfifty() {
  srand (time(NULL));
  return( rand() % 2 == 0 );
}
```

For and while loops exist as they do in C.


```cpp
#include <iostream>
#include <vector>
#include <complex>
using namespace std;

// Standard types define a set of possible values and operations:
int i; //integer
bool b; //boolean
char c; //character
float fp; //floating_point_number
double dfp; //double_length_floating_point_number
auto ab = true; //AUTO assigns a type deduced from the initializer.

int main(){
  cout << "RCF003 - Types and Variables.\n";
  int x = 3;
  int y = 9;
  cout << "x="<< x <<"\n";
  cout << "y="<< y <<"\n";
  cout << "Plus x+y="<< x+y <<"\n";
  cout << "Minus x-y="<< x-y <<"\n";
  cout << "Multiply x*y="<< x*y <<"\n";
  cout << "Divide y/x="<< y/x <<"\n";
  cout << "Modulo x\%y="<< x%y <<"\n";


  complex<double> cz = 1;
  complex<double> cy {2.3,2.5};
  vector<int> v {1,2,3,4,5,6};
  int xz {3};

  //CONST - I promise not to change this value.
  //CONSTEXPR - to be evaluated at compile time (not runtime).
  const int numx = 12;
  constexpr double xam = 1.3*sqrt(numx);
}
```
Capturing simple input:
```cpp
#include <iostream>
using namespace std;

bool accept(){
  cout << "Question that warrants a binary response (y or n)?\n";
  char answer = 0;
  cin >> answer;

  if(answer=='y') return true;
  return false;

}

bool accept_switch(){
  cout << "Question that warrants a binary response (y or n)?\n";
  char answer = 0;
  cin >> answer;

  switch(answer){
    case 'y':
    case 'Y':
      return true;
    case 'n':
    case 'N':
      return false;
    default:
      cout << "I'll take that as a 'No'...\n";
      return false;
  }
  return false;

}

int main(){
  cout << "RCF004 - Simple cin user input.\n";

  /*
  if(accept()){
    cout << "Yes!";
  } else {
    cout << "No.";
  }//Whew! Robust! I like.
  */

  if(accept_switch()){
    cout << "TRUE returned.\n";
  } else {
    cout << "FALSE returned.\n";
  }//Whew! Robust! I like.
}
```

```cpp
#include <iostream>
using namespace std;

bool prompt(){
  int tries = 1;
  while( tries <= 3 ){
    cout << "Would you like to proceed? (y/n) >> ";
    char answer = 0;
    cin >> answer;

    switch( answer ){
      case 'y':
      case 'Y':
        cout << "Yes. Returning TRUE.\n";
        return true;
      case 'n':
      case 'N':
        cout << "No. Returning FALSE.\n";
        return false;
      default:
        cout << "Hm, didn't catch that...\n";
        ++tries;
        //Dump the rest of CIN? Extra chars mess up next loop(s).
    }
  }
  cout << "Hm, I guess that's a 'NO.'\n";
  return false;

}

int main(){
  cout << "RCF005 - Simple++ cin user input.\n";
  prompt();

  //Output:
  //  Would you like to proceed? (y/n) >> y
  //  Yes. Returning TRUE.
}
```

Simple pointers and arrays.
```cpp
#include <iostream>
using namespace std;

int main(){
  cout << "RCF006 - Pointers and Arrays\n";

  char v[6]; // Array of six characters.
  char* p;   // Pointer to a character (*).

  p = &v[3]; // p points to the third indice of v.
             // Unary prefix & = address of. (Or reference in intitialization?)
  int v1[] = {0,1,2,8,4,5,6,5,4,3,2,1};
  int v2[12];

  for(auto x:v1) cout << x << " ";
  cout << "\n";

  //This prints garbage integers, what is going on?
  for(auto x:v2) cout << x << " ";
  cout << "\n";

  for(auto x:{"foo","bar","blatz"}){
    cout << x << " ";
  }

  int* ip = &v1[3];
  cout << "Address of ip = " << ip << " and Value at address stored in ip = *ip = " << *ip << "\n";

  int ia[4] = {8,9,10,11}; //Array of 4 ints.
  int* iap = &ia[1]; //Pointer to an int.
  //int& iar = &ia[1]; //Reference to an int. (Like pointer but no * needed.
  int itf(float); //Function taking a float and returning an int.

  //double* pd = nullptr;
  //Link<Record>* lst = nullptr;
  //int x = nullptr;
}
```

## Competetive and Interview Programming in C++

After flunking my IBM interview and noting Kinaxis (and others,) require C++ skills, I decided to seriously pursue C++ as a language of choice for interviews, project euler questions, and hackerrank challenges.

**Resources:**
1. Competetive programmer's handbook. [PDF](https://github.com/RyanFleck/ryanfleck.github.io/raw/master/Resources/cpp.pdf)
2. Cracking the Coding Interview.

## My First Linked Project

`project.h` is used to provide all other methods to `main.cpp`.

```cpp
 #include <bits/stdc++.h>

// arithmetic.cpp
int add(int x, int y);
int subtract(int x, int y);

// basic_io.cpp
int printArrayFromCIN();
int grabIntFromCIN();

// bubble_sort.cpp
int bubbleSort(int *a, int len);
int printArray(int *a, int len);
```

`main.cpp`

```cpp
#include "project.h"

using namespace std;

int main()
{
    cout << "Hello, World!\n";

    int x[9] = {3,2,6,2,1,56,7,0,12};
    printArray(x,9);
    cout << "Bubble sort array.\n";
    bubbleSort(x,9);
    printArray(x,9);

    return 0;
}
```

`arithmetic.cpp`

```cpp
#include <bits/stdc++.h>
#include "project.h"

using namespace std;

int add(int x, int y)
{
    return x + y;
}

int subtract(int x, int y)
{
    return x - y;
}
```

`basic_io.cpp`

```cpp
#include "project.h"

using namespace std;

/*
 * Learning C++
 * Simple I/O functions.
 */

int printArrayFromCIN()
{
    string x;
    while ( cin >> x ) {
        cout << "Processing " << x << '\n';
    }
    return 0;
}

int grabIntFromCIN()
{
    int x = 0;
    cin >> x;
    return x;
}

string grabLineFromCIN()
{
    string s = "";
    getline(cin, s);
    return s;
}


```

`bubble_sort.cpp`

```cpp
#include "project.h"

using namespace std;

int bubbleSort(int *a, int len)
{
    for(int x=0; x<len; x++) {
        for(int y=0; y<(len-1); y++) {
            if(a[y] > a[y+1]) {
                swap(a[y],a[y+1]);
            }
        }
    }
    return 0;
}

int printArray(int *a, int len)
{
    cout << "  (";
    int terminus = len - 1;
    for(int x=0; x<len; x++) {
        cout << a[x];
        if( x != terminus ) cout << ", ";
    }
    cout << ")\n";
    return 0;
}
```

These files are compiled with a *Makefile*, but the command ends up being:

```sh
g++ -std=c++11 -O2 -Wall project.h arithmetic.cpp basic_io.cpp bubble_sort.cpp main.cpp -o project
```

Running the executable generates the following output:

```cpp
Hello, World!
  (3, 2, 6, 2, 1, 56, 7, 0, 12)
Bubble sort array.
  (0, 1, 2, 2, 3, 6, 7, 12, 56)
```
