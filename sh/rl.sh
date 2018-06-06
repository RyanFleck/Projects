#!/bin/bash
#Grabs IP address of RCF-REMOTELAB and starts an ssh session.
IP=`curl https://ryanfleck.github.io/ip | grep "IP="`
IP="${IP#*=}"
echo "Addr: $IP"
ssh -XC $IP
