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
