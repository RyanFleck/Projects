const _ = require('lodash');
const r = require('./rcf_lib');

r.title('Functional Programming Tests ][');

r.subtitle('Passing .map() An Array');

const chars = ['a', 'b', 'c', 'd', 'e', 'f'];
const nums = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
const charcapdub = _.map(chars, element => element.toUpperCase().repeat(2));

console.log(chars); // a, b, c ...
console.log(charcapdub); // AA, BB, CC ...

// Take ownership over your life and habits. It's you.
// Learn to accept failure. It's alright to look like an idiot as long as you learn.
// What you do at 8PM matters. (Or 5AM. Form productive habits.)
// Success is a lonely road, while failure is a crowded highway.
// Finish the projects that you begin; the last 10% is the most difficult/rewarding.

r.subtitle('Filtering Arrays');

const evens = _.filter(nums, element => element % 2 === 0);

console.log(`Nums: ${nums}`);
console.log(`Evens: ${evens}`);

// !Thicc arrow syntax =>
// const func = (x,y) => { do stuff with x and y };
// If only one arg:  const func = x => { do stuff };
// If no args:  const func = () => { do stuff };

const employees = [
    { name: 'A', salary: 30000.0 },
    { name: 'B', salary: 40000.0 },
    { name: 'C', salary: 90000.0 },
    { name: 'D', salary: 100000.0 },
    { name: 'E', salary: 120000.0 },
];

// Filter
const underpaid = _.filter(employees, employee => employee.salary < 70000);
console.log(underpaid);

// Some
const containsEvenNumbers = array => _.some(array, element => element % 2 === 0);

// Every
const allEvenNumbers = array => _.every(array, element => element % 2 === 0);

console.log(`NUMS contains even numbers: ${containsEvenNumbers(nums)}`);
console.log(`NUMS is all even numbers: ${allEvenNumbers(nums)}`);

/*
 * Perhaps it is best to save the arrow notation for specific use-cases, like
 * short boolean tests or returning arguments for reducing an array. Seems
 * strange to use them everywhere, though they're definitely better than a
 * full function xyz() {} when the function is just one return statement.
 */

r.subtitle('Reducing Arrays');

const accumulate = _.reduce(nums, (acc, element) => acc + element);

console.log(`Array: ${nums}`);
console.log(`Accumulate: ${accumulate}`);

// This doensn't work and I don't understand _why_.
// SOLVED: Needed to specify array start point when parsing objects.
const staffPay = _.reduce(employees, (acc, e) => acc + e.salary, 0);
console.log(`Total cost of employees: ${staffPay}`);

r.subtitle('Combined Operations: Chaning Map, Filter, Reduce');

const people = [
    {
        name: 'Dan', salary: 62300, age: 27, gender: 'M',
    },
    {
        name: 'Eve', salary: 113500, age: 50, gender: 'F',
    },
    {
        name: 'Jude', salary: 50500, age: 21, gender: 'F',
    },
    {
        name: 'Ed', salary: 107000, age: 45, gender: 'M',
    },
    {
        name: 'Emmanuel', salary: 99000, age: 39, gender: 'M',
    },
    {
        name: 'Alice', salary: 75000, age: 36, gender: 'F',
    },
];

const males = _.filter(people, p => p.gender === 'M');
const females = _.filter(people, p => p.gender === 'F');
const names = people => _.map(people, p => p.name);
const avgAge = ppl => _.reduce(_.map(ppl, p => p.age), (acc, age) => acc + age) / ppl.length;
// const avgPay = ( ppl ) => ...

console.log(`Workers: ${names(people)}`);
console.log(`Average working age: ${avgAge(people)}`);

console.log(`\nMales: ${names(males)}`);
console.log(`Average Male working age: ${avgAge(males)}`);
console.log(`\nFemales: ${names(females)}`);
console.log(`Average working age: ${avgAge(females)}`);

/*
 * We don't read and write poetry because it's cute. We read and write poetry
 * because we are members of the human race. And the human race is filled with
 * passion. And medicine, law, business, engineering, these are noble pursuits
 * and necessary to sustain life. But poetry, beauty, romance, love, these are
 * what we stay alive for. To quote from Whitman, "O me! O life!... of the
 * questions of these recurring; of the endless trains of the faithless...
 * of cities filled with the foolish; what good amid these, O me, O life?"
 * Answer. That you are here - that life exists, and identity; that the
 * powerful play goes on and you may contribute a verse. That the powerful
 * play *goes on* and you may contribute a verse. What will your verse be?
 *
 *     John Keating
 */
