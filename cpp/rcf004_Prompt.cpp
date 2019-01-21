#include <iostream>
using namespace std;

bool accept()
{
    cout << "Question that warrants a binary response (y or n)?\n";
    char answer = 0;
    cin >> answer;

    if(answer=='y') return true;
    return false;

}

bool accept_switch()
{
    cout << "Question that warrants a binary response (y or n)?\n";
    char answer = 0;
    cin >> answer;

    switch(answer) {
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

int main()
{
    cout << "RCF004 - Simple cin user input.\n";

    /*
    if(accept()){
      cout << "Yes!";
    } else {
      cout << "No.";
    }//Whew! Robust! I like.
    */

    if(accept_switch()) {
        cout << "TRUE returned.\n";
    } else {
        cout << "FALSE returned.\n";
    }//Whew! Robust! I like.
}
