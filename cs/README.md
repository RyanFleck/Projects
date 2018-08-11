# Ryan's C# Manual
[![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)
[Link to pretty manual](https://ryanfleck.github.io/cs)

I've always had strong feelings against the anti-competetive Microsoft, and the products it produces. Yesterday's Github aquisition will probably end in the same way the aquisitions of Nokia, Rare, LinkedIn, Mojang and Xamarin did; with stagnation, a halt in new and interesting innovations, and no new fantastic products.

This being said, I am beginning to work with Sitecore at work, a web content management system built with Microsoft's .NET system. Working with a large, technical system is excellent experience, and to do this competently I feel it is in my best interest to invest some time in C#.

[Hello World:](http://www.catb.org/jargon/html/H/hello-world.html)
```csharp
using System;

class Hello
{
  static void Main()
  {
    Console.WriteLine("Hello, World!");
  }
}
```



## Why C#?

Pronounced "C Sharp" and also known as *Microsoft's Java,* C# is a general-purpose language primarily used for developing Windows applications. C# is also used by the Unity game engine, the ASP.NET framework (which is used by many of the highest-traffic websites,) and should remain relevant for years to come. I am personally learning C# for development on the *Sitecore®* platform.

## Setup

On **GNU/Linux**, you'll need to install the mono tools. Mono is a libre implementation of Microsoft's C#. To compile and run C# code, install the `mono-devel` package on your distro of choice. After installation, you'll be able to invoke `csc file.cs` to compile your C# file, and `mono file.exe` to run it.

On **Windows**, you'll need to find a C# compiler, like the one included in Visual Studio or ["Roslyn", the MS open-source C# compiler](https://github.com/dotnet/roslyn), and add the location of `csc` to your path. After csc has been added to the Windows PATH, `csc file.cs` can be run to compile your C# file, and `.\file.exe` will run it.

**GNU/Linux compile+run script cs.sh:**
```sh
if [ -z $1 ]; then
  echo "Please include a .cs file as the first argument."
else
  y="${1%.cs}"
  mcs -out:prog.exe $y.cs
  echo "Compiled $y.cs to prog.exe, running..."
  mono prog.exe
fi
```

**Windows compile+run script cs.bat:**
```bat
@ECHO OFF
ECHO **************************************************
ECHO **        FOR WIN10x64: C# Compile N' Run       **
ECHO **************************************************
ECHO Using %1

csc /out:prog.exe %1
.\prog.exe
```

Both of these scripts take one argument, a .cs program, then proceed to compile it using `csc` and run it. Having scripts to do little repetitive things like this saves a lot of time and is highly recommended.

**A C# source file can be compiled into the following "assemblies":**
- An *application* with a `.exe` extension, contains the *Main* method.
- A *library* with a `.dll` extension, like an *.exe* without an entry point.

## C# Basics
### Hello World <!--Page 9-->
```csharp
using System;

class Test
{
  static void Main()
  {
    int x = 12 * 30; //Integer X, local variable.
    Console.WriteLine(x); //Print x to the cli.
  }
}
```

### Simple Functions <!--Page 10-->
```csharp
using System;

class Program
{
  static void Main() // Default entry point of execution.
  {
    Console.WriteLine("30 feet to inches: "+ FeetToInches(30));
    Console.WriteLine("13 feet to inches: "+ FeetToInches(13));
    Console.WriteLine("44 feet to inches: "+ FeetToInches(44));
  }

  static int FeetToInches(int feet)
  {
    int inches = feet * 12;
    return inches;
  }
}
```

### Namespaces <!--Page 11-->
```csharp
using System;

namespace RCF_NSP01
{
  class RCF_CLS01
  { ... }

  class RCF_CLS02
  { ... }
}
```
More complex class/namespace calling.
```csharp
using System;

namespace RCF_NSP01
{
  class RCF_CLS01
  // Classes can be loaded separately by other programs!
  // Ex. `using Namespace.Class;`
  {
    static void Main() // Only a single class can have the entry point.
    {
      Console.WriteLine("RCF003 - Namespaces.\n");
      Console.WriteLine("Class one loaded!");
	  Console.WriteLine( "16 -> " + Double(8) );
	  Console.WriteLine( "4  -> " + RCF_NSP01.RCF_CLS02.DivideByTwo(8) );
	  Console.WriteLine( "7  -> " + RCF_NSP01.RCF_CLS03.DivideByThree(21) );
    }
    static int Double(int x)
    {
      return x*2;
    }
  }
  class RCF_CLS02
  {
    public static int DivideByTwo(int x)
    {
      return x/2;
    }
  }
  class RCF_CLS03
  {
    public static int DivideByThree(int x)
    {
      return x/3;
    }
  }
}
```

### C# Syntax <!--Page 12-->
```csharp
using System;

class Program
{
  static void Main()
  {
    int a = 123/4;
    Console.WriteLine(a);
  }
}
```
- **Identifiers** are used to define classes, methods and variables.
- **Keywords** like `static` or `int` are reserved by the compiler.
- To legally use a keyword as an identifier, prepend an `@`. Ex. `class @class {}`
- **Literals** are primitive peices of data, characters and numbers.
- **Punctuators** give the program structure, ex. `{  }  ;`
- **Operators** apply mathematical functions to data, ex. `. () * = /`
- **Comments** can be made `// like this ` or `/* like this. */`

### Types  <!--Page 15-->
```csharp
int x = 144/12;
string message = "Hello World!";
const int life = 42;
bool george = true;
```
*Types* define what kind of value is stored in a location. *Variables* can be changed, but a *constant* will always represent the same value. C# provides predefined int, string, and bool types. Types are categorized like so:
* **Value types** include most built-in types. Composed of a stored value. Copied value types have independant storage.
* **Reference types** include all class, array, interface and strings types. Composed of a **reference** that points to an object holding the values. Copied reference types point to the same object. Can be assigned to null, where value-types will not (and throw a compile-time error.)
* **Generic type parameters** [^2]
* **Pointer types** [^3]



### Custom Types <!--Page 17-->

*Custom Types* can be created from simpler types.

```csharp
using System;

namespace TypeTest
{
	class Program
	{
	  static void Main()
	  {
		Multiplier m1 = new Multiplier (3);
		Console.WriteLine( m1.Apply(3) ); // Prints 9

		Multiplier m2 = new Multiplier (99);
		Console.WriteLine( m2.Apply(1) ); // Prints 99
	  }
	}

	public class Multiplier
	{
		// Data members:
		int factor; // Field

		// Function members:

		// Constructor
		public Multiplier ( int input ) { factor = input; }

		// Method
		public int Apply ( int input ) { return input * factor; }
	}

}
```
Data is made availabe to a program when it is *instantiated*. Built-in types can be instantiated by using a literal ( true , 18 ). Custom types use the *new* operator, which passes arguments to the constructor.

```csharp
Kraken Steve = new Kraken("Steve Jones");
```

> Data members and function members that don’t operate on the instance of the type, but rather on the type itself, must be marked as static.[^1]

Therefore, *static data members are shared among all instances of a custom type*. This is demonstrated below:

**StaticTests** custom type.
```csharp
public class StaticTests
	{
		public static int isStatic;
		public int notStatic;

		// 'public' keyword exposes method to other classes.
		public StaticTests ()
		{
			isStatic++;
			notStatic++;
			Console.WriteLine("Static: "+isStatic);
			Console.WriteLine("Not static: "+notStatic);
		}
	}
```

**Main**, each instantiation adds 1 to both *isStatic* and *notStatic*.
```csharp
StaticTests a = new StaticTests();
StaticTests b = new StaticTests();
StaticTests c = new StaticTests();
StaticTests d = new StaticTests();
StaticTests e = new StaticTests();
// At this point, isstatic == 5.
// Not static for each instance is 1.
```
### Conversions and Casting <!--Page 18-->
- *Implicit* conversions are guaranteed by the compiler to succeed, and all data will be retained. Implicit conversions happen automatically.
- *Explicit* conversions may fail, and data may be lost. Explicit conversions require *casting*

```csharp
int a = 134; //An integer (32 bits.)
long b = a; //Conversion (64 bits.)
short c = (short)a; //Cast (16 bits.) Possible data loss.
```

### Number Types <!--Page 23-->
Whoa! Conversions, overflow and many types... oh my! While this is great, I'm skipping it for now because it looks familiar to the way it's implemented in *Java*. This example is interesting, though:
```csharp
//From "C# 5.0 in a Nutshell" Page 26.
int x = 0, y = 0;
Console.WriteLine (x++); // Outputs 0; x is now 1
Console.WriteLine (++y); // Outputs 1; y is now 1
```
### Boolean Types
Booleans in C# can be evaluated with the usual comparators, equal `==` and not equal `!=`, along with and `&&`, or `||` and brackets `(  )`. Using single `&` or `|` operators will cause all items to be evaluated instead of *"short-circuiting"* and breaking as soon as the evaluation can only be true.

C# also has a ternary operator that takes three inputs: A boolean statement, the action for true, and the action for false:
```csharp
return (a > b) ? a : b;
```

### String Types <!--Page 32-->


<!--Table
|a|b|c|
|----|
|c|d|e|
|c|d|f|
|a|b|c|
|c|d|e|
|c|d|f|
-->

### Arrays  <!--Page 35-->
An array is a container for variables, and can hold an explicit number of values of a given type. Simple arrays are initialized like `type[] array = new type[length];`. For example, an array of 12 characters would be instantiated as `char[] arr = new char[12];`. (As per CompSci norms, an array with 12 characters will be addressable as indices zero through eleven, for a total of 12 indices.) Simple creation and reading of an array is shown below:

```csharp
using System;

class Program
{
  static void Main()
  {
    Console.WriteLine("RCF007 - Arrays\n");

	//Simple declaration:
	int[] letters = new int[5];

	//Iterate through and assign values, .length returns length.
	for(int i=0; i < letters.Length; i++)
	{
	  letters[i] = 10-i;
	}

	//Print values
	for(int i=0; i<letters.Length; i++)
	{
	  Console.WriteLine("letters["+i+"] = "+letters[i]);
	}

	PrintArray(new int[] {1, 2, 3, 234, 32, 2, 1});
  }


  static void PrintArray (int[] array)
  {
	Console.WriteLine("Contents of Array:");  
	for(int i=0; i<array.Length; i++)
	{
	  Console.WriteLine("array["+i+"] = "+array[i]);
	}
  }

}
```
An array will always be initialized with the default values for the structure in question. If the array is filled with a type, it will be filled with the default values for that type.
```csharp
int[] x = new int[] {1, 2, 3, 234, 32, 2, 1};
```

It is possible to initialize and populate an array in one line:
```cs
int[] x = new int[] {1, 2, 3, 234, 32, 2, 1};
```

**Square Arrays**
```cs
//Simple declaration:
int[] Letters = new int[5];

//SQUARE arrays:
//Declare a matrix:
int[,] Matrix = new int[3,3];

//Declare and fill a matrix:
int[,] MatrixTwo = new int[,]
{
  {0,1,2},
  {3,4,5},
  {6,7,8}
};
```

**Jagged Arrays**
```cs
//Jagged array with outermost dimension 3:
int[][] JaggedOne = new int[3][];
//(Internal arrays are null.)

//Jagged array with alternate instantiation:
int[][] JaggedTwo = new int[][]
{
  new int[]{1,2,3},
  new int[]{4,5,6,7,8},
  new int[]{9,10,11}
};

//Initialize internal arrays:
for (int x=0; x<JaggedOne.Length; x++)
{
  JaggedOne[x] = new int[3];
  for (int y=0; y<JaggedOne[x].Length; y++)
  {
    JaggedOne[x][y]= x*3+y;
  }
}
```

### Variables and Parameters <!--Page 38-->
**C#** enforces *definite assignment*, where it is impossible to access memory that has not been initialized by the running program. Calling an unassigned variable will usually result in a *compile-time error* unless the assignment method infers a *default value*.

- A **stack** is a block of memory for storing variables and parameters.
- A **heap** is a block of memory for storing objects. 

Both of these structures have garbage collection active, freeing memory by deallocating any variables, parameters or objects that are no longer referenced by *living code*.

Type | Default Value 
-----|--------------
Reference types | null
Numeric types | 0
CHARs | '\0'
BOOLs | false

To pass by reference, `ref` can be used in a function definition (`static void Foo(ref int x)`) instead of the default which copies. This is essential for some methods that must alter the input data.
```cs
//From Page 43 of C# In a Nutshell:
class Test
{
  static void Swap (ref string a, ref string b)
  {
    string temp = a;
    a = b;
    b = temp;
  }
  static void Main()
  {
    string x = "Penn";
    string y = "Teller";
    Swap (ref x, ref y);
    Console.WriteLine (x); // Teller
    Console.WriteLine (y); // Penn
  }
}
```

**Note to self:** return to this section to review the other methods to pass by reference, out and params.

### Statements <!--Page 51-->

**Varibles** are *delcared*, and the scope extends within the encapsulating block.

C# is able to initialize variables if the compiler is able to infer the type by the initialization expression:
```cs
var x = "String"; //String
var y = new System.Text.StringBuilder(); //System.Text.StringBuilder
var z = 1.21; //float
```

**Expressions** can be of a few forms:

Assignment | `x = 2 + 2;`
Increment | `x++;`
Assignment | `x = Math.Max(a,b,c);`
Method Call | `Console.Writeline(y);`
Assignment | `var sb = new Klaxon();`
Object Instantiation | `new Klaxon();`

**Selection** statements, or **control flow**, include if, else, and switch.

**if else** 

```cs
if ( boolean )
{
  Console.WriteLine("Boolean was true.");
} else if ( anotherBoolean ) {
  Console.WriteLine("Another boolean was false.");
} else {
  Console.WriteLine("Both booleans were false.");
}
```

**switch** 
```cs
switch ( number )
{
  case 1:
    Console.WriteLine("Option I");
    break;
  case 2:
  case 3:
  case 4:
    Console.WriteLine("Option II-IV");
    break;
  case 5:
    Console.WriteLine("Option V");
    break;
  default:
    Console.WriteLine("Out of bounds option.");
    break;
}
```

**Iteration** statements include while, do-while, for, and foreach.

**while** `while ( boolean )`
```cs
while ( x < 1000 )
{
  Console.WriteLine(x);
  x++;
}
```

**do-while** tests the expression after execution.
```cs
do
{
  Console.WriteLine(x);
  x++;
}
while ( x < 1000 );
```

**for** has clauses: `for ( initialization ; condition ; iteration )`
```cs
for ( int x=0, y=1000; x < y; x++ )
{
  Console.WriteLine( x + ", " + y );
}
```
...any of the clauses can be omitted. `for (;;)` is valid as an infinite loop.


**foreach** iterates over enumerable lists of elements.
```cs
for ( char c in "chopsticks" ) 
{
  Console.WriteLine( c );
}
```

**Jump** statements include break, continue, goto, return and throw.

**break** ends the execution of an iteration or switch.
```cs
while ( true )
{
  if ( x > y )
    break;
}
```

**continue** moves to the next iteration of a loop.
```cs
for ( int x=0, y=1000; x < y; x++ )
{
  if ( ( x%2 ) == 0 )
    continue; //Skips printing for even numbers.

  Console.WriteLine( x + ", " + y );
}
```

**goto** moves execution to a statement-label.
```cs
int x = 4;
labelA:
if( x < 10)
{
  x++;
  goto labelA;
}
```

**return** exits the method and returns a method corresponding to the method's return type.
```cs
return true;
```

**throw** is used to indicate errors.
```cs
if ( x == null )
  throw new ArgumentNullException();
```

### Addressing Types in Namespaces <!--Page 59-->

`namespace` defines the namespace for types within a block.
```cs
namespace Outer.Middle.Inner
{
  class A {}
  class B {} //Outer.Middle.Inner.B
}
```
Class `B` has a *fully qualified name* of `Outer.Middle.Inner.B`


`using` imports a namespace. Importing the `Outer.Middle.Inner` shown above allows for the use of the `A` and `B` type without using the *fully qualified name*.
```cs
using Outer.Middle.Inner;

A objA = new A();
B objB;
```

**Namespace rules:**
1. Type names can be re-used within a namespace, but not at the same level.
2. Names declared in the outer namespaces can be used unconditionally in inner namespace.
3. Namespace declaraions can exist in multiple files.
4. To import a single type or partial namespace, use an alias:

```cs
using RLogger = System.Custom.Logs.RLogger;
```

### Creating Types <!--Page 67-->

**Definitions:**
- **Class** - The most common reference type.
- **Field** - A variable member of a class or struct. 
- **Method** - Executes a series of statements. 
- **x** - a 
- **x** - a 
- **x** - a 
- **x** - a 

Fields allow the following *field modifiers*:

`static` | Static something
`public` | Allows external method access.
`internal` | 
`private` |
`protected` | 
`new` |
`unsafe` |
`readonly` | Prevents modification after construction. 
`volatile` | 

See this [MS doc on Access Modifiers](https://docs.microsoft.com/en-us/dotnet/csharp/language-reference/keywords/access-modifiers) for more information.


<!-- End of C# core language manual. -->

## Monodevelop

When first installing *monodevelop*, it was very unstable. I ran it from the command line to see any errors, and sure enough:

```
Error in `monodevelop': free(): invalid pointer: 0x00007f629c001a80
======= Backtrace: =========
/lib/x86_64-linux-gnu/libc.so.6(+0x70bfb)[0x7f630072cbfb]
/lib/x86_64-linux-gnu/libc.so.6(+0x76fc6)[0x7f6300732fc6]
```
Running `apt-get build-dep monodevelop` fixed all of my stability problems. 

<br />

## References
Many are from "C# 5.0 in a Nutshell" 5e. J. and B. Albahari, O'Reilly 2012.

[^1]: "C# 5.0 in a Nutshell" 5e. **Page 17.** Type Basics.
[^2]: "C# 5.0 in a Nutshell" 5e. **Page 106.** Generics.
[^3]: "C# 5.0 in a Nutshell" 5e. **Page 177.** Unsafe Code and Pointers.

