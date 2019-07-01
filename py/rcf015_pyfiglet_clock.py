#!/usr/bin/python3

# A simple clock that uses figlet. Quite fun.

import pyfiglet
import time
import os
import sys

clear_cmd = 'clear'
f = pyfiglet.Figlet(font='5lineoblique')
if('win' in sys.platform):
    clear_cmd = 'cls'

while True:
    os.system(clear_cmd)
    now = time.strftime("%H %M %S", time.localtime())
    print(f.renderText(now))
    time.sleep(1)
