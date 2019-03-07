# Programming in Rust

  [![Build Status](https://travis-ci.org/RyanFleck/Projects.svg?branch=master)](https://travis-ci.org/RyanFleck/Projects)  [![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

  View formatted manual: [ryanfleck.github.io/rust](https://ryanfleck.github.io/rust)
  

```rust
fn main() {
    println!("Hello, Rust!");
}
```

<br />


<br />

## Why I am Writing Programs in Rust

*Rust* seems to be a good way to build stable, multi-platform CLI apps, something I've had difficulty with using C.

The docs can be found at <https://doc.rust-lang.org/book/>

**Additional Resources**
1. [Blog post about writing games](http://iolivia.me/posts/24-hours-of-rust-game-dev/)
1. [Cloudflare post about building interpreters](https://blog.cloudflare.com/building-fast-interpreters-in-rust/)
1. [Blog post about writing CLI apps](https://mattgathu.github.io/writing-cli-app-rust/)

## Rust Basics

### Starting a Rust Project

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

### First Impressions

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

## **WASM**: Web Assembly

After reading an article on *developers.google.com* titled '[Replacing a hot path in your app's JavaScript with WebAssembly](https://developers.google.com/web/updates/2019/02/hotpath-with-wasm)', I decided to give [**wasm-pack**](https://rustwasm.github.io/wasm-pack/) a test drive. The aforementioned article gave excellent insight into when and why WASM should be used, so I decided to attempt to port some game logic into WASM... the possibilities!
