# Programming in Java

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/java](https://ryanfleck.github.io/java)
  

[Hello World:](http://www.catb.org/jargon/html/H/hello-world.html)
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

<br />


<br />

## Why I am Writing Programs in Java

All the University courses teach in Java. It is a powerful Object-Oriented programming language used for many enterprise-grade systems. I am re-learning more advanced java for application in my workplace.

## Tools and Installation

1. Install a text editor or IDE.
2. Install the JDK.
3. Add the JDK's `bin` to your `PATH` if on Windows.

## Java 8 Essentials

### Introduction

To support a new project at work, I am brushing up on my Java skills. That primarily involves running through a Java course on Linkedin Learning. Work began on Java in 1991, with the goal of creating a "write once, run anywhere" programming language. Heavy focus on stability and security.

> Interpreted, threaded, dynamic, object-oriented.

Java is compiled to cross-platform bytecode instead of machine language. Unlike C++, it only needs to be compiled once; the JVM and core runtime will handle all low-level operations.

Memory access is managed in Java. C++ has explicit memory management (easy to introduce bugs.)

> Case sensitive, whitespace insensitive,

### Basic Language Overview

All code is defined in classes with a `.java` extension. Commands `javac` and `java` compile and run a Java application.

```java
package com.rcf; // Package declaration.

public class Main { // Class declaration.

    // Le classic PSVM:
    public static void main(String[] args) { // Main method.
        System.out.println("Hello, Java!");
    }
}
```

**Package** is a global, unique string to ensure global unique identifiers.

**Identifiers** are names used to encapsulate classes, methods, fields, variables and other names. They must start with an alpha character or underscore, cannot be keywords, and are case sensitive.

- Class identifiers start with an uppercase character.
- Methods and variables start with a lowercase character.
- Constants are all uppercase.

```java
// Constants are static and final.
public static final String CONST = "Hello?";
```

*Every programming language has slightly different critical syntax rules.*

Like in C#, memory for objects is allocated automatically. Small objects are stored in faster stack memory. Larger complex objects are stored in heap memory. You can explicity dereference variables by setting them to `null`. The Garbage collector gets its own thread. To manage memory:
- Minimize the number of objects you create.
- Use `Runtime.maxMemory()` and `Runtime.totalMemory()` to find out how much RAM is allocated/in use.

### Basic Usage

**STOP.** I've placed awful placeholder programs past this point. This manual needs more work.

#### Hello World

```java
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

### Variables
```java
private static int = 2;
```
### Objects
```java
PlanetDestroyer DeathStar = new PlanetDestroyer("v1");
```

### Exceptions
```java
try{
    // Something risky
}catch(OhNoACommonMistake e){
    // Clean up mess
}
```

### Control Flow
```java
if( something ){
    somethingElse();
}
```

### Data Collections
```java
int a[] = new int[2];
```

### Classes

```java
package com.rcf;

public class Printer {
    public static void log(String x){
        System.out.println(x);
    }
}
```

```java
package com.rcf;

public class Main {

    private static Printer p = new Printer();

    public static void main(String[] args) {
	    // write your code here
        System.out.println("Hello, Java!");
        p.log("I still remember some Java.");
        // ...and I forgot how nice it was.
        // ...and how awful and stubborn it was.
    }
}
```

### Inheritance and Polymorphism

```java
package com.rcf;

public class Printer2 extends Printer {
    public static void doublelog(String x){
        System.out.println(x);
        System.out.println(x);
    }
}
```

### Common Java Libraries

### Preparing for Deployment

Use javadoc.

## The Best Parts of Java

```
->
::
```

## Handling XML

### The Dom4j Library

In production, my current internship uses objects and methods from <https://dom4j.github.io/> to load and process XML doucments. For more information about XML and XPath, please refer to <{{site.url}}/xml>

### Loading XML From File

### Loading XML From URL

## SpringBoot

```
spring
```

## Maven

```bash
mvn package
```

## uOttawa Java

Hopefully I'll remark here about the data structures course at some point.

## Eclipse

`CTRL + SHIFT + F` formats the document.