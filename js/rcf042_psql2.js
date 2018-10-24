/*
 * Second PostGreSQL experiemnt. This time, querying and modifying info from
 * a database previously used in a Scala tutorial.
 */

const { Pool } = require('pg');
require('dotenv').config();

const pool = new Pool({
    connectionString: process.env.DB_CONSTRING_SCALADB,
});

pool.on('connect', () => {
    console.log('Connected to database.');
});

psQuery('SELECT * FROM company_divisions',processDivisions);
psQuery('SELECT * FROM company_regions',processRegions);

function processDivisions(divisions){
    console.log("\nDIVISIONS:");
    divisions.map(d =>{
        console.log(`ROW: ${d.company_division}, ${d.department}`);
    });
}

function processRegions(regions){
    console.log("\nREGIONS:");
    regions.map(d =>{
        console.log(`ROW: ${d.country}, ${d.company_regions}`);
    });
}

function psQuery(qstring,nextFunction){
    pool.query(qstring)
    .then((res) => {
        // console.log(`Result:`);
        // console.log(JSON.stringify(res, null, 2));
        nextFunction(res.rows);
    })
    .catch((err) => {
        console.log(`Error: ${err}`);
    });
}

pool.end();

/*
 * Result of the program above: 
 *
 * Connected to database.
 * Connected to database.
 *
 * DIVISIONS:
 * ROW: Auto & Hardware, Automotive
 * ROW: Domestic, Baby
 * ROW: Domestic, Beauty
 * ROW: Domestic, Clothing
 * ROW: Electronic Equipment, Computers
 * ROW: Electronic Equipment, Electronics
 * ROW: Domestic, Games
 * ROW: Outdoors & Garden, Garden
 * ROW: Domestic, Grocery
 * ROW: Domestic, Health
 * ROW: Domestic, Home
 * ROW: Auto & Hardware, Industrial
 * ROW: Fashion, Jewelery
 * ROW: Domestic, Kids
 * ROW: Entertainment, Movies
 * ROW: Entertainment, Music
 * ROW: Outdoors & Garden, Outdoors
 * ROW: Domestic, Shoes
 * ROW: Games & Sports, Sports
 * ROW: Auto & Hardware, Tools
 * ROW: Games & Sports, Toys
 *
 * REGIONS:
 * ROW: USA, Northeast
 * ROW: USA, Southeast
 * ROW: USA, Northwest
 * ROW: USA, Southwest
 * ROW: Canada, British Columbia
 * ROW: Canada, Quebec
 * ROW: Canada, Nova Scotia
 *
 */
