const { Pool } = require('pg');
require('dotenv').config();

const pool = new Pool({
    connectionString: process.env.DB_CONSTRING,
});

pool.on('connect', () => {
    console.log('Connected to database.');
});


psQuery(`CREATE TABLE IF NOT EXISTS
         messages(
             username VARCHAR(140) NOT NULL,
             message VARCHAR(300) NOT NULL,
             time TIMESTAMP
             )`);


psQuery(`CREATE TABLE IF NOT EXISTS
         highscores(
             username VARCHAR(140) NOT NULL,
             score INT NOT NULL, 
             time TIMESTAMP
             )`);

psQuery('SELECT * FROM messages');
psQuery('SELECT * FROM highscores');


function psQuery(qstring){
    pool.query(qstring)
    .then((res) => {
        console.log(`Result:`);
        console.log(JSON.stringify(res, null, 2));
    })
    .catch((err) => {
        console.log(`Error: ${err}`);
    });
}

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
function end(){
  pool.end();
}
