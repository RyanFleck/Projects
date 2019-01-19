#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the countingValleys function below.


def countingValleys(n, s):
    c = 0  # Counter
    e = 0  # Elevation
    vf = False  # valleyflag
    vc = 0  # valleycounter

    while c < n:

        # Save elevation data
        if s[c] == 'U':
            e = e + 1
        if s[c] == 'D':
            e = e - 1

        if e < 0 and not vf:
            vf = True

        if e >= 0 and vf
            vc += 1
            vf = False

        print(str(s[c]) + ", elevation = "+str(e))
        c += 1

    return vc


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    s = input()

    result = countingValleys(n, s)

    fptr.write(str(result) + '\n')

    fptr.close()
