/*
 * C++ Algorithms: Bubble Sort
 *
 * Array sorting algorithm. O(n^2)
 *
 * All algorithms are currently compiled and tested in algo_main.cpp,
 * as I learn more C++ the running/testing system will allow test runs
 * of single algorithms by name. Currently test runs are seperated as
 * functions within algo_main.cpp, and need to be enabled/disabled.
 *
 */

#include "algorithms.h"

using namespace std;

int bubbleSort(int *a, int len)
{
    for(int x=0; x<len; x++) {
        for(int y=0; y<(len-1); y++) {
            if(a[y] > a[y+1]) {
                swap(a[y],a[y+1]);
            }
        }
    }
    return 0;
}

