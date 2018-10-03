const fetch = require('node-fetch');

async function getData() {
  try {
    const response = await fetch('https://api.octranspo1.com/v1.2/GetNextTripsForStopAllRoutes', { method: 'POST', body: 'appID=0&apiKey=0&stopNo=1600&format=json', headers: { 'Content-Type': 'application/x-www-form-urlencoded' } });
    const responsejson = await response.json();
    console.log(responsejson);
  } catch (error) { console.log(error); }
}

getData();
