#!/usr/bin/python3
#Ryan Fleck 2018

import sys
import fileinput

default_region = "Murica"

if(len(sys.argv) == 2):
    reg = str(sys.argv[1])
else:
    reg = default_region

print("Switching region to "+reg+":")
reg = "region: "+reg

config=open(r'modme.txt','r+')

line=-1
while(1):
    line+=1
    linedata = config.readline().split()
    if(linedata[0] == "region:"):
        print("Found on line "+str(line)+"!" + str(linedata))
        break
    else:
        


print(config.readlines())

#Program unfinished.

