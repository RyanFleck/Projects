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

On **Windows**, you'll need to find a C# compiler, like the one included in Visual Studio, and add the location of `csc` to your path. After csc has been added to the Windows PATH, `csc file.cs` can be run to compile your C# file, and `.\file.exe` will run it.

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
### Hello World
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

### Simple Functions
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

### Namespaces
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

### C# Syntax
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

### Types
```csharp
int x = 144/12;
string message = "Hello World!";
const int life = 42;
bool george = true;
```
*Types* define what kind of value is stored in a location. *Variables* can be changed, but a *constant* will always represent the same value. C# provides predefined int, string, and bool types.

*Custom Types* can be created from these simpler types.

### String Manipulation
