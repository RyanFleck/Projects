//rcf-2018------------------<-min-width-80-chars->-----------------------------

object X{
  def main(args: Array[String]){
    println("RCF-03: Functional Quicksort");
    val test = Array(0,5,2,7,4,9,8,3,1,6); 
    println("Unsorted: "+test.mkString(" "))
    println("Sorted:   "+quicksort(test).mkString(" "))
  }

  def quicksort(x: Array[Int]): Array[Int] = {
    if(x.length <= 1) x
    else{
      val p = x(x.length/2)
      Array.concat(
        quicksort(x filter (p >)),
        x filter (p ==),
        quicksort(x filter (p <))
      )
    } 
  }
}
