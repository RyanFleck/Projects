#!/usr/bin/env python3

import requests
from pprint import pprint
import json
import os

key = os.environ.get("OWM_KEY")

url = "http://api.openweathermap.org/data/2.5/weather"
city = "Ottawa"

request_string = "{}?appid={}&q={}".format(url, key, city)

print("Retrieving weather for {}...".format(city))
response = requests.get(request_string).json()  # ["main"]

pprint(response)

# Response code 200 is the correct response.
if(response["cod"] != 200):
    print("\nError.\n")
else:
    # Temperature is given in Kelvin.
    print(
        "\nCurrent temperature in {} is {:3.2f}\N{DEGREE SIGN}C\n".format(
            city,
            (response['main']['temp'] - 273.15)))
