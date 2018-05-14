#!/bin/bash
# -*- coding: utf-8 -*-
#  
#  libPFBSuseInst.sh
#  LibPurple-Facebook util for Debian and Opensuse.
#  
#  Copyright 2017 Ryan Fleck <rflec028@uottawa.ca>
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


sudo sh -c "echo 'deb http://download.opensuse.org/repositories/home:/jgeboski/xUbuntu_$(lsb_release -rs)/ /' >> /etc/apt/sources.list.d/jgeboski.list"
cd /tmp && wget  http://download.opensuse.org/repositories/home:/jgeboski/xUbuntu_$(lsb_release -rs)/Release.key
sudo apt-key add - < Release.key  
sudo apt-get update
sudo apt-get install purple-facebook
