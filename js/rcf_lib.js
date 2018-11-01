// Useful functions for handling prime numbers.
// Just temp until I can get home and install math.js module.
// ...and it's grown. Needs to be transpiled before web use.

// Expanded 20180906 to include file i/o methods.
const fs = require('fs');
const colors = require('colors');
// const _ = require('lodash')

// Returns true if x is prime.
function primep(x) {
    const sqx = parseInt(Math.sqrt(x));
    for (let i = 2; i <= sqx; i++) {
        if (x % i === 0) { return false; }
    }
    return true;
}

// Returns true if x is a factor of y.
function factorp(x, y) {
    return ((y % x) === 0);
}

// Sums primes from two to x.
function sumto(limit) {
    let fsum = 2;

    for (let x = 3; x < limit; x += 2) {
        if (primep(x)) { fsum += x; }
    }
    console.log(`Primes below ${limit} add to ${fsum}`);
    return fsum;
}

// Returns array with numbers 1 through x
function range(x) {
    const arr = [];
    for (let y = 0; y < x; y++) {
        arr.push(y);
    }
    return arr;
}

// Returns sum based on type.
function sum(x) {
    const arglen = arguments.length;
    if (arglen > 1) {
    // Ensure all args are same type.
    // Sum args.
        return 0;
    } if (arglen === 1) {
        switch (typeof x) {
        default:
            console.log(typeof x);
            break;
        }
    } else {
        return 0;
    }
    console.log(`Sum ${arguments.length} args: ${arguments.toString()}`);
}

function title(y) {
    console.log(ulplus(y));
}

function subtitle(y) {
    console.log(ul(y));
}

function jsonf(obj) {
    console.log(JSON.stringify(obj, null, 2));
}

// Input for ./folder/string.txt is folder/string.txt
function loadFile(file) {
    const filestr = `./${file}`;
    console.log(`[loadFile] Loading ${filestr}`);
    return fs.readFileSync(filestr, 'utf8', (err, data) => {
        if (err) {
            console.log(`[loadFile] Error: ${err}`);
            throw err;
        }
        return data;
    });
}

function parseToInt(txt) {
    return parseInt(parseToString(txt));
}

function parseToString(txt) {
    const rawfile = loadFile(txt);
    return rawfile;
}

function parseToIntArray(txt) {
    return parseToString(txt).split('\n').map(x => parseInt(x)).filter(x => isNum(x));
}

function logSquareArray(arr) {
    for (let i = 0; i < arr.length; i++) {
        let string = '';
        arr[i].map((x) => { string += (`\t${x}`); });
        console.log(string);
    }
}

// Modified lodash methods:

/*
function minimumElement (array) {
  return _.reduce()
}
*/

// Binary Tree

class TNode {
    constructor(data, left = null, right = null) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.depth = null;
    }
}

class BinaryTree {
    constructor(rootdata) {
        this.root = new TNode(rootdata);
    }

    root() {
        return this.root;
    }
}

class BinarySearchTree extends BinaryTree {

}
// Generates 2D array of n by n boxes, having n+1 by n+1 points.
function genGrid(n) {
    let pointTotal = 0;
    const points = n + 1;
    const grid = [];
    for (let i = 0; i < points; i++) {
        const inner = [];
        for (let j = 0; j < points; j++) {
            inner.push(pointTotal);
            pointTotal += 1;
        }
        grid.push(inner);
    }
    return grid;
}

// Internal Library Methods

function isNum(x) {
    return Number.isInteger(x);
}

function ul(str) {
    return (`\n${str} \n${'-'.repeat(str.length)}+`);
}

function ulplus(str) {
    return (`${'\n'.repeat(9)}\t ${str} \n\t` + `+${'-'.repeat(str.length)}+\n`);
}

function prObj(name, obj) {
    console.log(`\n${name} Properties:\n${JSON.stringify(obj, null, 2)}`);
}

/*
 * Logger recommended format:
 * '..' for a general message.
 * '--' for a method messsage.
 * '>>' for a method entry.
 * '<<' for a method exit.
 * '><' for an async entry.
 * '<>' for an async exit.
 */

class Logger {
    constructor(logEnabled) {
        this.enabled = logEnabled;
        this.con = console;
        if (logEnabled) {
            this.con.log(`\n[ ${'rcf'.magenta} ] .. Logger instantiated. Debugging logs are ${'enabled'.green}.`);
        } else {
            this.con.log(`\n[ ${'rcf'.magenta} ] .. Logger instantiated. Debugging logs are ${'disabled'.red}.`);
        }
    }

    log(string) {
        if (this.enabled) {
            this.con.log(`[ ${'log'.green} ] ${string}`);
        }
    }

    err(string) {
        this.con.error(`[${'error'.red}] ${string}`);
    }

    done() {
        this.con.error('        ...done.');
    }
}

module.exports = {
    Logger, genGrid, BinarySearchTree, BinaryTree, TNode, logSquareArray, prObj, primep, factorp, sumto, range, sum, title, subtitle, jsonf, parseToInt, parseToString, parseToIntArray,
};
