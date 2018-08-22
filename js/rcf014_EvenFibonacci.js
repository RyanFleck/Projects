/*
 * Finds the sum of all even Fibonnaci terms below four million.
 *
 *   x is current fib number.
 *   z is prev fib number.
 *   t is temp.
 * 
 * Make it work, then make it work fast. 20180822
 */

let answer = 0;
let x = 1;
let z = 0;
let t = 0;

while(x < 4000000){
  if(x%2==0){
    answer+=x;
    console.log(x);
  }
  x = fib(x);
}

// Was checking for four billion instead of million. Wow.

/*
let z = 1;
let x = 2;

while(x<4000000000){
  console.log("found:"+x);
  answer+=x; 
  console.log("total:"+answer);
  x=fib3(x); 
}
*/

function fib(x){
  t=x;
  x=x+z;
  z=t;
  return x;
}

/*
function fib3(x){
  x = fib(x); 
  x = fib(x); 
  x = fib(x); 
  return x;
}
*/
console.log("\nSolution: "+answer+"\n");
