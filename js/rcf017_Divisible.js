// Calculate the smallest positive number, evenly divisible by all numbers 1-20

/*
for(let b = 8; b <= 20; b++){
  alg1(b);
} */

alg1(20);

function alg1(limit) {
  console.log(`Testing ${limit}`);
  const answer = 0;
  let y = limit;
  while (true) {
    if (omniDivisible(y)) { break; }
    y += limit;
    // console.log("Testing "+y);
  }
  console.log(`  Answer: ${y}`);

  function omniDivisible(a) {
    for (let z = limit; z > 1; z--) {
      // console.log(a+"%"+z);
      if (a % z != 0) { return false; }
    }
    return true;
  }
}
