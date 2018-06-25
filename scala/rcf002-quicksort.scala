//RCF-2018------------------<-min-width-80-chars->-----------------------------

object QuickSortTest{

  def main(args: Array[String]){
    println("Hello, World!");
    val x = Array(1,2,3,4,5,9,8,7,6); 
    println(quicksort(x));
  }

  // Tons of diagnostic println, see rcf003-quicksort for clean implementation
  def quicksort(ar1: Array[Int]){
  
    println("[dbg] Sorting");
    
    def swap(i: Int, j: Int){
      println("[dbg] Swapping "+i+" and "+j)
      val swpvar = ar1(i);
      ar1(i) = ar1(j);
      ar1(j) = swpvar;
    }
    
    def sort(start_point: Int, end_point: Int){
      var x = start_point; var y = end_point;
      val pivot = ar1((x+y)/2);

      println("[dbg] Comparing indices "+start_point+" and "+end_point+", pivot = "+pivot+".");
      
      while( x <= y ){
        while( ar1(x) < pivot ) x+=1;
        while( ar1(y) > pivot ) y-=1;
        if(x <= y){
          swap(x,y)
          x+=1
          y-=1
        }
        if (start_point < y) sort(start_point, y);
        if (y < end_point ) sort(y, end_point);
      
      }
    }
    
    sort(0,ar1.length-1);
 
  } 
}
