#!/usr/bin/python3

# Ryan Fleck 2018

#Console Colors
RESET = '\033[0m'
GOOD  = '\033[92m'
WARN  = '\033[93m'
FAIL  = '\033[91m'


def dbg(warntype, section, message):
  messageColor = warntype.upper()[0:4]
  TYPE = GOOD
  if(messageColor == "WARN"):
    TYPE = WARN
  elif(messageColor == "FAIL"):
    TYPE = FAIL

  print("[ "+TYPE+section.center(8)+RESET+" ] "+message)


'''Debugging messages:
rcf_print("good","init","Custom printing is functional.")
rcf_print("warning","bad","Custom printing is functional.")
rcf_print("failure","fail","Custom printing is functional.")
rcf_print("failure","nier","Custom printing is functional.")
rcf_print("good","deathpunk","Custom printing is functional.")
rcf_print("warning","neodimyum","Custom printing is functional.")
'''
