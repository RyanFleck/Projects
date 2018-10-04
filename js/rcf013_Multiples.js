/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all
 * the multiples of 3 or 5 below 1000.
 */

let answer = 0;
const max = 1000;

for (let x = 3; x < max; x += 3) {
  answer += x;
}

for (let x = 5; x < max; x += 5) {
  if (x % 3 != 0) { answer += x; }
}

console.log(`\nSolution: ${answer}\n`);
