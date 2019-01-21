#include <iostream>
using namespace std;

int main()
{
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

    for(auto x: {
                "foo","bar","blatz"
            }) {
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
