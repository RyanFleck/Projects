# Programming in Java

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/java](https://ryanfleck.github.io/java)
  

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, Java!");
    }
}
```

<br />


<br />

## Why I am Writing Programs in Java

Java is a powerful Object-Oriented programming language used to create complex, scalable, reliable enterprise applications. The University of Ottawa uses Java and C to teach Operating Systems, Data Structures and Software Engineering. At *MNP LLP*, I applied Java to extend client *WCMS* systems built on *Spring*.

I will also be using Java at my upcoming Summer internship at IBM. While not my most active manual, I expect this page to see tremendous growth in the next few months.

### Tools and Installation

1. Install a text editor or IDE.
    1. Beginners should use a bare text editor to understand the language.
    1. For projects of scale, use Eclipse or IntelliJ IDEA.
2. Install the JDK.
3. Add the JDK's `bin` to your `PATH` if on Windows.

### Resources

1. [Oracle Java Material](https://www.oracle.com/technetwork/java/index-jsp-135888.html) (also [Java EE](https://www.oracle.com/technetwork/java/javaee/documentation/tutorials-137605.html))
1. Plenty of examples on [Mkyong](http://www.mkyong.com/)
1. [SpringBoot docs](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/#boot-documentation)
1. [TechBeamers articles](https://www.techbeamers.com/category/programming-tutorials/java-tutorials/)
1. [Project Suggestions](https://blog.udemy.com/java-projects/)


## Java 8 Essentials

### Introduction

Work began on Java in 1991, with the goal of creating a "write once, run anywhere" programming language. Heavy focus on stability and security. Java is interpreted, threaded, dynamic, and object-oriented. Source code is compiled to cross-platform bytecode instead of machine language. Unlike Java's main competitor (at the time,) C++, it only needs to be compiled once; the JVM and core runtime will handle all low-level operations. Memory access is managed in the Java Virtual Machine (JVM). C++ has explicit memory management, which is easier to mishandle.

All code is defined in classes with a `.java` extension. Commands `javac` and `java` compile and run a Java application.

```java
package com.rcf.example; // Package declaration.

public class Main { // Class declaration.

    // Classic PSVM:
    public static void main(String[] args) { // Main method.
        System.out.println("Hello, Java!");
    }
}
```

**Package** is a global, unique string to ensure global unique identifiers. Conventionally, package names are based on the domain name for the project, so `docs.oracle.com` becomes `com.oracle.docs`.

**Identifiers** are names used to encapsulate classes, methods, fields, variables and other names. They must start with an alpha character or underscore, cannot be keywords, and are case sensitive.

- Class identifiers start with an uppercase character.
- Methods and variables start with a lowercase character.
- Constants are all uppercase.

```java
// Constants are static and final.
public static final String CONST = "Hello?";
```

*Every programming language has slightly different critical syntax rules.* Read Java's official set of code conventions [here](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf)

Like in C#, memory for objects is allocated automatically. Small objects are stored in faster stack memory. Larger complex objects are stored in heap memory. You can explicitly dereference variables by setting them to `null`. The Garbage collector gets its own thread. To manage memory:
- Minimize the number of objects you create.
- Use `Runtime.maxMemory()` and `Runtime.totalMemory()` to find out how much RAM is allocated/in use.

**STOP HERE.** I've placed awful placeholder programs past this point. This manual needs more work.

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
package com.rcf.example;

public class Printer {
    public static void log(String x){
        System.out.println(x);
    }
}
```

```java
package com.rcf.example;

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
package com.rcf.example;

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

## Java EE

**EE** stands for *Enterprise Edition*, whereas the OpenJDK and Java SE implementations are *Standard Edition*. The difference seems to be in the use case. Java SE is composed of the SE API, including all your favourite data structures, networking, security, database tools, and GUI kit. The EE edition *extends* SE by including an API and runtime environment for *"large-scale, multi-tiered, scalabe, reliable and secure network applications"*.[^ee]

EE docs can be found at [javaee.github.io](https://javaee.github.io/glassfish/documentation)

EE API docs at [javaee.github.io/javaee-spec](https://javaee.github.io/javaee-spec/javadocs/)

Installation help at [javaee.github.io/tutorial](https://javaee.github.io/tutorial/usingexamples001.html#GEXBC)

[^ee]: Oracle's [Java EE documentation.](https://docs.oracle.com/javaee/6/firstcup/doc/gkhoy.html)

Do note that IntelliJ IDEA's free version does **not** support Java EE development.

### Servlets

*What is a servlet?* A small program that responds to web requests - many of them may run simultanously to handle different types of requests within a web server.

### MicroServices

> Java EE is a maintainable industry standard, with most projects having no external dependencies and thin deployment artifacts.[^1]

[^1]: Mario-Leander Remier, *Building Web Services with Java EE 8* [LinkedIn Learning](https://www.linkedin.com/learning/building-web-services-with-java-ee-8).

```xml
<dependency>
  <groupId>javax</groupId>
  <artifactId>javaee-api</artifactId>
  <version>8.0</version>
  <scope>provided</scope>
</dependency>
```

This Maven dependency contains the Java EE 8 API, and can be packed into a thin WAR and thrown into a Docker container. The following APIs are common in microservices:

JSR 370 | JAX-RS | REST API library
JSR 367 | JSON-B | Convert JSON to/from Java objects 
JSR 374 | JSON-P | Java API for JSON Processing

### Containerizing with Docker

### RESTful Services with Jax-RX 2

*Representational State Transfer* utilizes a stateless communication protocol and web standards to present a standardized interface for applications to retrieve data. [WildFly](#wildfly-application-server) utilizes RESTEasy, an implementation of Jax-RX. The following interfaces should be programmed for data access:

- **GET** to retrieve
- **POST** to create
- **PUT** to update
- **DELETE** to remove

**Jax-RX** provides `@` methods for all of the above, and decorators to apply on Java Objects:

Decorator    | Usage
-------------|--------------------------------
`@Path`      | Defines a resource.
`@PathParam` | Parses URI path for parameters.
`@QueryParam`| Parses URI query for parameters.
`@Consumes`  | Specifies MIME type of input. `@Produces` for output.
`@Provider`  | Extends runtime using entity, context, or exception provider classes.
`@ApplicationPath` | Defines URI to redirect for processing.

### SOAP Services with Jax-WS

*Simple Object Access Protocol*

### WildFly Application Server

**WildFly** is an application runtime. While learning about Java EE, I found some excellent articles on utilizing version 13-Final, so this is what I've used as a base for most of my projects. To install, go to <http://wildfly.org/downloads/> and download the *Full/Web Distribution* package. Unzip this into your program files, and run the add-user script. After a user has been added, you will be able to execute the *standalone* script and see the *HAL* user console at <http://localhost:9990>

![HAL](/assets/JavaEE/WildFlyUI.PNG)

[Here](http://vytas.io/blog/java/Micro-Java-EE-application-with-Wildfly-Swarm/) is a good article on a small & practical microservice written with Wildfly Swarm.

## The Best Parts of Java 8

- [Lambdas](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html) (arrow functions) 
- [Streams](https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html) `java.util.stream`

```
->
::
```

## Maven

[Maven](https://maven.apache.org/what-is-maven.html) is a tool for building and managing Java projects. It plays very well with unit tests and CI systems like *Travis CI*. A good tutorial for beginners is available [here](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).

```bash
mvn package
```

## Handling XML

### The Dom4j Library

In production, my current internship uses objects and methods from <https://dom4j.github.io/> to load and process XML documents. For more information about XML and XPath, please refer to <{{site.url}}/xml>

### Loading XML From File

### Loading XML From URL

## SpringBoot

```
spring
```

## GUIs with JavaFX

See [hello_world](https://docs.oracle.com/javafx/2/get_started/hello_world.htm) and [get_started](https://docs.oracle.com/javafx/2/get_started/jfxpub-get_started.htm) guides. IDEs like *IntelliJ IDEA* and *Eclipse* have built-in systems for assembling JavaFX GUIs.

## Jargon

Word          | Plain English
--------------|---------------------------
POJO          | Plain old Java Object
Declare       | To initialize without a value, ex. `int a;`
Define        | Synonymous with Initialize.
Initialize    | To include data or fill a method body after declaration.
Instantiate   | To use a defined class to create an object.

## References
