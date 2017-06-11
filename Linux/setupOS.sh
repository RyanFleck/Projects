#!/bin/bash
# -*- coding: utf-8 -*-
#
#  setupOS.sh - shell script to configure Fedora 24 and above.
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

echo "Fedora 24+ setup script."
echo "Running and setting permissions for $USER."

#Simple superuser check.
if ! [ $(id -u) = 0 ]; then 
	echo "ERROR: Not root! Please rerun with su -c or sudo."
	echo "(Type 'sudo !!' to immediately rerun as superuser.)"
	exit 1
fi

#Initial update to ensure current OS.
echo "Updating packages using dnf."
dnf distro-sync -y

#Install rpmfusion repos and favourite packages.
echo "Adding new repos and installing favourites..."
dnf install -y https://download1.rpmfusion.org/free/fedora/rpmfusion-free-release-$(rpm -E %fedora).noarch.rpm https://download1.rpmfusion.org/nonfree/fedora/rpmfusion-nonfree-release-$(rpm -E %fedora).noarch.rpm
dnf distro-sync -y
dnf install -y vim f25-backgrounds-extras-gnome geany geany-themes gnome-tweak-tool gnome-shell-extension-openweather gnome-books transmission eclipse firefox arduino java-1.8.0-openjdk nautilus-open-terminal pidgin purple-facebook dropbox terminus-fonts terminus-fonts-console dconf-editor ruby-devel

#Install dev tools and libraries.
#Kept seperate so specific groups can be disabled for lite install.
#dnf groupinstall -y 'Development Tools'
#dnf groupinstall -y 'RPM Development Tools'
#dnf groupinstall -y 'C Development Tools and Libraries'
#dnf groupinstall -y 'Design Suite' #Heavy.
#dnf groupinstall -y 'Engineering and Scientific' #Heavy.

#Configure git.
git config --global user.name "Ryan Fleck"
git config --global user.email "ryan.fleck@protonmail.com"
git config --global core.editor vim
git config --global credential.helper 'cache --timeout=7200'
echo "Saved git settings:"
git config --list


#TODO: Configure gnome-shell and tweaks.
  #Set global dark theme.
  #Configure extensions
  #Set fonts, hinting and antialiasing.
  #Set mouse acceleration profile to flat.
  #Power button does nothing.
  #Focus mode: Mouse.
  #Enable Maximize/Minimize buttons.
  #Set wallpaper.
  #Set text editor color scheme to Cobalt.
  
#TODO: Configure gnome-terminal.
  #Set custom font: Terminus.
  #Set custom color: White on Black.
  #Disable scrollbar.
  #Disable menubar.
  
#TODO: Configure Eclipse.
  #Change color scheme.
  #Set default workspace to 'experiments.'

#TODO: Configure pidgin.
  #Add facebook account using purple-facebook.
  #Disable annoying features.
  
#TODO: Configure geany.
  #Set custom font and colors.
  #Set python build commands.
  #Set java build commands.
  #Enable backups.

#TODO: Configure arduino
usermod -a -G dialout,lock $USER
  #Change default board and port.



#Clean packages?
echo "Done! Reboot reccomended."
