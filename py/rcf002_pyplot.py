#!/usr/bin/python3

# Ryan Fleck 2018 

import sys

try:
  import matplotlib.pyplot as plt
except:
  print("[ "+'\033[91m'+"log"+'\033[0m'+" ] Please install prerequisite modules: matplotlib")
  sys.exit()

try:
  import rcf_logs
  dbg = rcf_logs.dbg
except:
  print("[ "+'\033[91m'+"log"+'\033[0m'+" ] Please download rcf_logs.py to this directory for enhanced logging.")
  def dbg(x,y,message):
    print("["+'\033[92m'+y.center(8)+'\033[0m'+"] "+message) 


# PyPlot Experiment:

plt.plot([1,2,3,4])
dbg("good","done","Generated plot one.")


X = [590,540,740,130,810,300,320,230,470,620,770,250]
Y = [32,36,39,52,61,72,77,75,68,57,48,48]
plt.scatter(X,Y)
dbg("good","done","Generated plot two.")


dbg("good","disp","Displaying plot two.")
plt.show()
