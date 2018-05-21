# Ryan's JavaScript Manual

```js
console.log("Hello, World!");
```


## ES6 JavaScript
*JavaScript* is the programming language of the web and beyond, with many popular frameworks for building user interfaces and web apps. `//>` indicates output printed to the console. Comments are inserted with `//` for shortform and `/* xyz */` for multi-line.

### Console Output
Useful for debugging and developer interaction, spitting data and text onto the command line is a great way to know if your script is actually functioning, or failed silently.
```js
console.log("Hello, World!");
//> Hello, World!
```

### Primitives
*Primitive Data Types* include *strings, numbers, booleans, null* and *undefined*. **Strings** can be surrounded by single or double quotes. **Numbers** can be integers or floating point numbers. **Booleans** in JavaScript are `true` and `false`, and are explicitly lower-case. **Null** represents an empty value.
```js
console.log('Javascript');
console.log(33.7);
console.log(true);
console.log(null);
```

### Algebra
Basic mathematical operators are `+ - * / %`.
```js
var x = (3 + 3) / 2; //Brackets
var x = 3 / 3; //Division
var x = 3 * 3; //Multiplication
var x = 3 + 3; //Addition
var x = 3 - 3; //Subtraction
var x = 3 % 3; //Modulus
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
Variables can be declared in JavaScript with *let* and *const*. *Constant* variables cannot be re-assigned, and will throw a *TypeError* if attempted. JavaScript conventions are similar to *Java*: variables begin lowercase, with each additional word capitalized. Variables are assigned with the `=` operator. If no data is assigned, the variable will store the value *undefined*.
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
if (value > 3) {
  runIfTrue("Hooray!");
} else {
  runIfFalse("Goodbye.");
}
//Can be condensed to:
value > 3 ? runIfTrue("Hooray!") : runIfFalse("Goodbye.");
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

## ReactJS Library

ReactJS is a Javascript library for building web user interfaces. To learn the basics, I read the tutorial on [reactjs.org](https://reactjs.org/tutorial/tutorial.html).

## React Native

Allows users to build compile-to-native mobile apps in javascript.

## JQuery
### OWL Carousel

<!--
### T
```js
//> O
```
-->
