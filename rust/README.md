# Programming in Rust

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/rust](https://ryanfleck.github.io/rust)
  

[Hello World:](http://www.catb.org/jargon/html/H/hello-world.html)
```rust
fn main() {
    println!("Hello, world!");
}
```

<br />


<br />

## Why I am Writing Programs in Rust

*Rust* seems to be a good way to build stable, multi-platform CLI apps, something I've had difficulty with using C.

The docs can be found at <https://doc.rust-lang.org/book/>

## Starting a Rust Project

First, generate a project using `cargo`:

```bash
cargo new project-name
```

Dependencies are managed directly in `Cargo.toml`. For instance:
```toml
[dependencies]
package-name = "0.X"
```

Running `cargo build` will install the dependencies.

`cargo run` will build, then run the project.

## First Impressions

As I was sitting at my desktop, I started developing using Visual Studio Code with the Rust extension, which is pleasant enough. Installation took a while, as I had to open/update my dusty Visual Studio instance to install some C++ tools. I'm sure this process would be faster with GNU.

Pointers are a little different than C, with Rust replacing `&var` with `&mut var` for mutable variables. References, like most other things, are immutable by default. Nice.

**Woo, killer feature:** `cargo doc --open` will build the docs for *all of your project's dependencies* and open it in your browser! Useful.

**???** What is this?

```rust
extern crate rand;

use std::io;
use std::cmp::Ordering;
use rand::Rng;

fn main() {
    // ---snip---

    println!("You guessed: {}", guess);

    match guess.cmp(&secret_number) {
        Ordering::Less => println!("Too small!"),
        Ordering::Greater => println!("Too big!"),
        Ordering::Equal => println!("You win!"),
    }
}
```

Took me a hot minute to wrap my head around this, I've never seen anything like `match` before, but it's essentially a fancy switch where you can set responses for enumerable variants. Neat.