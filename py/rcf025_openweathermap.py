#!/usr/bin/env python3

import requests
import json
import os

key = os.environ.get("OWM_KEY")

url = "http://api.openweathermap.org/data/2.5/weather"
city = "Ottawa"

request_string = "{}?appid={}&q={}".format(url, key, city)

response = requests.get(request_string).json()  # ["main"]

# Response code 200 is the correct response.
if(response["cod"] != 200):
    print("Error. {}".format(response))
else:
    # Temperature is given in Kelvin.
    print(
        "Current temperature in {}: {:3.2f}\N{DEGREE SIGN}C".format(
            city,
            response['main']['temp'] -
            273.15))
