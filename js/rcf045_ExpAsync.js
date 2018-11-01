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

// Init Logs
dotenv.load();
const debugEnabled = (process.env.NODE_ENV === 'development');
const logger = new rcf.Logger(debugEnabled);
logger.log(`.. Environment: ${process.env.NODE_ENV}.`);

// Init Express and HTTP
logger.log('.. Instantiating Express.js and WebServer.');
const webapp = express();
const server = http.Server(webapp);
const port = process.env.PORT || 3000;

// Init Helmet
logger.log('.. Applying HELMET middleware.');
webapp.use(helmet());

// Init Postgres
logger.log('.. Instantiating PostgreSQL pool.');
const pgpool = new postgres.Pool({
    connectionString: process.env.DATABASE_URL,
});

logger.log('.. Testing PostgreSQL connection...');
const testPSQL = async () => {
    const client = await pgpool.connect();
    client.release();
};

testPSQL().catch((e) => {
    logger.err(`PSQL Init: ${e}`);
    process.exit(1); // Forcefully crash if no PSQL.
});

/*
 * PSQL Implementation/Functions:
 *
 * qgQuery - Starts asynchronous function to query psql.
 * qgQueryAsync - not to be called directly, creates client and sends query.
 *
 * querystring - sql query language string.
 * argumentarray - array of args in querystring.
 * resfunction - function to handle the query response.
 */

const pgQueryAsync = async (query, args, rfunc) => {
    logger.log(`>< pgquery().async requested for query '${query.slice(0, 20)}...'`);
    const client = await pgpool.connect();
    try {
        const res = await client.query(query, args);
        rfunc(res.rows);
    } finally {
        client.release();
    }
    logger.log('<> pgQuery().async');
};

function pgQuery(querystring, argumentarray, resfunction) {
    logger.log('>> pgQuery()');

    if (!querystring) {
        logger.err('-- pgquery() ERROR: No query provided.');
        return false;
    }

    pgQueryAsync(querystring, argumentarray, resfunction).catch((e) => {
        logger.err(`<> pgQuery().async: ${e}`);
        process.exit(1); // Forcefully crash if no PSQL.
    });

    logger.log('<< pgQuery()');
    return true;
}

pgQuery();
pgQuery('select * from messages;', [], console.log);


/*
 * Express Implementation/Functions:
 * - Site root "/" returns API instructions.
 * - Path xyz returns abc. (TODO)
 */

webapp.get('/', (req, res) => {
    logger.log(`Root page requested on port ${port}.`);
    // console.log(req); // Returns an insane amount of data. Cherry pick and return some.
    res.send('Hello, World!');
});


// Final Step: Start WebServer.
server.listen(port, () => {
    logger.log(`.. Server UP on port ${port}`);
});


/*
 * This JS uses the following table:
 *
 * create table if not exists questions(
 *   question VARCHAR(240) NOT NULL,
 *   answer_a VARCHAR(240) NOT NULL,
 *   answer_b VARCHAR(240) NOT NULL,
 *   answer_c VARCHAR(240),
 *   answer_d VARCHAR(240),
 *   success INT );
 */
