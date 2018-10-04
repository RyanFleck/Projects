// Calculate the sum of primes.
const prime = require('./rcf022_PrimeLib');

console.log(prime.primep(7));

const limit = 2000000;
let sum = 2;

for (let x = 3; x < limit; x += 2) {
  if (prime.primep(x)) {
    sum += x;
    // console.log("Adding prime "+x+" to total, now "+sum);
  }
}
console.log(`Primes below ${limit} add to ${sum}`);

// Add to primelib.

console.log('\nTest primelib:\n');
console.log(`7 is prime? ${prime.primep(7)}`);
console.log(`3 is a factor of 9? ${prime.factorp(3, 9)}`);
console.log(`Sum of primes under 10? ${prime.sumto(10)}`);
