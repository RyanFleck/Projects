# Programming in C

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/c](https://ryanfleck.github.io/c)
  

```c
#include<stdio.h>

int main(void){
    printf("Hello, C!");
    return 0;
}
```

<br />


<br />

## Why use C?
C is the backbone of Unix systems. That's cool. Currently the only project I really have going in C is [RML](https://github.com/RyanFleck/RML). The Operating Systems course uses C to teach about processes and threading.

Farily certain I just bombed an interview for IBM, so there'll be a lot more added to this page in the coming weeks as I read *Cracking the Coding Interview*.

#### Resources
1. [The C Book](http://publications.gbdirect.co.uk/c_book/)
1. [C Elements of Style](http://www.oualline.com/books.free/style/index.html)
1. [GNU C Programming Tutorial](http://www.crasseux.com/books/ctut.pdf) and [Reference Manual](https://www.gnu.org/software/gnu-c-manual/)
1. [Build your Own Lisp](http://buildyourownlisp.com/)
1. [Writing Bug-Free C Code](https://www.duckware.com/bugfreec/index.html)
1. **K&R** C (Not a libre publication.)




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

C uses `char*`, a pointer to a list of characters with the final character being the *null terminator*.

`puts("string");` is sufficient for most string-output.

`printf("string %f", flt);` - printf is required for inserting data into strings. Data can be represented in a variety of ways with `%` notation.




## Pointers

C allows the manual storage and manipulation of memory addresses. Using the pointer (`*`) and address (`&`) operators, a programmer can create programs that minimize copying, with heavy emphasis on modifying arrays in the memory in-place. This lower, more complex level of control enables faster algorithms and interesting hacks.

```c
// A pointer is the same size as the type declared.
int y = 32;
int * yptr;
yptr = &y;

// Run:
y -> 32
*yptr -> 32
yptr -> A3BC3AF8
```




## Unix System Calls

### Fork

The `fork()` call can be used to split a running program into seperate processes. Calling `fork()` returns the PID of the child to the parent, and `0` to the child.

### Pipe

The `pipe()` call (which requires a `int pipeinfo[2];` to point to,) creates a pipe that can be used to forward date to and from child or executed processes.

### Exec

I've found the following very useful when I accidentally start a child process that I forget to kill:

```sh
ps -A | grep {name}
kill -9 {pid}
```

<!--
## Building Projects with Make

**GNU Make** is a
-->
