#!/usr/bin/python3

# Ryan Fleck 2018
# State: UNFINISHED

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

# Adapted from "Python Playground", Mahesh Venkitachalam 2016, No Starch Press

# Imports:
import sys

try:
    import math
    import matplotlib.pyplot as plt
    import matplotlib.animation as animation
    import numpy as np
    from scipy.spatial.distance import squareform, pdist, cdist
    from numpy.linalg import norm
except BaseException:
    print(
        "[ " +
        '\033[91m' +
        "log" +
        '\033[0m' +
        " ] Please install prerequisite modules:\n- Numpy\n- Argparse\n- MatPlotLib\n- SciPy\n- rcf_logs.py")
    sys.exit()

try:
    import rcf_logs as rcf
    dbg = rcf.dbg
    print("\nBoid - Derivative work, Ryan Fleck 2018\n")
except BaseException:
    print(
        "[ " +
        '\033[91m' +
        "log" +
        '\033[0m' +
        " ] Please download rcf_logs.py to this directory for enhanced logging.")

    def dbg(x, y, message):
        print("[" + '\033[92m' + y.center(8) + '\033[0m' + "] " + message)

dbg("good", "init", "Prerequisites loaded.")

# Configuration
width, height = 640, 480
N = 100

# Compute boid start info
dbg("good", "init", "Computing positions and velocities.")
pos = [width / 2.0, height / 2.0] + 10 * np.random.rand(2 * N).reshape(N, 2)
angles = 2 * math.pi * np.random.rand(N)
vel = np.array(list(zip(np.sin(angles), np.cos(angles))))

# Boundaries for boids:
# Velocity preserved, boid appears on other side of map.


def applyBC(self):
    deltaR = 2.0
    for coord in self.pos:
        if coord[0] > width + deltaR:
            coord[0] = - deltaR
        if coord[0] < -deltaR:
            coord[0] = width + deltaR
        if coord[1] > height + deltaR:
            coord[1] = -deltaR
        if coord[1] < - deltaR:
            coord[1] = height + deltaR


fig = plt.figure()

ax = plt.axes(xlim=(0, width), ylim=(0, height))

pts, = ax.plot([], [], markersize=10, c='k', marker='o', ls='None')
beak, = ax.plot([], [], markersize=4, c='r', marker='o', ls='None')
#anim = animation.FuncAnimation(fig,tick,fargs=(pts,beak,boids), interval=50)

fig.plot()  # UNFINISHED.
