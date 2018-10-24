/*
 * Third PostGreSQL experiemnt. Continuing to query scala_db. 
 * Next steps:
 * - Figure out how to integrate pg.Pool() with express for the applicaiton.
 * - Learn more about the SQL language and relational databases.
 * - Learn if Pool() is even the best class for doing what I need.
 */

const { Pool } = require('pg');
require('dotenv').config();

const pool = new Pool({
    connectionString: process.env.DB_CONSTRING_SCALADB,
});

pool.on('connect', () => {
    console.log('Connected to database.');
});

psQuery('SELECT id, last_name, email FROM emps',processEmps);

function processEmps(emp){
    console.log("\nEMPLOYEES:");
    emp.map(e =>{
        console.log(`ROW: ${e.id}, ${e.email}`);
    });
}

function psQuery(qstring,nextFunction){
    pool.query(qstring)
    .then((res) => {
        console.log(`\n\n\nQuery Result:`);
        console.log(JSON.stringify(res, null, 2));
        nextFunction(res.rows);
    })
    .catch((err) => {
        console.log(`Error: ${err}`);
    });
}

pool.end();

