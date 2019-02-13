#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
    int arr_len;
    scanf("%d", &arr_len);
    int acc = 0;

    for (int x = 0; x < arr_len; x++)
    {
        int temp;
        scanf("%d", &temp);
        acc += temp;
    }

    printf("%d", acc);

    return 0;
}