# Programming in Go 

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/go](https://ryanfleck.github.io/go)
  

[Hello World:](http://www.catb.org/jargon/html/H/hello-world.html)
```go
package main

import "fmt"

func main() {
  fmt.Println("Hello, World!")
}
```

<br />



<br />

## What is Go?

Go is a fast, compiled language with focus on multicore and networked programs.

## Why I am Writing Programs in Go 

I've done a ton of small, fun projects in NodeJS, and love the ease with which I can express small ideas. Unfortunately, I've grown out of Node, and am looking for something with better security and scalability. I'll be writing personal projects in **go** for the next few months. With Go 2 on the horizon, now seems like a reasonable time to begin learning.

<br />
## Setup

```sh
apt install golang
```

Add to `~/.profile`:
```sh
export GOPATH=$HOME/go
export PATH=$PATH:$GOROOT/bin:$GOPATH/bin
```


## The Basics

The first demo in *A Tour of Go* gives us insight into how go compiles, links and runs. It should be a lot faster to prototype in go than in **c**.

```go
package main

import (
  "fmt"
  "time"
)

func main() {
  fmt.Println("Welcome to the playground!")

  fmt.Println("The time is", time.Now())
}

```

1. The package of the program is `main`.
1. A function `import()` is used to bring in packages `fmt` and `math`.
1. The `main()` function (hm, no return type?) is executed when the program is run.
1. `fmt.Printf()` works similarly to **c**'s `printf`.

Interesting things to note:
1. functions are exported (public) if the name starts with a capital. For instance, `Parse()` will be available from outside our package, but `parse()` will be private.

## Compiling Executables for Linux, OSX, Win.

An article on [dave.cheney.net](https://dave.cheney.net/2015/08/22/cross-compilation-with-go-1-5) and a [stack overflow thread](got me up and running quickly with building my go applications.)
