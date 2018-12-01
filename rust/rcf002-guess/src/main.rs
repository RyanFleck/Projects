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
    let mut guess = String::new(); // :: - Associated Function (static method)

    let secret = rand::thread_rng().gen_range(1, 101);
    println!("Secret is {}", secret);

    println!("Guess the number!");
    println!("Please input a value between {} and {}:", 1, 10);
    io::stdin()
        .read_line(&mut guess)
        // .expect("err msg") is a method of io::Result for handling failure.
        // io::Result is an enum, and can return Err or Ok.
        // The 'right way' to handle this is to implement error handling.
        .expect("Failed to read line");

    // Convert guess to an unsigned 32-bit number:
    let guess: u32 = guess.trim().parse().expect("Please type a number!");

    println!("Guess: {}", guess);

    match guess.cmp(&secret) {
        Ordering::Less => println!("Too small!"),
        Ordering::Greater => println!("Too big!"),
        Ordering::Equal => println!("You win!"),
    }
}
