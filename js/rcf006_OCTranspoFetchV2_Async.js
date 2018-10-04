const fetch = require('node-fetch');

// API and APP keys now utilized in octranspo-service.js
const util = require('./octranspo-service.js');

// nextBus() and stopInfo() return JSON in the form:
// {
//   "text": "Info\nMoreInfo"
// }

async function fetchData(stop, route, direction) {
  const postData = {};
  if (stop) { postData.stopNo = stop; }
  if (route) { postData.routeNo = route; }
  if (direction) { postData.direction = direction; }

  const response = await fetch(util.getUrl('GetNextTripsForStopAllRoutes', postData));
  const busData = await response.json();
  return busData.GetRouteSummaryForStopResult;
}

async function nextBus(stop, route = 0, direction = 0) {
  return stopInfo(stop);// Temporary: Direct all input to stopInfo.

  console.log(`nextBus(${stop} ${route} ${direction})`);

  // If no route provided, return stopinfo.
  if (!route) {
    return stopInfo(stop);
  }

  const busData = await fetchData(stop, route, direction).catch((err) => {
    console.log(`Error: ${err}`);
  });

  return 0;
}

async function stopInfo(stop) {
  console.log(`stopinfo(${stop})`);

  const busData = await fetchData(stop).catch((err) => {
    console.log(`Error: ${err}`);
  });

  console.log(busData);
  console.log(`Information for stop ${busData.StopNo} at ${busData.StopDescription}:`);
  console.log('Stop Connections:');
  for (busNum in busData.Routes.Route) {
    const Route = busData.Routes.Route[busNum];
    const TripArray = [];
    for (tripNum in Route.Trips) {
      const Trip = Route.Trips[tripNum];
      TripArray.push(Trip.TripStartTime);
    }
    console.log(`  ${Route.RouteNo} ${Route.Direction} to ${Route.RouteHeading} at ${
      TripArray.join(', ')}.`);
  }

  return 0;
}

// Tests
console.log(nextBus(7659).catch());

module.exports = { nextBus, stopInfo };
