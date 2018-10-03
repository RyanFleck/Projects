// Useful functions for handling prime numbers.

// Returns true if x is prime.
function primep(x) {
  const sqx = parseInt(Math.sqrt(x));
  for (let i = 2; i <= sqx; i++) {
    if (x % i == 0) { return false; }
  }
  return true;
}

// Returns true if x is a factor of y.
function factorp(x, y) {
  return ((y % x) == 0);
}

// Sums primes from two to x.
function sumto(limit) {
  let sum = 2;

  for (let x = 3; x < limit; x += 2) {
    if (primep(x)) { sum += x; }
  }
  console.log(`Primes below ${limit} add to ${sum}`);
  return sum;
}

module.exports = { primep, factorp, sumto };
