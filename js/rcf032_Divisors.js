// First triangle number with greater than five hundred divisors?

const debug = true;
const rlog = (str) => {if(debug){ console.log(str) }}

const getTriangleNumber = (lastint) => {
  let acc = 0; 
  for(let x=1;x<=lastint;x++){
    acc+=x; 
  }
  return acc;
}

const getDivisors = (trinum) => {
  //sq = parseInt(Math.sqrt(trinum)) 
  let half = parseInt(trinum/2)
  const ans = [1]; 
  for(let x=2;x<=half;x++){
    if(trinum%x==0)
      ans.push(x) 
  }
  ans.push(trinum)
  return ans
}

const getDivisorLen = (trinum) => getDivisors(trinum).length

//console.log(getTriangleNumber(5))
//console.log(parseInt(Math.sqrt(28)))
//console.log(getDivisors(28))

const algo12 = (start,upto) => {
  // Log/Test this.  
  let acc = getTriangleNumber(start-1)
  let max = 0
  for(let x=start;x<=upto;x++){
    acc+=x
    rlog("Testing "+x+", acc="+acc) 
    let divisors = getDivisors(acc)
    rlog("Divisors: "+divisors) 
    let dlen = divisors.length
    console.log(x+": "+dlen)
    if(x%1000==0)
      console.log("Milestone: "+x)
    if(dlen>max){
      max=dlen;
      console.log(x+": "+max);
      if(dlen >= 500){
        console.log("Testing "+x+", acc="+acc) 
        console.log("Divisor len: "+dlen) 
        return acc;
        // break;
}}}}

const getDivisors_Fast = (trinum) => {
  let half = parseInt(trinum/2)
  const ans = [1]; 
  for(let x=2;x<=half;x++){
    if(trinum%x==0){
      ans.push(x)
    }else if(x <= 6){
      break;
    }
  }
  ans.push(trinum)
  return ans
}
/* Algo12_Fast
 * Speed improvements made by quitting earlier.
 */

const algo12_Fast = (start) => {
  let acc = getTriangleNumber(start-1)
  let max = 0
  for(let x=start;max<500;x++){
    acc+=x
    let divisors = getDivisors_Fast(acc)
    let dlen = divisors.length
    //console.log(x+": "+dlen)
    if(x%1000==0)
      console.log("Milestone: "+x)
    if(dlen>max){
      max=dlen;
      console.log(x+": "+max);
      if(dlen >= 500){
        console.log("Testing "+x+", acc="+acc) 
        console.log("Divisor len: "+dlen) 
        return acc;
        // break;
}}}}

// Failure.
const scaleCalibrate1 = () =>{
  let len = 0
  let x = 1 
  while(len<500){
    len = getDivisorLen(x)
    console.log(x+": "+len)
    x = x * 2;
  }
}

const scaleCalibrate2 = (targetDivLen) =>{
  //let divisors = []
  let acc=1;
  for(let l = 1; l<targetDivLen; l++){
    acc = acc*l; 
    console.log(l+": "+acc);
    //divisors.push(l); 
  }
  console.log("The answer should be around "+acc);
}

//algo12(5,7)
//scaleCalibrate2(500)
//algo12(2079,2079)
//algo12(5984,5984)
// None 5984-9000
//algo12(12372,100000)
algo12_Fast(0)

// Rough Answers:
// 2079: 320
// 5984: 480
// 9855: 448 , none 10k, 11k sparse, 12375.
