#!/usr/bin/python3

import datetime
date_st = datetime.datetime.strptime
date_fo = datetime.date.fromordinal

import rcf_logs as rcf
dbg = rcf.dbg
rcf.intro("Simple .md date-heading generator", 2018)

# Assumes week 1-52.
year      = 2018
firstweek = 2 
lastweek  = 14 

dbg(True,"good","init","Modules loaded. Operating on weeks {}-{}, {}".format(firstweek,lastweek,year))

dbg(True,"good","gen","Markdown output:\n\n")

for x in range(firstweek, lastweek+1):

    daterange = ""
    start = date_st("{}-W{}-6".format(year,x-1), "%Y-W%W-%w")
    end = date_st("{}-W{}-5".format(year,x), "%Y-W%W-%w")

    if(start.strftime("%m") != end.strftime("%m")):
        daterange = "{}{}".format(start.strftime("%B %d - "),end.strftime("%B %d"))
    else:
        daterange = "{}{}".format(start.strftime("%B %d-"),end.strftime("%d"))
    
    str_x = str(x).zfill(2)
    print("## **W{}** {}".format(str_x, daterange))

