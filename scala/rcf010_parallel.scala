/*RCF-2018--Scala-2.10------<-min-width-80-chars->-----------------------------
 *
 * { Course Notes: Scala Essential Training for Data Science }
 *
 * Parallel Collections 
 *  Easier to write code with parallel collections.
 *  Replace FOR loops that has to process >thousands of items with parcols.
 * 
 * Sequential -> Parallel Replacements:
 * ====================================
 * Array    ->    ParArray
 * Vector   ->    ParVector
 * HashMap  ->    ParHashMap
 * HashSet  ->    ParHashSet
 *                               etc...
 * 
 * Creation:
 *  1. Convert a sequential collection.
 *  2. Instantiate a collection as parallel.
 */

import scala.collection.parallel.immutable.ParVector

// Simple parallelize:
val rng100 = 1 to 100
val p_rng100 = rng100.par

val p_vec200 = ParVector.range(0,200)
//p_vec200.foreach(println) // Notice how the order is wild.

val v = (1 to 20).toArray.par
v.foreach(println)
v.map( _*2 ).foreach(println)
v.foreach(println) //Immutable, MAP did not mutate array.

def cube ( x:Int ) :Int = { x*x*x }

println(cube(3))
v.map(cube).foreach(println)

/* 
 * MAP:     Apply an operation to each indice.
 * FILTER:  Keep only indices which match a criteria.
 * REDUCE:  
 */
println("\nFilter:")
v.filter( _<5 ).foreach(println)
println("\nFilterNot:")
v.filterNot( _<5 ).foreach(println)

// Apply a function to every element in a ParArray

def deCubeable ( x:Int ) : Boolean = { (x%3)==0 }

println("9 is decubeable? => "+deCubeable(9))
println("10 is decubeable? => "+deCubeable(10))

println("\ndeCubeable:")
v.filter(deCubeable).foreach(println)

/*
 * When NOT to use parallel collections:
 *   1. When a procedure causes side effects. (Nondeterminism)
 *   2. Nonassociative operations (if order of operations matters)
 */
