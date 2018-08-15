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
