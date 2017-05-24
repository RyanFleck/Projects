#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
#  docs.py
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
class Docs:
	def __init__(self,programName="Program"):
		self.program = programName
		self.name = "Ryan Fleck"
		self.email = "ryan.fleck@protonmail.com"
		self.job = "Computer Engineering Student"


	def printHeader(self):
		print("\nThis program, '"+self.program+"', created by "+self.name+".")
		print("Programmer can be contacted at "+self.email)
		print("Currently, programmer is a "+self.job+".\n")
		print("Copyright 2017 "+self.name+" under the GNU GPL 2+. See code for details.\n\n")
		print(" PROGRAM START ".center(80,'='))
		print("")

	def printFooter(self):
		print("")
		print(" PROGRAM END ".center(80,'='))
