#Java Tutorial

What follows is a guide to familiarize a beginner with the Java language.
  
###Why Use Java?

**Industry Hardened -** Java has many use cases in the enterprise.

**Industry Hardened -** Java has many use cases in the enterprise.

**Industry Hardened -** Java has many use cases in the enterprise.

**Industry Hardened -** Java has many use cases in the enterprise.

###Installing Java

GNU/Linux users can use their package manager to install the latest OpenJDK. MacOS and Windows users need to install binaries and follow guides from [Oracle](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

###Writing And Executing Your First Java Program

Using your text editor of choice, create hello.java:

```java
class hello{
  public static void main(String[] args){
    System.out.println("Hello World!");
  }
}
```
Once the above is written and saved, you can compile and run the code. Ensure that the name of the class matches the file name (sans .java extension) exactly. You can then compile the file by typing *javac hello.java* in your shell, followed by *java hello* to execute. The string *"Hello World!"* should be printed when the program is executed.

A simple breakdown of the above:
```java
class hello{  //This defines the CLASS.
  public static void main(String[] args){ //Our MAIN function.
    System.out.println("Hello World!"); //A simple PRINT statement.
  } //The end of MAIN.
} //The end of the CLASS.
```
Every Java program is written inside a class, so it can be used by other 

###Fundamental Data Types
Java uses integers, booleans and characters to store data. Variables are typed in Java to ensure the correct passage of data through the program. To initialize variables with these types:

```java
int aNumber;
boolean aBool;
char aChar;
```
Values can be assigned to these variables during or after their initialization:

```java
//Assign later:
int aNumber;
aNumber = 12;

//Assign at initialization:
boolean aBool = true;
```

###Integer Manipulation
Integers can use the following operators in Java: +, -, *, / and %. All of these operate by placing them between two integers. The modulo operation may be unfamiliar to a new programmer- it simply returns the remainder of a division operation. For example, 10 % 8 is equal to 2.

Integers can also use relational logic, namely >, <, ==, >=, <=, and !=. '>' is the greater than symbol, and can be paired with '=' to act as a 'greater or equal to' comparator.

###Control Flow
Simple control flow can be attained using **Conditionals** and **OTHER**

If/else example:
```java
if(booleanAnswer){
    //This runs if booleanAnswer = true
} else if(booleanAnswerTwo) {
    //This runs if booleanAnswer = false and booleanAnswerTwo = true
} else {
    //This runs if everything else is false
}
```

Switch example:
```java
//Guess between A or B!
switch (charAnswer) {
    case 'A': 
        System.out.println("Correct!");
        break;
    case 'B':
        System.out.println("Incorrect!");
        break;
    default:
        System.out.println("Invalid option.");
}

```


###Writing 'Clean Code'
Using whitespace and comments will make your programs easier to understand. Every company and book has a different standard, but these conventions set by Oracle are a safe bet:

```java
/*
 * Date, Name, Important stuff.
 * Copyright info
 * License (GPL, BSD, MIT, BeerWare...)
 */
 
package java.pkgname;
 
import java.dependsonthis;

/**
 *Class description.
 */

public class className{
    public static int classVariable;
    
    /**
     * Multi-line
     * documentation.
     */
     public static void main(String[] args) {
        if(something) {
            //then...
        }
     }
    
    /** Simple documentation comment */
    public void simpleMethod() {
        //simpleMethod implemenation goes here.
    }
}

```

###Jargon

####1. Initialized, Instantiated, Declared, Assigned:
Variables are **initialized**. The name of a variable is **declared** and a value is **assigned**. When a class is used, an instance is created, therefore the class is **instantiated**. 