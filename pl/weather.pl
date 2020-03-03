forecast(X,Y):- snow(X),
                rain(X),
                Y=snow_and_rain.

forecast(X,Y):- cloudy(X),
                rain(X),
                Y=cloudy_and_rainy.

forecast(X,Y):- sun(X),
                cloudy(X),
                Y=mix_of_sun_and_cloud.

forecast(X,Y):- cloudy(X),
                Y=grey.

forecast(X,Y):- sun(X),
                Y=sunny.

cloudy(monday).
cloudy(tuesday).
cloudy(thursday).
cloudy(friday).

snow(thursday).

sun(wednesday).
sun(friday). 

rain(tuesday).
rain(thursday).
