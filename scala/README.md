# Programming in Scala

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/scala](https://ryanfleck.github.io/scala)
  

[Hello World:](http://www.catb.org/jargon/html/H/hello-world.html)

<iframe height="200px" frameborder="0" style="width: 100%" src="https://embed.scalafiddle.io/embed?sfid=41wVc7n/0&layout=v50"></iframe>

```scala
println("Hello, World!")
```


<br />



<br />


## Why I am Writing Programs in Scala
*Xalgorithms* work is currently done on a base of scalable technologies: Kafka, Akka, Spark, Kubernetes, etc. To contribute to the project, I've learned a little Scala.

## Scala

> Scala is a modern multi-paradigm programming language designed to express common programming patterns in a concise, elegant, and type-safe way. It smoothly integrates features of object-oriented and functional languages.

What? Object-oriented *and* functional? Neato. Scala is used for implementing the core rule processor of the Xalgorithms project. I've been asked to make some minor contributions, and take a look at some bugs. | ![Scala Sprial]({{ site.url }}/assets/scala-spiral.png)

Case sensitive **Class Names** are written in CamelCase `LikeThis`, **Method Names** are written in lesser-camelcase `likeThis`, programs end with `.scala`, and require an entry point expressed as `def main(args: Array[ String ]){}`. Identifiers must start with a letter or underscore and are case-sensitive.

Comments are expressed identically as they appear in *Java*. That is, single-line with `//` and multiline with `/* *xyz */`.

*Interestingly*, statements can be terminated with either a semicolon or newline. The semicolon is totally optional, unless multiple statements are expressed on the same line (it will be optional on the last statement.)
```scala
val s = "String"; println(s)
```

**Packages** are declared on the first non-comment line:
```scala
package com.testprog.stuff //Package declaration
import scala.xml._ //The contents of scala.xml
import scala.collection.mutable.HashMap //A single class/object
import scala.collection.mutable.{HashMap, TreeMap, TreeSet}
```

### Apply Dynamic
*Oh, this is new...* Apply, select, update - dynamic if type checking fails?

> A marker trait that enables dynamic invocations.




<br />


## ScalaJS
