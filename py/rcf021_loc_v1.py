#!/usr/bin/python3

# Takes file extension as first argument, counts lines of code.

import os
import sys
import re

def countLinesOfCode(extension):
    print(r'(.*\.{}$)'.format(extension))
    loc = 0
    fileregex = re.compile(r'(.*\.{}$)'.format(extension)) 
    for dirname, subdirs, filenames in os.walk(os.getcwd()):
        for filename in filenames:
            if fileregex.match(filename):
                lines = sum(1 for line in open(dirname+'/'+filename))
                print('> '+str(filename)+' => '+str(lines)+' lines.')
                loc = loc + lines

    print('\n>> '+str(loc)+' lines of '+str(extension))

try:
    countLinesOfCode(str(str(sys.argv[1]).strip().split()[0]))
except IndexError:
    print('Please provide an extension to count LoC for.')
