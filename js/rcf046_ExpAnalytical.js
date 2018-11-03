/*
 * rcf046_ExpAnalytical.js
 *
 * @author Ryan Fleck
 * @licence GPL-v3
 *
 * Attempting to return data from a database in a clean document format.
 *
 */

// Import modules.
const express = require('express');
const postgres = require('pg');
const helmet = require('helmet');
const http = require('http');
const dotenv = require('dotenv');
const fs = require('fs');
const handlebars = require('express-handlebars');
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
webapp.engine('handlebars', handlebars({
    defaultLayout: 'document',
}));
webapp.set('view engine', 'handlebars');
webapp.use(express.static('views/public-styling'));


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

function currentTime() {
    const asap = new Date();
    return {
        year: asap.getFullYear().toString(),
        month: asap.getMonth().toString(),
        day: asap.getDay().toString(),
        hour: `${asap.getHours().toString()}${asap.getMinutes().toString()}`,
    };
}

/*
 * Express Implementation/Functions:
 */

webapp.get('/', (req, res) => {
    logger.log(`.. webapp.get('/') - Root page requested on port ${port}.`);
    res.render('rcf046_article', {
        title: 'TESTING',
        article: 'Interesting.',
        ...currentTime(),
    });
});

webapp.get('/:article_title', (req, res) => {
    logger.log(`.. webapp.get('/') - Root page requested on port ${port}.`);
    res.render('rcf046_article', {
        title: req.params.article_title,
        ...currentTime(),
    });
});

// Final Step: Start WebServer.
server.listen(port, () => {
    logger.log(`.. Server UP on port ${port}`);
});
