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
