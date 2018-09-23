import Array._

/* Scala Collections:
 *  Sequences      (Seq)
 *   Vectors
 *   Streams
 *   Lists
 *   Queues
 *   Strings
 *   Stacks
 *  Sets           (Set)
 *   HashSet
 *   SortedSet
 *   TreeSet
 *   BitSet
 *   ListSet
 *  Maps           (Map)
 *   HashMaps
 *   SortedMaps
 *   ListMaps
 *   TreeMaps
 *
 * Mutable collections can change. (obv) Assign with 'var'.
 * Immutable collections cannot change.  Assign with 'val'.
 */

println("RCF005 - Collections.")

/* vec rng
 * Arrays:
 *  Mutable, indexed collection of values.
 */
val temperatures = Array(23, 25, 31, 15, 18, 5, 41, 9)

println("First indice: "+temperatures(0))
println(temperatures.mkString(" "))
println("Length of array: "+temperatures.length)
temperatures(0) = 19

println("First indice modified: "+temperatures(0))
printArray(temperatures)

val numbers : Array[Int] = new Array[Int](10) //Every indice is zero.
printArray(numbers)

val numbers2D = Array.ofDim[Int](10,10) // 10x10 array.
printArray2D(numbers2D)

// Concatenate arrays.

val a : Array[Int] = Array(2,3,4,5)
val b : Array[Int] = Array(6,7,8,9)
val c = concat(a,b)
printArray(c)

/* 
 * Vectors:
 *  Mutable, indexed collection of values.
 */

val v1 :Vector[Int] = Vector(1,2,3,4,5)


/* 
 * Ranges:
 *  Mutable, indexed collection of values.
 */

val r1 = 1 to 10
val r2 : Range = new Range(1, 79, 3) //Start,Stop,Step

/*
 * Supportive functions.
 *
 */

def printArrayCore( x:Array[Int] ){
  println(x.mkString(" "))
}

def printArray( x:Array[Int] ){
  println("Array of "+x.length+" Ints:")
  printArrayCore(x)
}

def printArray2D( x:Array[Array[Int]] ){
  println(x.length+"x"+x(0).length+" Array:")
  x.foreach(printArrayCore)
  //x.foreach(y => println(y.mkString(" ")) )
}

