/*
 * Modified number-guessing game from the Rust Manual:
 * doc.rust-lang.org/stable/book/2018-edition/ch02-00-guessing-game-tutorial.html
 */

// Rust automatically imports a standard lib module called 'prelude'.
use std::cmp::Ordering;
use std::io;

// Crates (modules) can be imported from crates.io
extern crate rand;
use rand::Rng;

fn main() {
    // LET statements are used to create variables.
    // ! Variables are immutable by default. MUT makes it mutable.
    //let mut guess = String::new(); // :: - Associated Function (static method)

    let secret = rand::thread_rng().gen_range(1, 10);
    //println!("Secret is {}", secret);
    println!("Guess the number!");

    loop {
        let mut guess = String::new();
        println!("Please input a value between {} and {}:", 1, 10);
        io::stdin()
            .read_line(&mut guess)
            // .expect("err msg") is a method of io::Result for handling failure.
            // io::Result is an enum, and can return Err or Ok.
            // The 'right way' to handle this is to implement error handling.
            .expect("Failed to read line");

        // Convert guess to an unsigned 32-bit number:
        // Previously .expect("Please type a number!");
        let guess: u32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => continue, // _ is a catchall value.
        };
        // WOW. Good/easy error handling.

        println!("Guess: {}", guess);

        match guess.cmp(&secret) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("You win!");
                break;
            }
        }
    }
}

/*
 * Up next: (Excerpt from docs.)
 * Chapter 3 covers concepts that most programming languages have,
 * such as variables, data types, and functions, and shows how to
 * use them in Rust. Chapter 4 explores ownership, a feature that
 * makes Rust different from other languages. Chapter 5 discusses
 * structs and method syntax, and Chapter 6 explains how enums work.
 */
