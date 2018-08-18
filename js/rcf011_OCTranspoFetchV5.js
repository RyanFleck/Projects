const fetch = require('node-fetch');

//API and APP keys now utilized in octranspo-service.js
const util = require('./octranspo-link-service.js');

// nextBus() and stopInfo() return JSON in the form:
// {
//   "text": "Info\nMoreInfo"
// }


async function fetchData (stop,route,direction) {

  const postData={};
  if(stop){postData.stopNo = stop;}
  if(route){postData.routeNo = route;}
  if(direction){postData.direction = direction;}
  
  const response =  await fetch(util.getUrl("GetNextTripsForStopAllRoutes",postData)); 
  const busData = await response.json(); 
  return busData.GetRouteSummaryForStopResult;
}


async function nextBus (stop, route=0, direction=0) { 
  return stopInfo(stop);//Temporary: Direct all input to stopInfo.
  
  console.log("nextBus("+stop+" "+route+" "+direction+")");

    //If no route provided, return stopinfo.
    if(!route){
      return stopInfo(stop);
    }
  
  const busData = await fetchData(stop, route, direction).catch(function(err) {
      console.log('Error: '+err);
      });

  return 0;  
}


async function stopInfo (stop) {
  
  const output = [];
  
  const busData = await fetchData(stop).catch(function(err) {
      console.log('Error: '+err);
      });

  console.log(busData);
  output.push("Information for stop "+busData.StopNo+" at "+busData.StopDescription+":");
  output.push("Connections:");
  for(busNum in busData.Routes.Route){
    const Route = busData.Routes.Route[busNum];
    const TripArray=[]; 
    for(tripNum in Route.Trips){
      const Trip = Route.Trips[tripNum];
      TripArray.push(Trip.TripStartTime);
    }
    output.push("*"+Route.RouteNo+"* "+Route.Direction+" to "+Route.RouteHeading+" at "+
    TripArray.join(", ")+".");
  }

  jsonOut = { "text" : output.join("\n") };
  console.log(jsonOut);
  return jsonOut;  
}


//Tests
console.log(nextBus(7659).catch());


module.exports = { nextBus, stopInfo };
