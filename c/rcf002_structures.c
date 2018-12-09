/*
 *  rcf002_structures.c - Implements a simple 3D-Point.
 *  Copyright (C) 2018 Ryan Fleck under the GNU GPLv3.
 */

//#include<math.h>
#include<stdio.h>

typedef struct {
    float x;
    float y;
    float z;
} vector3;

int printVector3(vector3 x)
{
    printf("VECTOR: %f, %f, %f", x.x, x.y, x.z);
    return 0;
}

int main(int argc, char **argv)
{
    vector3 a;
    a.x = 3;
    a.y = 4;
    a.z = 5;

    printVector3(a);

    return 0;
}
