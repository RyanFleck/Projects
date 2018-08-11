# Ryan's C Manual
[![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)
[Link to pretty manual](https://ryanfleck.github.io/c)

[Hello World:](http://www.catb.org/jargon/html/H/hello-world.html)
```c
#include<stdio.h>

int main(void){
  printf("Hello, World.");
	return 0;
}
```



## Venerable, Glorious C

Something about how C is the lowlevel backbone of modern computing.

## Installation

To run C programs, it is best not to use an IDE. To get a feel for how things fit together, it is best to use the following tools:

Tool | GNU/Linux | Windows | MacOS
-----|-----------|---------|------
Text Editor | Gedit, Vim | Notepad++ | TextWrangler
Compiler | gcc | MinGW cc | xcode cc

A *debugger* like **GDB** is also recommended.

## Hello, World

[Hello World](http://www.catb.org/jargon/html/H/hello-world.html) is an excellent first example to demonstrate some key properties of C programs:

```c
#include<stdio.h>

int main(int argc, char** argv){
  puts("Hello, World.");
	return 0;
}
```

**Headers** allow the use of functions from libraries.
```c
#include<stdio.h>
```

The **main** function must be present in every .c file, and is the point where the program will begin to run.
```c
int main(int argc, char** argv){
```

**Puts** is short for *put string*
```c
puts("Hello, World.");
```
**Return 0** indicates that no errors have occured, and that the program is finished running.
```c
return 0;
}
```

## Strings and Printing

C uses `char*`, a pointer to a list of characters with the final character being the *null terminator*. 

`puts("string");` is sufficient for most string-output.

`printf("string %f", flt);` - printf is required for inserting data into strings. Data can be represented in a variety of ways with `%` notation.
