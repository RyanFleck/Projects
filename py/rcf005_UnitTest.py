#!/usr/bin/python3

import rcf006_SimpleOps as prog 
#import rcf_logs as rcf
import unittest
#dbg = rcf.dbg #Usage: dbg("good|warning|failure","loc","message")

#dbg("good","init","Learning to use the UnitTest module...")

# Test program created as rcf006_SimpleOps.py, the program -> 'prog'
# print( prog.iterate(3) ) # Simple test passes.

class TestIterativeFunctions( unittest.TestCase ):
  
  def test_iterate(self):
    self.assertTrue(True)
    self.assertFalse(False)

  def test_reiterate(self):
    self.assertTrue(True)
    self.assertFalse(False)

  def test_deiterate(self):
    self.assertTrue(True)
    self.assertFalse(False)

class TestExponentialFunctions( unittest.TestCase ):
  
  def test_double(self):
    self.assertTrue(True)
    self.assertFalse(False)
  
  def test_square(self):
    self.assertTrue(True)
    self.assertFalse(False)
  
  def test_cube(self):
    self.assertTrue(True)
    self.assertFalse(False)

unittest.main()
