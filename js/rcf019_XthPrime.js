// Lists the nth prime number.

alg7(4)
alg7(10341)

function alg7 (target) {
  let prime = 1
  let indice = 0

  while (indice < target) {
    prime++
    if (primep(prime)) { indice++ }
  }
  console.log('Solution: prime ' + indice + ' is ' + prime + '.')
}

function primep (x) {
  let sqx = parseInt(Math.sqrt(x))
  for (let i = 2; i <= sqx; i++) {
    if (x % i == 0) { return false }
  }
  return true
}
