# Programming in JavaScript

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/js](https://ryanfleck.github.io/js)
  

<!--YDKJS:p0-->
<!--EQJS:p12-->

[Hello World:](http://www.catb.org/jargon/html/H/hello-world.html)
```js
console.log("Hello, World!");
```

<br />

Ah, JavaScript; I've had mixed feelings about it for years now. My negative feelings, for the most part, were resentment for what the modern web has become and the unneccessary strain on modern devices that is heavy website javascript. I generally feel that javascript should only be used for a small subset of things, and always trivial; using javascript for anything mission-critical or important is dangerous. I imagine that this is not entirely fair, so I've set out to learn the basics, then some, in order to become competent in what is currently a *very popular* language.

<br />

> Because JavaScript borrows concepts and syntax idioms from several languages, including proud C-style procedural roots as well as subtle, less obvious Scheme/Lisp-style functional roots, it is exceedingly approachable to a broad audience of developers, even those with just little to no programming experience. The "Hello World" of JavaScript is so simple that the language is inviting and easy to get comfortable with in early exposure. ...Therein lies the paradox of JavaScript, the Achilles' Heel of the language, the challenge we are presently addressing. **Because JavaScript can be used without understanding, the understanding of the language is often never attained.** ([Kyle](https://github.com/getify/You-Dont-Know-JS/blob/master/preface.md))

>JavaScript: If it can be done in another language, it should be done in another language. ([Doug](http://fuelyourcoding.com/))

> There are those who will say *terrible* things about the JavaScript language. Many of thse things are true. (Eloquent JS, p.6)


<br />



<br />

## Resources

1. [**Eloquent JavaScript**](https://eloquentjavascript.net/) by Marijn Haverbeke.
1. [**Mastering Modular JavaScript (ES6)**](https://github.com/mjavascript/mastering-modular-javascript/tree/master/chapters)
1. [**You Don't Know JS,** Kyle Simpson ](https://github.com/getify/You-Dont-Know-JS)
1. **CodeCademy** [Learn Javascript.](https://www.codecademy.com/courses/learn-javascript-functions)

## ES6 JavaScript
*JavaScript* is the programming language of the web and beyond, with many popular frameworks for building user interfaces and web apps. JavaScript was originally included withing *Netscape Navigator* in 1995 to add programs to webpages. In the programs below, `//>` indicates output printed to the console. Comments are inserted with `//` for shortform and `/* xyz */` for multi-line.


## Why I am Writing Programs in JavaScript
In a coin flip between *Ruby* and *JavaScript*, I chose to go with JavaScript knowing that the barrier to others viewing my neat experiments is much lower if the experiments can be viewed online.

<br />

### Console Output
Useful for debugging and developer interaction, spitting data and text onto the command line is a great way to know if your script is actually functioning, or failed silently.
```js
console.log("Hello, World!");
//> Hello, World!
```

### Primitives
*Primitive Data Types* include *strings, numbers, booleans, null* and *undefined*. **Strings** can be surrounded by single or double quotes. **Numbers** can be integers or floating point numbers. **Booleans** in JavaScript are `true` and `false`, and are explicitly lower-case. **Null** represents an empty value.
```js
let aString = 'Javascript';
let aNumber = 33.7;
let aBoolean = true;
let aNullValue = null;
let anEmptyVariable; //Returns 'undefined'
```

### Algebra
Basic mathematical operators are `+ - * / %`.
```js
let x = (3 + 3) / 2; //Brackets
let x = 3 / 3; //Division
let x = 3 * 3; //Multiplication
let x = 3 + 3; //Addition
let x = 3 - 3; //Subtraction
let x = 3 % 3; //Modulus
```

### Getting Properties
To get more information about a data instance, the *properties* of the object can be printed. For instance, *strings* have a *length* property.
```js
console.log("Wow, a string!".length);
//> 14
let x = "Wow!"
//NOTE: Two ways to do string insertions:
console.log(x + ' is ' + x.length + ' characters in length.');
//> Wow! is 4 characters in length.
console.log(`${x} is  ${x.length} characters in length.`);
//> Wow! is 4 characters in length.
```

### Calling Built-in Methods
Basic data instences in JavaScript inherit the methods of their *prototype*. [Mozilla's site documents these well. Here are the *string* prototype builtin methods.](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/prototype)
```js
console.log('  RCF-lab  '.toUpperCase()); //>     RCF-LAB
console.log('  RCF-lab  '.trim()); //> RCF-lab
```

### Libraries
Libraries contain methods that you can call without creating any instances.
```js
console.log(Number.isInteger(2017));
//> true
```

### Variables
Variables can be declared in JavaScript with *let* and *const*. *Constant* variables cannot be re-assigned, and will throw a *TypeError* if attempted. JavaScript conventions are similar to *Java*: variables begin lowercase, with each additional word capitalized. Variables are assigned with the `=` operator. If no data is assigned, the variable will store the value *undefined*. **Don't use 'var' in ES6.**
```js
const seaLevelAtSeaLevel = 0; //Cannot be changed.
let height = 182; //Modifiable.
let emptyVar; //Undefined.
```

### C-C-Combo Operators
To prevent users fom writing `variable = variable + 2;`, JavaScript has the following built-in *assignment operators*: add `+=`, subtract `-=`, multiply `*=`, increment `++`, and decrement `--`.
```js
x *= 3; //Multiplies x by 3.
x++; //Increments x.
```

### Control Flow
*Control flow* allows a program to selectively execute code, dependant on a boolean evaluation. The following can evaluate as false, and everything else is true: empty strings `""` and `''`, `0` and `-0`, `null`, `undefined`, not a number `NaN`, and `false`. Comparative operators `>`, `<`, `>=`, `<=`, `==`, `!=`, `!` (prepended *not*) and `===` (equal value and type) can be used here. Boolean statements can be combined using *and* `&&` or *or* `||`.

**IF/ELSE** can be used to check basic boolean logic.
```js
if ( value == "key" ) {
  //Evaluate if boolean is true, value equals the string "key".
} else if ( value == "lock" ) {
  //Evaluate if value equals "lock"
} else {
  //Evaluate if boolean is false. Value is something else.
}
```

**SWITCH** should be used if there are many different conditions.
```js
switch (string.toLowerCase()) {
  case 'aardvark':
    console.log("An Aardvark appeared!");
    break;
  case 'bat':
    console.log("A bat appeared!");
    break;
  case 'canteloupe':
    console.log("A Canteloupe appeared!");
    break;
  default:  //AKA else. Runs if no cases are met.
    console.log("Object not recognized.");
    break;
}
```

**TERNARY OP** is a condensed if/else.
```js
value > 3 ? runIfTrue("Hooray!") : runIfFalse("Goodbye.");
//Is the condensed version of the if/else statement below:
if (value > 3) {
  runIfTrue("Hooray!");
} else {
  runIfFalse("Goodbye.");
}
```

**FOR** can iterate through lists of items and objects.
```js
for (x = 0; x < list.length; x++) {
    console.log(`Entry ${x} contains ${list[x]}.`);
}
```

**WHILE** runs until the boolean condition is false.
```js
let x = 0;
while (x <= 9000) { x++; }
console.log("X is over 9000!");
```

### Writing Functions
A variable can store a function by setting it equal to `() => { ... }`.
```js
const warning = () => {console.log("Look out!");}
warning();
//> Look out!
```
Parameters for the function can be placed in the brackets. `(input) => { ... }` Many parameters can be specified when separated by commas.
```js
const addFour = (input) => {return input + 4 ;}
console.log(addFour(5));
//> 9
```
Functions can also be more permanently *declared*:
```js
function name (prams) {  code  }
```

## Fat Arrow Notation
*"Fat Arrow Notation"* is simply a way of expressing functions more simply in JavaScript ES6. The rules are quite simple, and knowing how to read arrow functions can dramatically simplify your programs. This is what a normal function looks like expressed as a verbose function, and simpler fat arrow functions:

```js
// Verbose function syntax:
function increment_a ( x ) {
  return x+1
}

// Store a verbose function as a const:
const increment_b = function ( x ) {
  return x+1
}

// Fat arrow complex:
const increment_c = ( x ) => {
  return x + 1
}

// Fat arrow simple:
const increment_d = x => x + 1

// All of these can be called in an identical manner: increment_*( x )
```

Herein lies the power of simplified functions: it makes it far simpler to pass functions as arguments, as `x => x+1` could be used in many ways.

**Note:** below this point, different function notation will be used where it is relevant. Creating a `function` is best suited to call-anywhere, large functions, whereas arrow functions are best used embedded or for small stateless operations.

## Functional Programming in JavaScript

Currently, the richest library of functional-programming methods is **LoDash**. Using ES6 arrow functions to clearly pass functions as arguments, and functional paradigms, it is possible to write very functional code in JS.

The latest version of Javascript now has builtin map, reduce, filter, and other functional methods. LoDash is not strictly required.

To begin, import LoDash:

```js
const _ = require('lodash')
```

### Functions as Arguments

Functions can be manipulated in JS through a variety of means, though not all are recommended and some reduce readability. The most useful way to utilize functions stored as variables is to pass them as arguments. Two important things to know before proceeding:
1. Adding `()` to a function transforms it into it's return value.
2. Use `const` to avoid state change/ mutable data.

```js
// Simple function that simply runs another function:
const runfunction = function (x, func) {
  return func(x)
}
```

### Map
Applies an operation to every item in an array.
```js
```

### Reduce
```js
```

### Filter
```js
```

### Some and Every
```js
```

### Functional Programming in ES6

Many of the functions present in LoDash have been implemented in the core library of ES6, meaning you usually won't have to import LoDash. Map, reduce and filter all have solid implementations now.


## Linters
I enjoy using the *Standard* linter because of its popularity. Running `standard --fix *.js` cleans the JS I write up nicely, and I've never had problems with execution afterwards. `--fix` does assume you are writing ES6 primarily for NodeJS, and transpiling if you need it to run in a browser.

## Asynchrony

**Resources:**
1. [Essay on Callbacks](https://blog.ometer.com/2011/07/24/callbacks-synchronous-and-asynchronous/)
1. [Async/Await Tutorial](https://javascript.info/async-await)
1. [Learn Promises Before Async/Await](https://medium.com/@bluepnume/learn-about-promises-before-you-start-using-async-await-eb148164a9c8)
1. [Async Map in JavaScript](https://medium.com/@ian.mundy/async-map-in-javascript-b19439f0099)

### Promises

### Callbacks

### Async/Await

## Three.js

**Resources:**
1. [Running game and production walkthrough.](https://tympanus.net/codrops/2016/04/26/the-aviator-animating-basic-3d-scene-threejs/)
2. [ES6/Webpack/ThreeJS starter kit.](https://www.giacomodebidda.com/threejs-project-starter-for-es6-and-webpack2/)
3. Gyro controls [A](https://gist.github.com/bellbind/d2be9cc09bf6241f255d) [B](https://www.learnthreejs.com/device-orientation-gyroscope-controls-tutorial/)

## Web Apps using Express and Socket.IO

Research completed when building <https://github.com/RyanFleck/SocketIOTriviaApp>.

**Express** is a web application framework.

**Socket.IO** is an event-based communication framework.

Combined, these two Node libraries enable the expedited construction of fantastic web applications.

### Express

With NPM installed, Express installation is as simple as `npm i express`.

What I *didn't know* when first using express is:
- Using the `express-generator` is fantastic. It enables the quick creation of a project with the CSS compiler and templating engine of your choice. Read more here: <https://expressjs.com/en/starter/generator.html>. My default is `express --pug --css sass`.

### Socket.IO

First, take a quick walk through the simple and effective tutorial on the Socket.IO homepage.

## ReactJS Library

ReactJS is a Javascript library for building web user interfaces. To learn the basics, I read the tutorial on [reactjs.org](https://reactjs.org/tutorial/tutorial.html).

## React Native

Allows users to build compile-to-native mobile apps in javascript.

## JQuery
### OWL Carousel

## NodeJS and MongoDB
After installing MongoDB and loading <http://media.mongodb.org/zips.json> into the database, (or another from <https://github.com/ozlerhakan/mongodb-json-files>,)

## WebPack
Nothing yet.

## Babel
Babel, an ES6 to ES5 compiler (termed *transpiler* by some,) is a tool for ensuring modern JavaScript code does not confuse older browsers by converting modern (Post-2015) JavaScript to a backwards-compatible version.

For context, I feel I should include the ESV bible verse after which the project is named. The *Babel Fish*, a creature from *Hitchhiker's Guide to the Galaxy* that performs instant translations, also derives its name from this text.

**Genesis 11:1-9 English Standard Version (ESV)**
>Now the whole earth had one language and the same words. And as people migrated from the east, they found a plain in the land of Shinar and settled there. And they said to one another, “Come, let us make bricks, and burn them thoroughly.” And they had brick for stone, and bitumen for mortar. Then they said, “Come, let us build ourselves a city and a tower with its top in the heavens, and let us make a name for ourselves, lest we be dispersed over the face of the whole earth.” And the Lord came down to see the city and the tower, which the children of man had built. And the Lord said, “Behold, they are one people, and they have all one language, and this is only the beginning of what they will do. And nothing that they propose to do will now be impossible for them. Come, let us go down and there confuse their language, so that they may not understand one another's speech.” So the Lord dispersed them from there over the face of all the earth, and they left off building the city. Therefore its name was called Babel, because there the Lord confused the language of all the earth. And from there the Lord dispersed them over the face of all the earth.

## GET ( Pull / Pulk Revolving Doors )

```js
// Map


// Reduce
const accumulate = (arr) => arr.reduce( (acc, x) => acc+=x, 0);

// Filter

// Some & Every


```

```js
function getTopicCount(topic) {
    const https = require('https');
    const wiki = https.get(
        'https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page='.concat(topic.trim()),
        (res) => {
            const response_array = [];
            res.on('data', (x) => {
                response_array.push(x.toString());
            }).on('end', () => {
                console.log((response_array.join('').match(new RegExp(topic, 'g')) || []).length);
            }).on('error', (err) => {
                console.log(`ERR -> wiki -> res\n${err}`);
            });
        },
    ).on('error', (err) => {
        console.log(`ERR -> wiki \n${err}`);
    });
}
```

```js
const { createReadStream, createWriteStream } = require('fs');
const { createInterface } = require('readline');
const stream = require('stream');

function main() {
    // read the string filename
    const filename = readLine();
    const matchobj = {};
    const file = createInterface({ input: createReadStream(`${__dirname}/${filename}`) });
    const outfile = createWriteStream(`${__dirname}/req_${filename}`);

    file
        .on('line', (l) => {
            const timestamp = l.match(/\[.*\]/);
            (timestamp in matchobj) ? matchobj[timestamp] += 1 : matchobj[timestamp] = 1;
        })
        .on('close', () => {
            const keys_matchobj = Object.keys(matchobj);
            const len_matchobj = keys_matchobj.length;
            const output = [];
            for (let y = 0; y < len_matchobj; y++) {
                if (matchobj[keys_matchobj[y]] > 1) {
                    output.push(keys_matchobj[y].substring(1, 21));
                }
            }
            output.forEach(x => outfile.write(x.concat('\n')));
            outfile.end();
        });
}
```

```js
function mergeStrings(a, b) {
    const len_a = a.length;
    const len_b = b.length;
    const a_greaterthan_b = len_a > len_b;
    const a_equalto_b = len_a === len_b;
    const shortest_str = a_greaterthan_b ? len_b : len_a;
    const ans = [];

    let x = 0;
    for (x; x < shortest_str; x++) {
        ans.push(a[x]);
        ans.push(b[x]);
    }

    if (!a_equalto_b) {
        ans.push((a_greaterthan_b ? a : b).substring(x));
    }

    return ans.join('');
}
```

<!--
### T
```js
//> O
```
-->
