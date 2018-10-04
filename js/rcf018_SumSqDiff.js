// Calculate the difference between the sum of squares and square of sums.

alg6(10);
alg6(100);

function alg6(x) {
  console.log(x);
  const answer = squareOfSum(x) - sumOfSquares(x);
  console.log(answer);

  function sumOfSquares(y) {
    let acc = 0;
    for (let z = 1; z <= y; z++) {
      acc += (z * z);
    }
    return acc;
  }

  function squareOfSum(y) {
    let acc = 0;
    for (let z = 1; z <= y; z++) {
      acc += z;
    }
    return acc * acc;
  }
}
