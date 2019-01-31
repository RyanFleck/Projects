/*
 * Sends automated emails. Requires the folllowing env. vars:
 * GMAIL_ADDRESS=xyz@gmail.com
 * GMAIL_PASSWORD=blerg
 *
 * Supporting docs:
 *  - https://github.com/eleith/emailjs
 */


const dotenv = require('dotenv');
// const fs = require('fs');
const email = require('emailjs');

dotenv.load();

const emailServer = email.server.connect({
    user: process.env.GMAIL_ADDRESS,
    password: process.env.GMAIL_PASSWORD,
    host: 'smtp.gmail.com',
    ssl: true,
});

const message = {
    to: 'Ryan Fleck <ryan.fleck@protonmail.com>',
    from: 'Ryan Fleck <rcf.internships@gmail.com>',
    subject: 'Test, 1, 2...',
    text: `Hello?\nNeat.\n${'test'}`,
};

emailServer.send(message, (err, errMessage) => {
    console.log('ERROR');
    console.log(err);
    console.log(errMessage);
});
