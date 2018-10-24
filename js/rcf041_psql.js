const { Pool } = require('pg');
require('dotenv').config();

const pool = new Pool({
    connectionString: process.env.DB_CONSTRING,
});

pool.on('connect', () => {
    console.log('Connected to database.');
});


const queryText = `CREATE TABLE IF NOT EXISTS
                    reflections(
                        id UUID PRIMARY KEY,
                        success VARCHAR(128) NOT NULL,
                        low_point VARCHAR(128) NOT NULL,
                        take_away VARCHAR(128) NOT NULL,
                        created_date TIMESTAMP,
                        modified_date TIMESTAMP
                        )`;

pool.query(queryText)
    .then((res) => {
        console.log(`Result: ${res.toString()}`);
    })
    .catch((err) => {
        console.log(`Error: ${err}`);
    });


pool.query('drop table reflections')
    .then((res) => {
        console.log(`Result: ${res}`);
    })
    .catch((err) => {
        console.log(`Error: ${err}`);
    });

pool.end();
/*
 *  create table messages (
 *    username varchar(140),
 *    message varchar(300)
 *  );
 *
 *  create table highscores (
 *    username varchar(140),
 *    highscore int
 *  );
*/

// .catch((err) => { console.log('lol'); });
