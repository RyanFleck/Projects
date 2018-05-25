# Ryan's C# Manual


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
|--|
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
```csharp
int[] x = new int[] {1, 2, 3, 234, 32, 2, 1};
```



## References
Many are from "C# 5.0 in a Nutshell" 5e. J. and B. Albahari, O'Reilly 2012.

[^1]: "C# 5.0 in a Nutshell" 5e. **Page 17.** Type Basics.
[^2]: "C# 5.0 in a Nutshell" 5e. **Page 106.** Generics.
[^3]: "C# 5.0 in a Nutshell" 5e. **Page 177.** Unsafe Code and Pointers.