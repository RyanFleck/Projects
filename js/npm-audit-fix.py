#!/usr/bin/python3

# Script to brute-force silence annoying github issues.
# I sure hope you know what you are doing.

import os

for dirname, subdirs, filenames in os.walk(os.getcwd()):
    if 'node_modules' not in dirname:
        if 'package.json' in filenames:
            os.system("rm package-lock.json")
            print("\nDirectory " + dirname + " is an NPM project.")
            os.chdir(dirname)
            print(os.getcwd())
            print("NPM UPDATE:")
            os.system("npm update")
            print("NPM AUDIT:")
            os.system("npm audit fix --force")


print("RUN ALL UNIT TESTS!")