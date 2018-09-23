/*RCF-2018--Scala-2.10------<-min-width-80-chars->-----------------------------
 *
 * Objects
 *  Good ol' OOP. Robust and familiar.
 *
 */

val z = Array("Python","Haskell","Erlang","Racket","Steel Bank Common Lisp")

println("\nOriginal:")
z.foreach(println)

println("\nSorted:")
z.sorted.foreach(println) //short for (x) => println(x)

class vehicle(var make:String, var model:String, var age:Float, private var cargo:Array[String])

val mycar = new vehicle("Ford","T-Series",101,Array("Gum", "Pretzels"))

println("\nMy Car:\n" + mycar.make + " " + mycar.model)


class coord(cx:Int,cy:Int) {
  var x: Int = cx 
  var y: Int = cy

  def travel( deltax:Int, deltay:Int ) : Unit = {
    x += deltax
    y += deltay
  }

  def location() : Array[Int] = {
    println( x + " " + y )
    return Array(x,y)
  }
}

val a = new coord(4,5)
a.location()

a.travel(1,-1)
a.location()

