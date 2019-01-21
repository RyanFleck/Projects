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

int main()
{
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
