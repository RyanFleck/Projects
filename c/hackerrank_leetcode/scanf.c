#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
    int a, b;
    float c, d;
    scanf("%i %i", &a, &b);
    scanf("%f %f", &c, &d);

    printf("%i %i\n%.1f %.1f\n", a + b, a - b, c + d, c - d);

    return 0;
}
