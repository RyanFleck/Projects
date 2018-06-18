#!/bin/bash
# Ryan Fleck 2018

echo "Connecting to REMOTELAB."
IP=`curl -H 'Cache-Control: no-cache' https://ryanfleck.github.io/ip | grep "IP="`
IP="${IP#*=}"
echo "Addr: $IP"
ssh -XC $IP
echo "Disconnected from REMOTELAB at $IP, script exiting."
