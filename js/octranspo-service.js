//Originally implemented by M.Orch-, https://github.com/morch028

const fetch = require('node-fetch');
if (process.env.NODE_ENV !== 'production') {
  require('dotenv').load();
}

const BASE_URL = "https://api.octranspo1.com/v1.2";
const DEFAULT_QUERY_PARAMS = [
  ["format", "json"],
  ["appID", process.env.OCTRANSPO_APP_ID],
  ["apiKey", process.env.OCTRANSPO_API_KEY]
];

function getUrl(endpoint, queryParams) {
  const queryEntrySets = DEFAULT_QUERY_PARAMS.concat(Object.entries(queryParams || {}));
  const queryStringList = queryEntrySets.map(entry => `${entry[0]}=${entry[1]}`);
  const queryString = queryStringList.join("&");
  return `${BASE_URL}/${endpoint}?${queryString}`
}

//console.log("\n\nURL:\n"+getUrl("GetNextTripsForStopAllRoutes",{"stopNo":1600})+"\n");

async function getData () {
try{
  const response =  await fetch(getUrl("GetNextTripsForStopAllRoutes",{"stopNo":1600})); 
  const responsejson = await response.json();
  console.log(responsejson);
} catch (error) { console.log(error); }
}

//getData();

module.exports = { getUrl };
