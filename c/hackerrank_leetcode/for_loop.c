#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
    int a, b;
    char *x[10];

    scanf("%d\n%d", &a, &b);

    for (int i = a; i <= b; i++)
    {
        switch (i)
        {
        case 1:
            *x = "one";
            break;
        case 2:
            *x = "two";
            break;
        case 3:
            *x = "three";
            break;
        case 4:
            *x = "four";
            break;
        case 5:
            *x = "five";
            break;
        case 6:
            *x = "six";
            break;
        case 7:
            *x = "seven";
            break;
        case 8:
            *x = "eight";
            break;
        case 9:
            *x = "nine";
            break;
        default:
            if (i > 9)
            {
                if (i % 2 == 0)
                {
                    *x = "even";
                }
                else
                {
                    *x = "odd";
                }
            }
        }
        printf("%s\n", *x);
    }

    return 0;
}
