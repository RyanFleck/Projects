// Useful functions for handling prime numbers.
// Just temp until I can get home and install math.js module.

// Returns true if x is prime.
function primep (x) {
  let sqx = parseInt(Math.sqrt(x))
  for (let i = 2; i <= sqx; i++) {
    if (x % i == 0) { return false }
  }
  return true
}

// Returns true if x is a factor of y.
function factorp (x, y) {
  return ((y % x) == 0)
}

// Sums primes from two to x.
function sumto (limit) {
  let sum = 2

  for (let x = 3; x < limit; x += 2) {
    if (primep(x)) { sum += x }
  }
  console.log('Primes below ' + limit + ' add to ' + sum)
  return sum
}

// Returns array with numbers 1 through x
function range (x) {
  const arr = []
  for (let y = 0; y < x; y++) {
    arr.push(y)
  }
  return arr
}

// Returns sum based on type.
function sum (x) {
  let arglen = arguments.length
  if (arglen > 1) {
    // Ensure all args are same type.
    // Sum args.
    return 0
  } else if (arglen == 1) {
    switch (typeof x) {
      default:
        console.log(typeof x)
        break
    }
  } else {
    return 0
  }
  console.log('Sum ' + arguments.length + ' args: ' + arguments.toString())
}

function title (y) {
  console.log(ulplus(y))
}

function subtitle (y) {
  console.log(ul(y))
}

// Internal Library Methods

function ul (str) {
  return ('\n' + str + ' \n' + '-'.repeat(str.length) + '+')
}

function ulplus (str) {
  return ('\n'.repeat(9) + '\t ' + str + ' \n\t' + '+' + '-'.repeat(str.length) + '+\n')
}

function prObj (name, obj) {
  console.log('\n' + name + ' Properties:\n' + JSON.stringify(obj, null, 2))
}

module.exports = { primep, factorp, sumto, range, sum, title, subtitle }
