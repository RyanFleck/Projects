#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the equalizeArray function below.


def equalizeArray(arr):
    x = {}

    for elem in arr:
        if elem in x:
            x[elem] += 1
        else:
            x[elem] = 1

    greatest_val = -1
    greatest_key = -1

    for elem in x:
        if x[elem] > greatest_val:
            greatest_val = x[elem]
            greatest_key = elem

    # Final count
    c = 0
    for elem in x:
        if elem != greatest_key:
            c += x[elem]

    return c
