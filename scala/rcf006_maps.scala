/*RCF-2018--Scala-2.10------<-min-width-80-chars->-----------------------------
 *
 * Maps are collections of key:value pairs. 
 *  Access keys using name.keys
 *
 */

val translations = Map( "grok" -> "understand", "vernacular" -> "common group speech patterns", "coding" -> "dullard for writing python or javascript programs", "coder" -> "an infantile computer programmer", "jargon" -> "a collection of special slang indistiguishable from gibberish by anybody not involved in the community where it is applied.", "a" -> "bc", "x" -> "yz" )

// Some basic examples of accessing/checking for data.
println( translations.keys )
println( translations.get("x") ) //Will return none if not found.
println( translations("x") )
println( translations contains "grok" )
println( translations contains "sue" )
println( translations getOrElse("c","No value 'c'!") )
println( translations getOrElse("grok","No value 'grok'!") )

// Maps are immutable.
println( translations )
//translations = Map("a"->"b")  //Cannot reassign :)
println( translations + ("sriracha"->"makes most food items more palatable."))
println( translations )

// qrs
