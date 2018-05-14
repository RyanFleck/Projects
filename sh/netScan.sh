#!/bin/sh
echo "SCANNING LAN."
arp-scan --interface=wlp3s0 --localnet
echo "SCAN COMPLETE."
