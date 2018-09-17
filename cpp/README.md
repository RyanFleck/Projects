# Ryan's C++ Manual

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual on [ryanfleck.github.io/cpp](https://ryanfleck.github.io/cpp)
  
[Hello World:](http://www.catb.org/jargon/html/H/hello-world.html)

```cpp
#include <iostream>
int main(){
  std::cout << "Hello, World!\n";
}
```


## What is C++?

## Why I am Writing Programs in C++

## Core C++

Every C++ program must have **main**, the entry point. A nonzero value returned from `main()` indicates failure.

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
