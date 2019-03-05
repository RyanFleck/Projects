# Programming in Shell Scripting

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/sh](https://ryanfleck.github.io/sh)
  

```bash
echo "Hello, BASH!"
```

<br />



<br />

## Why I am Writing Shell Scripts
'Cause having your computer do something you do daily *on your behalf* is fantastic.

## What is Bash Shell Scripting?

Bash is a *Unix Shell*, allowing a user to interact with an operating system by entering commands.

**Shell Scripting** is to write *Bash Scripts* to run in the *Bash Shell*.

For instance, to set up a fresh install of *Debian 9*:

```bash
#!/bin/bash

if [[ $EUID -ne 0 ]]; then
  echo "This script must be run as root. Exiting."
  exit 1
fi

apt update
apt upgrade

#Essentials
apt install -y tmux vim htop curl transmission vlc geary
#Development
apt install -y gcc g++ ruby2.3-dev python3 python3-tk python3-pip
#Electronics
apt install -y caneda arduino
#Editors
apt install -y vim emacs25-lucid eclipse
#Documentation
apt install -y pandoc okular texmaker lyx
#Dev tools
apt install -y gettext autopoint make build-essential gnome-builder libtool-bin
apt-get build-dep gnome-builder
apt-get build-dep eclipse

#Update Ruby and Python
gem update --system
gem install bundler
gem install jekyll
pip3 check
pip3 install pandas

#Move config files
if [ -f vimrc ]; then
	cp -r vimrc //home/rflec028/.vimrc
fi


#In Transmission:
#Require Encryption.
#Blocklist: http://john.bitsurge.net/public/biglist.p2p.gz
```
