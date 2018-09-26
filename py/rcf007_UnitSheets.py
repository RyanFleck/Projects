#!/usr/bin/python3
# Dynamically generates unittests based on table data.

import random
import unittest
#import selenium
#from selenium import webdriver
#from selenium.webdriver.support.ui import Select
#from selenium.webdriver.chrome.options import Options
import time
import sys
from rcf_lib import TableGlob
from rcf_logs import dbg

# Program Information and Options
revision = "1.1.1"
debug = False  # True enables verbose logging {and Chrome GUI}.


def iterate(x):
    x = x+1
    return x


class TestMethods(unittest.TestCase):

    def test_iterate(self):
        self.assertTrue(1 == 1)


if __name__ == '__main__':
    unittest.main()
