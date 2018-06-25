//RCF-2018------------------<-min-width-80-chars->-----------------------------

object QuickSortTest{


  def main(args: Array[String]){
    println("Hello, World!");
    val x = List(1,2,3,4,9,8,7,6)
    println(quicksort(x));
  }


  def quicksort(ar1: Array[Int]){
  
    println("Sorting");
    
    def swap(i: Int, j: Int){
      val swpvar = ar1(i);
      ar1(i) = ar1(j);
      ar1(j) = swpvar;
    }
    
    def sort(start_point: Int, end_point: Int){
      var x = start_point; var y = end_point;
      val pivot = ar1((x+y)/2);

      while( x <= y ){
        while( ar1(x) < pivot ) x+=1;
        while( ar1(y) < pivot ) y-=1;
        if(x <= y){
          swap(x,y)

        }
         
      
      }
    }
    
    sort(0,ar1.length-1);
    
    
  }
    
  
}
