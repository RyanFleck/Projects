const r = require('./rcf_lib');
// const _ = require('lodash');

r.title('Functional Programming Tests I');

// - Contain data in simple structures.
// - Use const to avoid state change/ mutable data.

const runfunction = function (x, func) {
    return func(x);
};

r.subtitle('Passing Functions as Arguments');

runfunction('test runfunction', console.log);

// Assign vars to builtins;
const line = console.log;

// Adding () transforms a function to its return value. (don't use if passing)
line('Test line');

function randomFunction() {
    switch (parseInt(3 * Math.random(), 10)) {
    case 0:
        return () => {
            console.log('Zero.');
        };
    case 1:
        return () => {
            console.log('One.');
        };
    case 2:
        return () => {
            console.log('Two.');
        };
    default:
        return () => {
            console.log('Generator failed.');
        };
    }
}

randomFunction()();
randomFunction()();
randomFunction()();
randomFunction()();

const aFunc = randomFunction();

aFunc();
aFunc();

r.subtitle('Closures and Capturing');

// A good way to create private inner vars, a good way to reduce mutability.

function createCounter() {
    let count = 0;
    return {
        increment() {
            count++;
        },
        value() {
            return count;
        },
    };
}

const counterOne = createCounter();
counterOne.increment();
counterOne.increment();
line(`Counter value after two increments: ${counterOne.value()}`);

function doIfSafe(n, string, func) {
    if (n != null && typeof n === 'number') {
        if (string != null && typeof string === 'string') {
            return func(n, string);
        }
    }
    return false;
}

function createSafeVersion(func) {
    return (n, string) => {
        if (n != null && typeof n === 'number') {
            if (string != null && typeof string === 'string') {
                return func(n, string);
            }
        }
        return false;
    };
}

function printMessageNTimes(n, msg) {
    for (let x = 0; x < n; x++) { console.log(msg); }
}

function getSubstringOfLen(n, substr) {
    return substr.substring(0, n);
}

doIfSafe(3, 'Hello?', printMessageNTimes);
console.log(doIfSafe(4, 'Hello?', getSubstringOfLen));

const printMessageNTimesSafe = createSafeVersion(printMessageNTimes);

printMessageNTimesSafe(3, "Hm? Safe version? Next call for 3x shouldn't run:");
printMessageNTimesSafe(3, null);
