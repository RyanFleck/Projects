#!/usr/bin/exec python3

'''
apt install libglfw3
pip3 install p5 numpy
'''

from p5 import stroke, circle, setup, draw, size, background, run, Vector
import numpy as np

speedLimit = 9
width = 600
height = 400

'''
Boid brains.
'''


class Boid:
    '''A boid is a pack animal.'''

    def __init__(self, x, y):
        self.position = Vector(x, y)
        self.velocity = Vector(*np.random.rand(2))
        self.acceleration = Vector(*np.random.rand(2))

    def show(self):
        stroke(255)
        circle((self.position.x, self.position.y), radius=10)

    def react(self, *otherBoids):
        for boid in otherBoids:
            

    def update(self):
        self.position += self.velocity
        self.velocity += self.acceleration

        # Wrap X
        if self.position.x > width:
            self.position.x = 0
        elif self.position.x < 0:
            self.position.x = width

        # Wrap Y
        if self.position.y > height:
            self.position.y = 0
        elif self.position.y < 0:
            self.position.y = height

        # Limit Speed
        if np.linalg.norm(self.velocity) > speedLimit:
            self.velocity = self.velocity / \
                np.linalg.norm(self.velocity) * speedLimit


'''
Main display logic.
'''

flock = [Boid(x=np.random.rand() * 600, y=np.random.rand() * 400)
         for _ in range(30)]


def setup():
    size(width, height)


def draw():
    background(30, 30, 47)

    for boid in flock:
        boid.show()
        boid.update()


# Run the simulation.
run()


'''
Tutorial:
https://medium.com/better-programming/boids-simulating-birds-flock-behavior-in-python-9fff99375118

Useful material:
https://pythontips.com/2013/08/04/args-and-kwargs-in-python-explained/
'''
