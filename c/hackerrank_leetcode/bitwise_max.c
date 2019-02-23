#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
//Complete the following function.

void setNewMax(int *max, int candidate, int ceil)
{
    if (candidate > *max && candidate < ceil)
        *max = candidate;
}

void calculate_the_maximum(int n, int k)
{
    //Write your code here.
    int bitwise_max_and = 0;
    int bitwise_max_or = 0;
    int bitwise_max_xor = 0;

    int chkmax = n - 1;
    for (int a = 1; a <= chkmax; a++)
    {
        for (int b = a + 1; b <= n; b++)
        {
            // printf("a=%i, b=%i\n",a,b); // Replicates code instructions.
            setNewMax(&bitwise_max_and, a & b, k);
            setNewMax(&bitwise_max_or, a | b, k);
            setNewMax(&bitwise_max_xor, a ^ b, k);
        }
    }

    printf("%i\n%i\n%i",
           bitwise_max_and,
           bitwise_max_or,
           bitwise_max_xor);
}

int main()
{
    int n, k;

    scanf("%d %d", &n, &k);
    calculate_the_maximum(n, k);

    return 0;
}
