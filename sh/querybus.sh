#!/bin/sh

#Depends on the tidy and curl packages:
# Fedora 28: dnf install tidy curl

#Use your own api keys:
appID="0"
apiKey="0"

#POST OC-Transpo API for ROUTE data...
curl -d "appID=$appID&apiKey=$apiKey&routeNo=63&stopNo=1600" https://api.octranspo1.com/v1.2/GetNextTripsForStop > busdata.route.xml

xmllint --format busdata.route.xml > busdata.route.formatted.xml 

#POST OC-Transpo API for STOP data...
curl -d "appID=$appID&apiKey=$apiKey&stopNo=1600" https://api.octranspo1.com/v1.2/GetRouteSummaryForStop > busdata.stop.xml

xmllint --format busdata.stop.xml > busdata.stop.formatted.xml 
