#!/usr/bin/python3

# Ryan Fleck 2018 

# Requirements:
# - numpy
# - matplotlib
# - argparse
# - scipy

# Goals:
# - Render boids.
# - Update positions and velocities of boids based on these parameters:
#   - Keep minimum distance between boids.
#   - Point each boid in the average direction of those around it.
#   - Move each boid towards the center of mass of those around it.

#Imports:
import sys

try:
  import math
  import numpy as np
except:
  print("[ "+'\033[91m'+"log"+'\033[0m'+" ] Please install prerequisite modules.")
  sys.exit()

try:
  import rcf002_logs
except:
  print("[ "+'\033[91m'+"log"+'\033[0m'+" ] Please download rcf002_logs.py to this file for enhanced logging.")
  def dbg(x,y,message):
    print("[ "+'\033[91m'+"log"+'\033[0m'+" ] "+message) 


#Console Colors
RESET = '\033[0m'
GOOD  = '\033[92m'
WARN  = '\033[93m'
FAIL  = '\033[91m'

#Configuration
width, height = 640,480
N = 100

#Compute boid start info
print("[ "+GOOD+"init"+RESET+" ] Compute positions and velocities...")
pos = [width/2.0, height/2.0] + 10*np.random.rand(2*N).reshape(N,2)
angles = 2*math.pi*np.random.rand(N)
vel = np.array(list(zip(np.sin(angles), np.cos(angles))))
