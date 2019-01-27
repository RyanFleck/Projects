#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the jumpingOnClouds function below.


def jumpingOnClouds(c):

    cloud = 0
    jumps = 0
    num_clouds = len(c)

    while cloud + 1 < num_clouds:
        if cloud + 2 < num_clouds and c[cloud + 2] != 1:
            cloud = cloud + 2
            jumps += 1
            continue
        else:
            cloud = cloud + 1
            jumps += 1

    return jumps
