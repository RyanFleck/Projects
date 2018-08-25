const r = require('./rcf_lib')
const _ = require('lodash')

r.title('Functional Programming Tests ][')

r.subtitle('Passing .map() An Array')

const chars = ['a', 'b', 'c', 'd', 'e', 'f']
const nums = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
const charcapdub = _.map(chars, function (element) {
  return element.toUpperCase().repeat(2)
})

console.log(chars) // a, b, c ...
console.log(charcapdub) // AA, BB, CC ...

// Take ownership over your life and habits. It's you.
// Learn to accept failure. It's alright to look like an idiot as long as you learn.
// What you do at 8PM matters. (Or 5AM. Form productive habits.)
// Success is a lonely road, while failure is a crowded highway.
// Finish the projects that you begin; the last 10% is the most difficult/rewarding.

r.subtitle('Filtering Arrays')

const evens = _.filter(nums, function (element) {
  return element % 2 === 0
})

console.log('Nums: ' + nums)
console.log('Evens: ' + evens)

// !Thicc arrow syntax =>
// const func = (x,y) => { do stuff with x and y };
// If only one arg:  const func = x => { do stuff };
// If no args:  const func = () => { do stuff };

const employees = [
  {name: 'A', salary: 30000},
  {name: 'B', salary: 40000},
  {name: 'C', salary: 90000},
  {name: 'D', salary: 100000},
  {name: 'E', salary: 120000}
]

// Filter
const underpaid = _.filter(employees, (employee) => employee.salary < 70000)
console.log(underpaid)

// Some
const containsEvenNumbers = (array) => {
  return _.some(array, (element) => element % 2 === 0)
}

// Every
const allEvenNumbers = (array) => {
  return _.every(array, (element) => element % 2 === 0)
}

console.log('NUMS contains even numbers: ' + containsEvenNumbers(nums))
console.log('NUMS is all even numbers: ' + allEvenNumbers(nums))

/*
 * Perhaps it is best to save the arrow notation for specific use-cases, like
 * short boolean tests or returning arguments for reducing an array. Seems
 * strange to use them everywhere, though they're definitely better than a
 * full function xyz() {} when the function is just one return statement.
 */

r.subtitle('Filtering Arrays')
