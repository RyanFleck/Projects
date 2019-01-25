#!/usr/bin/env node
'use strict';

const prog = require('commander');
const chalk = require('chalk');

const debugflags = (options) => {
    if(options.aioli) console.log('Holy aioli!');
    if(options.bats) console.log('Control them all!');
    if(options.control) console.log('Control them all!');
}

const dostuff = (file, options) => {
    console.log('Exec dostuff()');
    debugflags(options);
}

const domorestuff = (file, options) => {
    console.log('Exec domorestuff()');
    debugflags(options);
}

prog
    .version('0.1')
    .option('-a, --aioli','A simple flag.')
    .option('-b, --bats','Another simple flag.')
    .option('-c, --control [optional]','Flag with optional input.')
    .option('-d, --dumpto <required>','Flag with required input')
    .command('dostuff [file]')
    .command('domorestuff [file]')
    .action('dostuff');

prog.parse(process.argv);

if (prog.args.length === 0) prog.help();

/*
 * Based on tutorial from https://medium.freecodecamp.org/writing-command-line-applications-in-nodejs-2cf8327eee2
 */
