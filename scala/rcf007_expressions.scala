/*RCF-2018--Scala-2.10------<-min-width-80-chars->-----------------------------
 *
 * Most basic ops are supported. 
 * {  +  -  *  /  %  } just like Java.
 * Shorthand { *=  +=  -=  /= } also available.
 *
 * Relational expressions also supported.
 * {  >  <  >=  <=  ==  !=  } just like Java.
 * {  &&  ||  !( )   } can (obv) be used to combine these.
 *
 */

var b :Int = 5 
b *= 2
println( b )
b /= 2
println( b )

/*
 * Use the 'blocking mechanism' to perform multiple 
 *  operations in a single... expression? 
 */

println({
  val c = 13 * 2
  val d = 12
  c + 2
  d + 2   // It just passes the last one to the println neat.
})


