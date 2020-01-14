#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the repeatedString function below.


def repeatedString(s, n):
    s_len = len(s)
    if s_len > n:
        return countInStr(s, n)
    else:
        s_count = countInStr(s, s_len)
        s_mult = math.floor(n/s_len)
        count = s_count * s_mult
        print("Can fit "+str(s_mult)+" iterations in.")
        remaining_length = n - s_mult*s_len
        print("Remaining length: "+str(remaining_length))
        count += countInStr(s, remaining_length)
        return count


def countInStr(s, l):
    print("String length: "+str(len(s))+" l: "+str(l))
    x = 0
    count = 0
    while x < l:
        print(str(s[x])+" == a ?")
        if s[x] == 'a':
            count += 1

        x += 1

    print("Counted "+str(count)+" in string.")
    return count
