#!/bin/sh

#Depends on the tidy and curl packages:
# Fedora 28: dnf install tidy curl

#GetRouteSummaryForStop:
#  Retrieves the routes for a given stop number.
#GetNextTripsForStop: 
#  Retrieves next three trips on the route for a given stop number.
#GetNextTripsForStopAllRoutes: 
#  Retrieves next three trips for all routes for a given stop number.

#Use your own api keys:
appID="000"
apiKey="000"

#POST OC-Transpo API for GetRouteSummaryForStop
curl -d "appID=$appID&apiKey=$apiKey&routeNo=7&stopNo=7659&format=json" https://api.octranspo1.com/v1.2/GetRouteSummaryForStop > GetRouteSummaryForStop.json

#POST OC-Transpo API for GetNextTripsForStop
curl -d "appID=$appID&apiKey=$apiKey&routeNo=63&stopNo=1600&format=json" https://api.octranspo1.com/v1.2/GetNextTripsForStop > GetNextTripsForStop.json

#POST OC-Transpo API for GetNextTripsForStopAllRoutes
curl -d "appID=$appID&apiKey=$apiKey&stopNo=7659&format=json" https://api.octranspo1.com/v1.2/GetNextTripsForStopAllRoutes > GetNextTripsForStopAllRoutes.json
