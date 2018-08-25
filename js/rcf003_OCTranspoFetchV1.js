const fetch = require('node-fetch')

// API and APP keys now utilized in octranspo-service.js
const util = require('./octranspo-service.js')

async function fetchData (stop, route, direction) {
  console.log(stop + ' ' + route + ' ' + direction)
  const postData = {}

  // Better way to do this?
  if (stop) { postData.stopNo = stop }
  if (route) { postData.routeNo = route }
  if (direction) { postData.direction = direction }

  // console.log(postData);
  // console.log("\n\nPOSTing URL:\n"+util.getUrl("GetNextTripsForStopAllRoutes",postData)+"\n");

  try {
    const response = await fetch(util.getUrl('GetNextTripsForStopAllRoutes', postData))
    return await response.json()
  } catch (error) { console.log('Error in fetchData(): ' + error) }
}

function nextBus (stop, route, direction) {
  console.log('nextBus(' + stop + ' ' + route + ' ' + direction + ')')

  // If no route provided, return stopinfo.
  if (!route) {
    return stopInfo(stop)
  }

  return fetchData(stop, route, direction)
}

function stopInfo (stop, direction) {
  console.log('stopinfo(' + stop + ' ' + direction + ')')
  return fetchData(stop, direction)
}

// Tests
console.log(nextBus(3011, 64))

module.exports = { nextBus, stopInfo }
