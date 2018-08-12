const busbot = require('./rcf003_FetchBusData.js');

//Remove me!
const app_key = "0"
const app_id = "0"


console.log("Run functions from loaded file:");

busbot.nextbus();

busbot.stopinfo();
