import requests
import json
import os

key=os.environ.get("OWM_KEY")

url = "http://api.openweathermap.org/data/2.5/weather"
city = "Ottawa"

request_string = "{}?appid={}&q={}".format(url, key, city)

response = requests.get(request_string).json()["main"]

print("Current temperature in {}: {:3.2f}".format(city, response['temp']-273.15))
