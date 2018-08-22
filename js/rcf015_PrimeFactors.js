// Lists the largest prime factor. 

let initial = 879643292384;
let target = parseInt(Math.sqrt(initial));
let answer = 0;

while(target>0){
  if(primep(target) && factorp(target)){
    answer = target;
    break;
  }
  target--;
}

function primep( x ){
  let sqx = parseInt(Math.sqrt(x)); 
  for(let i = 2; i <= sqx; i++){
    if ( x % i == 0 )
      return false;
  }
  return true
}

function factorp(x){
  return (( initial % x) == 0);
}

console.log("\nSolution: "+answer+"\n");
