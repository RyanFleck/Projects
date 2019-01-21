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

int test_bubble_sort();
int test_multiples();

int main()
{
    cout << "\nHello, World!\n";

    test_bubble_sort();

    return 0;
}

int test_multiples() // Under development.
{
    cout << "\nAll multiples of 3 or 5 under 10\n";
    // int x[] = getMultiples(1,2,3);
    // printArray(x, (sizeof(x)/sizeof(*x)));
}

int test_bubble_sort()
{
    int x[9] = {3,2,6,2,1,56,7,0,12};

    cout << "\nWorking with array:\n";
    printArray(x,9);

    cout << "Bubble sort array.\n";
    bubbleSort(x,9);
    printArray(x,9);

    cout << "    Sum of this array: " << sumIntArray(x,9) << "\n\n";
    return 0;
}
