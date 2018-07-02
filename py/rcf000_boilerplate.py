#!/usr/bin/python3

# Ryan Fleck 2018

# Import Modules:
import sys

errs=0

try:
  import rcf_logs as rcf
  dbg = rcf.dbg
  rcf.intro("Program Name",1997)
except:
  print("[ "+'\033[91m'+"logs"+'\033[0m'+" ] Please download rcf_logs.py to this directory for enhanced logging.")
  def dbg(x,y,message):
    print("["+'\033[92m'+y.center(8)+'\033[0m'+"] "+message) 

dbg("good","init","Modules loaded.")


#Program


#Exit Message:
if( errs == 0 ):
  dbg("good","exit","Program completed successfully.")
else:
  dbg("warning","exit","Program completed with "+str(errs)+" errors.")
