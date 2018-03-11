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
apt install -y gcc g++ ruby2.3-dev python3 python3-pip
#Electronics
apt install -y caneda arduino
#Editors
apt install -y vim emacs25-lucid eclipse 
#Documentation
apt install -y pandoc okular texmaker lyx

gem update --system
gem install bundler
gem install jekyll

pip3 install pandas

#In Transmission:
#Require Encryption.
#Blocklist: http://john.bitsurge.net/public/biglist.p2p.gz
