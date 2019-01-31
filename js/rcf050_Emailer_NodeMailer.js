/*
 * Sends automated emails. Requires the folllowing env. vars:
 * GMAIL_ADDRESS=xyz@gmail.com
 * GMAIL_PASSWORD=blerg
 *
 * Supporting docs:
 *  - https://github.com/eleith/emailjs
 *  - https://nodemailer.com/about/
 */


const dotenv = require('dotenv');
// const fs = require('fs');
const mailer = require('nodemailer');

dotenv.load();

const smtp = mailer.createTransport({
    service: 'Gmail',
    host: 'smtp.gmail.com',
    port: 587,
    secure: true,
    auth: {
        user: process.env.GMAIL_ADDRESS,
        pass: process.env.GMAIL_PASSWORD,
    },
});

const message = {
    to: 'Ryan Fleck <ryan.fleck@protonmail.com>',
    from: 'Ryan Fleck <rcf.internships@gmail.com>',
    subject: 'Send Email Using Node.js',
    text: 'Node.js New world for me',
    html: '<b>Node.js New world for me</b>',
};

smtp.sendMail(message, (error, response) => {
    if (error) {
        console.log('ERROR.');
        console.log(error);
    } else {
        console.log('Good to go!');
        console.log(response.message);
    }
});

smtp.close();
