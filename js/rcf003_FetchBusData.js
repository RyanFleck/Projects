const fetch = require('node-fetch');

//API and APP keys now utilized in octranspo-service.js
const util = require('./octranspo-service.js');



async function fetchData (stop,route,direction) {
  console.log(stop+" "+route+" "+direction);
  const postData={};
  if(stop){postData.stopNo = stop;}
  if(route){postData.routeNo = route;}
  if(direction){postData.direction = direction;}

  console.log(postData);

  console.log("\n\nFetching URL:\n"+util.getUrl("GetNextTripsForStopAllRoutes",postData)+"\n");
  
  try{
    const response =  await fetch(util.getUrl("GetNextTripsForStopAllRoutes",postData)); 
    const responsejson = await response.json();
    console.log(responsejson);
  } catch (error) { console.log(error); }
}




function nextBus (stop, route, direction) {
  console.log("nextBus("+stop+" "+route+" "+direction+")");

    //If no route provided, return stopinfo.
    if(!route){
      return stopInfo(stop);
    }
  
  fetchData(stop, route, direction);
}

function stopInfo (stop, direction) {
  console.log("stopinfo("+stop+" "+direction+")");
  fetchData(stop, direction);
}



//Tests
nextBus(3011,64);


module.exports = { nextBus, stopInfo };
