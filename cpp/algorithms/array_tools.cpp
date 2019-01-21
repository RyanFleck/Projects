#include "algorithms.h"

using namespace std;

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

