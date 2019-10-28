#!/usr/bin/exec python3

'''
apt install libglfw3
pip3 install p5 numpy
'''

from p5 import stroke, circle, setup, draw, size, background, run
import numpy as np

'''
Boid brains.
'''


class Boid:
    '''A boid is a pack animal.'''

    def __init__(self, x, y):
        self.position = {'x': x, 'y': y}

    def show(self):
        stroke(255)
        circle((self.position["x"], self.position["y"]), radius=10)


'''
Main display logic.
'''

flock = [Boid(x=np.random.rand() * 600, y=np.random.rand() * 400)
         for _ in range(30)]


def setup():
    width = 600
    height = 400
    size(width, height)


def draw():
    background(30, 30, 47)

    for boid in flock:
        boid.show()


# Run the simulation.
run()

'''
Useful material:
https://pythontips.com/2013/08/04/args-and-kwargs-in-python-explained/
'''
