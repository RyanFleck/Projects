#!/usr/local/bin/python
# -*- coding: utf-8 -*-
#  bus.py - Save next known bus arrival times to JSON file.
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

#RUN WITH PYTHON 2.7

import requests
import json
import sys
from docs import Docs

def main():
	d = Docs("BusTime.py")
	d.printHeader()
	#Learn how to verify.
	ocdata = requests.post(
		'https://api.octranspo1.com/v1.2/GetNextTripsForStop',
		data={
		"appID": "e92b563f",
		"apiKey": '181e5772302f2afeed2b69f65b2e1cf1',
		"stopNo": "8615",
		"routeNo": '14' ,
		"format": "json"}
		,verify=False).json()
	
	print("\n\nData Retrieved.")
	
	printedData = ocdata["GetNextTripsForStopResult"]["Route"]["RouteDirection"]["Trips"]["Trip"]
	
	toSerial = {}
	x=0
	for i in printedData:
		print ("Trip in {} mins.".format(i['AdjustedScheduleTime']))
		toSerial['Bus{}'.format(x)]=i['AdjustedScheduleTime']
		x+=1
		
	serialData = json.dumps(toSerial)
	with open('BUSDATA.json', 'w') as f:
		json.dump(serialData, f)
		
	d.printFooter()

main()

