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
 * No HTML GUI is provided; only an API that returns JSON, and instructions
 * at the root path describing the API.
 *
 * Node Dependencies: express, pg, helmet, http, dotenv
 * File Dependencies: data/rcf045_InitDb.sql, rcf_lib.js
 * Require .env Vars: NODE_ENV, DATABASE_URL, PORT
 *
 */

// Import modules.
const express = require('express');
const postgres = require('pg');
const helmet = require('helmet');
const http = require('http');
const dotenv = require('dotenv');
const fs = require('fs');
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
    logger.err(`!! PSQL Init: ${e}`);
    process.exit(1); // Forcefully crash if no PSQL.
});

try {
    const initsql = fs.readFileSync('data/rcf045_InitDb.sql').toString();
    pgQuery(initsql);
} catch (e) {
    logger.err(`!! Could not load SQL for table init: ${e}`);
    process.exit(1); // Forcefully crash if table cannot be populated.
}

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

async function pgQueryAsync(query, args, rfunc) {
    logger.log(`>< pgquery().async requested for query '${query.slice(0, 20)}...'`);
    const client = await pgpool.connect();
    try {
        const res = await client.query(query, args);
        if (rfunc) { rfunc(res.rows); }
    } finally {
        client.release();
    }
    logger.log(`<> pgquery().async completed for query '${query.slice(0, 30)}...'`);
}

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

// pgQuery();
// pgQuery('select * from messages where username = $1;', ['Test One'], console.log);

/*
 * Express Implementation/Functions:
 * - Site root "/" returns API instructions.
 * - Path xyz returns abc. (TODO)
 */

// Write instructions to
webapp.get('/', (req, res) => {
    logger.log(`.. webapp.get('/') - Root page requested on port ${port}.`);
    res.write('\nAPI Instructions:\n');
    res.write('\nPATH:\t\t\tRETURNS:');
    res.write('\n/messages/{user}\tA subset of messages sent by a specific user.');
    res.write('\n/dl-messages\t\tAll messages as a JSON document.');
    res.write('\n/dl-highscores\t\tAll highscores as a JSON document.');
    res.write('\n/dl-questions\t\tAll quiz questions as a JSON document.\n\nRCF');
    res.end();
});

/* The above res.write commands print the following:
 * API Instructions:
 *
 * PATH:              RETURNS:
 * /messages/{user}   A subset of messages sent by a specific user.
 * /dl-messages       All messages as a JSON document.
 * /dl-highscores     All highscores as a JSON document.
 * /dl-questions      All quiz questions as a JSON document.
 *
 */

// Returns a set of messages for 'user' in URL.
webapp.get('/messages/:user', (req, res) => {
    logger.log(`.. webapp.get('/messages/${req.params.user}') - Root page requested on port ${port}.`);
    pgQuery('select * from messages where username = $1;', [req.params.user.toString()], (x) => {
        res.send(x);
        logger.log("<< webapp.get('/') - Sent PSQL data.");
    });
});

// Downloads all messages in database.
webapp.get('/dl-messages', (req, res) => {
    pgQuery('select * from messages;', [], (x) => {
        res.json(x);
    });
});

// Downloads all highscores in database.
webapp.get('/dl-highscores', (req, res) => {
    pgQuery('select * from highscores;', [], (x) => {
        res.send(x);
    });
});

// Downloads all questions in database.
webapp.get('/dl-questions', (req, res) => {
    pgQuery('select * from questions;', [], (x) => {
        res.send(x);
    });
});

// Final Step: Start WebServer.
server.listen(port, () => {
    logger.log(`.. Server UP on port ${port}`);
});

/*
 * This JS uses the following table schema:
 *
 * create table if not exists questions(
 *   question VARCHAR(240) NOT NULL,
 *   answer_a VARCHAR(240) NOT NULL,
 *   answer_b VARCHAR(240) NOT NULL,
 *   answer_c VARCHAR(240),
 *   answer_d VARCHAR(240),
 *   success INT );
 */
