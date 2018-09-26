#!/usr/bin/python3

import rcf006_SimpleOps as prog
#import rcf_logs as rcf
import unittest
# dbg = rcf.dbg #Usage: dbg("good|warning|failure","loc","message")

#dbg("good","init","Learning to use the UnitTest module...")

# Test program created as rcf006_SimpleOps.py, the program -> 'prog'
# print( prog.iterate(3) ) # Simple test passes.


class TestIterativeFunctions(unittest.TestCase):

    def test_iterate(self):
        self.assertTrue(prog.iterate(1) == 2)
        self.assertTrue(prog.iterate(1) != 3)

    def test_reiterate(self):
        self.assertTrue(prog.reiterate(3) == 4)
        self.assertTrue(prog.reiterate(5) == 6)

    def test_deiterate(self):
        self.assertTrue(prog.deiterate(6) == 5)
        self.assertTrue(prog.deiterate(1) == 0)


class TestExponentialFunctions(unittest.TestCase):

    def test_double(self):
        self.assertTrue(prog.double(2) == 4)
        self.assertTrue(prog.double(4) == 8)

    def test_square(self):
        self.assertTrue(prog.square(4) == 16)

    def test_cube(self):
        self.assertTrue(prog.cube(4) == 64)


class TestRandomFunctions(unittest.TestCase):

    def test_questionable(self):
        self.assertTrue(prog.questionable(4) != 4)

    # UnitTest stops at the first failure, I guess...
    def test_questionable_f2(self):
        self.assertTrue(prog.questionable(4) == 4)

    def test_questionable_f1(self):
        self.assertTrue(prog.questionable(4) == 4)


unittest.main()
