const r = require('./rcf_lib')

//const arr = r.parseToString('poetry/bigsum.txt').split('\n').map((x)=>parseInt(x))
const arr = r.parseToIntArray('poetry/bigsum.txt')


const firstDigs = (num, digs) => {
  return num.toString().replace('.','').slice(0,digs) 
}

// Test firstDigs
//let number = 12341234123412341234
//console.log(firstDigs(number,10))

const sumIntArray = (array) => {
  return array.reduce((sum,n)=>sum+n);
}

// Test sumIntArray
//console.log(sumIntArray([0,1,2,3]))

// Attempt 1: Failure. Number too large.
//console.log("Answer: "+firstDigs(sumIntArray(arr),10))

const sumIntArray2 = (array) => {
  return array.reduce((sum,n)=>{
    //console.log("Sum: "+sum+", adding "+n) 
    return sum+n});
}

// Test sumIntArray2
//console.log("Final sum: "+sumIntArray2([0,1,2,3]))

//console.log("Final sum: "+sumIntArray2(arr)) 

//Issue was a problem with my library and parsing intarray.
console.log("Answer: "+firstDigs(sumIntArray(arr),10))
