const r = require('./rcf_lib')

//const arr = r.parseToString('poetry/bigsum.txt').split('\n').map((x)=>parseInt(x))
const arr = r.parseToIntArray('poetry/bigsum.txt')
console.log(arr.slice(0,10))


const firstDigs = (num, digs) => {
  return num.toString().slice(0,digs) 
}

// Test firstDigs
//let number = 12341234123412341234
//console.log(firstDigs(number,10))

const sumIntArray = (array) => {
  return array.reduce((sum,n)=>sum+n);
}

// Test sumIntArray
//console.log(sumIntArray([0,1,2,3]))

console.log("Answer: "+firstDigs(sumIntArray(arr),10)) //Fails.
