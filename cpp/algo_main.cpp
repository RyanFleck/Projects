/* 
 * C++ Algorithms: Main
 *
 * Contains test cases for all other algo_xyz.cpp files.
 *
 * All algorithms are currently compiled and tested in algo_main.cpp,
 * as I learn more C++ the running/testing system will allow test runs
 * of single algorithms by name. Currently test runs are seperated as
 * functions within algo_main.cpp, and need to be enabled/disabled.
 *
 */

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
