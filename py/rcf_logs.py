#!/usr/bin/python3

# Ryan Fleck 2018

import os

# Console Colors
RESET = '\033[0m'
GOOD = '\033[92m'
WARN = '\033[93m'
FAIL = '\033[91m'
TYPE = ''


def dbg(enable, warntype, section, message):
    if enable:
        messageColor = warntype.upper()[0:4]
        TYPE = GOOD
        if(messageColor == "WARN"):
            TYPE = WARN
        elif(messageColor == "FAIL"):
            TYPE = FAIL

        print("\t["+TYPE+section.center(8)+RESET+"] "+message)

#screen_width = int(os.popen('stty size', 'r').read().split()[1].strip())


def intro(program, year):
    print("\n"+str(program)+" - Copyright (C) " +
          str(year)+" Ryan Fleck <ryan.fleck@pm.me>")
    # GPL
    print("This program is Free Software, distributed under the GNU GPL v3.")
    print("Refer to "+GOOD+"gpl.txt"+RESET +
          " for terms of use and redistribution information.\n")


'''Debugging messages:
rcf_print("good","init","Custom printing is functional.")
rcf_print("warning","bad","Custom printing is functional.")
rcf_print("failure","fail","Custom printing is functional.")
rcf_print("failure","nier","Custom printing is functional.")
rcf_print("good","deathpunk","Custom printing is functional.")
rcf_print("warning","neodimyum","Custom printing is functional.")
'''
