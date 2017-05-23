#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#  fileIOTesting.py
#
#  Copyright 2017 Ryan Fleck <ryan.fleck@protonmail.com>
#
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License, or
#  (at your option) any later version.
#
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#
#  You should have received a copy of the GNU General Public License
#  along with this program; if not, write to the Free Software
#  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
#  MA 02110-1301, USA.
#
#
#	This program was built to test Python3's file management capabilities.
#	Tested within this program:
#		-Reading from and using REGEXs to attain input.
#		-Creating and saving to files of different formats.
#		-Organizing folders and filesystems.
#		-Organizing thousands of files into seperate folders
#		-
#
from docs import Docs

def main(args):
	#Standard documentation.
	d = Docs(args[0])
	d.printHeader()

	#Initialize
	
	
	
	
	
	
	
	
	d.printFooter()

if __name__ == '__main__':
    import sys
    sys.exit(main(sys.argv))
