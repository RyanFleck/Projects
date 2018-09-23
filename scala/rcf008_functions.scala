/*RCF-2018--Scala-2.10------<-min-width-80-chars->-----------------------------
 *
 * Functions
 *  def func( a:Type, b:Type ) : ReturnType = {
 *    return c
 *  }
 *
 * Procedures -> Function that doesn't return a value.
 *               Used to produce side effects.
 *  def proc( a:Int ) : Unit = {
 *    println(a)
 *  } 
 *
 * Unit is equivalent to Void in java.
 *
 */

def add( a:Int, b:Int ) : Int = {
  return a + b
}

println( add( 1, 2) )


def proc( a:Int ) : Unit = {
  println(a)
} 

proc(5)
