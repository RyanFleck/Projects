const fetch = require('node-fetch');
const util = require('./octranspo-service.js');

if (process.env.NODE_ENV !== 'production') {
  require('dotenv').load();
}

const base_url = "https://api.octranspo1.com/v1.2/";
const app_id = process.env.APP_ID;
const api_key = process.env.API_KEY;



async function fetchData (stop, route, direction) {

  try{
    const response =  await fetch( 'https://api.octranspo1.com/v1.2/GetNextTripsForStopAllRoutes'  ,{ method: 'POST', body: 'appID=${app_id}&apiKey=0&stopNo=1600&format=json', headers: {"Content-Type": "application/x-www-form-urlencoded"}});
    const responsejson = await response.json();
    console.log(responsejson);
  } catch (error) { 
    console.log(error);
  }

}

async function fetchData (stop, route, direction) {
 //GetNextTripsForStopAllRoutes
  console.log("Fetch API data for stop:",stop," route:",route," direction:",direction,".");
  
  //TODO: Check mongo to see if existing data is less than one minute old.

  //If nothing exists, fetch new data using OC-Transpo API.
  const url = base_url+"GetNextTripsForStopAllRoutes"
  const postData = "appID="+app_id+"&apiKey="+api_key+"&stopNo="+stop+"&format=json";
    //https://api.octranspo1.com/v1.2/GetNextTripsForStopAllRoutes
  console.log("url: ",url);
  console.log("postData: ",postData);
  try{ 
  fetch( '.https://api.octranspo1.com/v1.2/GetNextTripsForStopAllRoutes'  ,{ method: 'POST', body: 'appID=0&apiKey=0&stopNo=1600&format=json', headers: {"Content-Type": "application/json"}})
  stDatapostData
    .then(res => res.text())
    .then(body => console.log("\n\nRESPONSE:\n",body));
  } catch(error){}
}


function nextbus (stop, route, direction) {
  console.log("nextbus()");

    //If no route provided, return stopinfo.
    if(!route){
      return stopinfo(stop);
    }
  
  fetchData(stop, direction);
}

function stopinfo (stop, direction) {
  console.log("stopinfo()");
  fetchData(stop, direction);
}


module.exports = { nextbus, stopinfo };

//Tests
nextbus(3011);



getData();
