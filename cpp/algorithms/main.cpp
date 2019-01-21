#include "algorithms.h"

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
