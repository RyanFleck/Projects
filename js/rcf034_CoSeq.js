const r = require('./rcf_lib')

const odd = x => ((3 * x) + 1)
const even = x => (x / 2)
const roof = 1000000

let x = 1
let chains = [0]
while (x < roof) {
  let y = x
  let ychain = [y]

  while (y > 1) {
    y = (y % 2 === 0) ? (even(y)) : (odd(y))
    ychain.push(y)
  }

  chains[x] = ychain.length
  // console.log("Chain for "+x+" generated. Length: "+chains[x]+"\n\t"+ychain+"\n")
  x++
}

const chainMax = (chain) => {
  const copy = chain.slice()
  copy.sort((a, b) => b - a)
  return copy[0]
}

const max = chainMax(chains)
console.log('Max Chain:' + max + ' at indice ' + chains.indexOf(max))
