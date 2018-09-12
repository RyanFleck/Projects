#!/usr/bin/python3
# Test program rcf006_SimpleOps.py
# Tested in program rcf005_UnitTest.py

import random
import unittest

def iterate(x):
  x = x+1
  return x

def reiterate(x):
  x = x+1
  return x

def deiterate(x):
  x = x-1
  return x

def double(x):
  x = x*2
  return x

def square(x):
  x = x*x
  return x

def cube(x):
  x = x**3
  return x

def questionable(x):
  x = x*random.random()*2
  return x

'''
print( iterate(3) )
print( reiterate(3) )
print( deiterate(3) )
print( double(3) )
print( square(3) )
print( cube(3) )
'''

class TestMethods(unittest.TestCase):

  def test_iterate(self):
    self.assertTrue( 1 == 1 )

if __name__ == '__main__':
  unittest.main()
