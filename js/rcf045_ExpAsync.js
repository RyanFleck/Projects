/*
 * rcf045_ExpAsync.js
 *
 * @author Ryan Fleck
 * @licence GPL-v3
 *
 * Having fumbled my combination of IIFs, promises and async/await in the
 * past, this file exists for practice calling many asynchronous operations
 * in the correct way, and passing the results to the frontend.
 *
 * No HTML GUI is provided; only an API that returns JSON.
 *
 * Node Dependencies: express, pg, helmet, http, dotenv
 * File Dependencies: data/rcf045_InitDb.sql, rcf_lib.js
 *
 */

// Import modules.
const express = require('express');
const postgres = require('pg');
const helmet = require('helmet');
const http = require('http');
const dotenv = require('dotenv');
const rcf = require('./rcf_lib');

// Init Express and HTTP
const webapp = express();
const server = http.Server(webapp);
const port = process.env.PORT || 3000;

// Init Helmet
webapp.use(helmet());

// Init Postgres
dotenv.load();
const pgpool = new postgres.Pool({
    connectionString: process.env.DATABASE_URL
});

/*
 * PSQL Implementation/Functions:
 * - pgquery provides a simple asynchronous implementation to run queries.
 */
function pgquery( querystring, argumentarray, resfunction ){
    if(!querystring){
        console.error(">> pgquery() ERROR: No query provided.");
        return null;
    }
    (async (querystring, argumentarray, resfunction) => {
        console.log(`>> pgquery() requested for query ${querystring.subString(0.10)}...`);
    })().catch(e => console.error(e));
}

pgquery();


/*
 * Express Implementation/Functions:
 * - Site root "/" returns API instructions.
 * - Path xyz returns abc. (TODO)
 */

webapp.get('/', (req,res) => {
    console.log('Root page requested. Returning instructions to user.');
});
