/*
 * Fourth PSQL experiment. Goal is to create a table, add two new methods for
 * adding new entries and listing the top ten sorted results.
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

