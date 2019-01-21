/* 
 * C++ Algorithms: Array Tools 
 *
 * Tools for debugging and visualizing arrays.
 *
 * All algorithms are currently compiled and tested in algo_main.cpp,
 * as I learn more C++ the running/testing system will allow test runs
 * of single algorithms by name. Currently test runs are seperated as
 * functions within algo_main.cpp, and need to be enabled/disabled.
 *
 */

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

