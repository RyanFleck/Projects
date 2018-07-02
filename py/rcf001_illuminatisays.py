#!/usr/bin/python3

# Ryan Fleck 2018

# Import Modules:
import sys
import os 

errs=0

try:
  import rcf_logs as rcf
  dbg = rcf.dbg
  rcf.intro("Illuminati Says", 2018)
except:
  print("[ "+'\033[91m'+"logs"+'\033[0m'+" ] Please download rcf_logs.py to this directory for enhanced logging.")
  def dbg(x,y,message):
    print("["+'\033[92m'+y.center(8)+'\033[0m'+"] "+message) 

#dbg("good","init","Modules loaded.")


def hr():
  print("*"*int(os.popen('stty size', 'r').read().split()[1].strip()))

step = 3 
levels = 13
screen_width =  int(os.popen('stty size', 'r').read().split()[1].strip())
#dbg("warning","debug",str(screen_width))
slogan = "GLOBO-CAPITOL HEAVY INDUSTRIES"

print("|".center(screen_width))
print("- * -".center(screen_width))

# Basic triangle print:
while step < (1+2*levels):
 print(("*"*step).center(screen_width))
 step+=2

print("\n" + slogan.center(screen_width) + "\n" 
  + (len(slogan)*"=").center(screen_width)+"\n\n")


#print("FHI".center(screen_width,"="))
