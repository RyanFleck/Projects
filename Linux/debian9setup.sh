#!/bin/bash

if [[ $EUID -ne 0 ]]; then
  echo "This script must be run as root. Exiting." 
  exit 1
fi

apt update
apt upgrade
apt install vim gcc g++ ruby2.3-dev python3 python3-pip tmux vim

gem update --system
gem install bundler
gem install jekyll

pip3 install pandas

#In Transmission:
#Require Encryption.
#Blocklist: http://john.bitsurge.net/public/biglist.p2p.gz
