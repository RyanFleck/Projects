/*
 * Modified number-guessing game from the Rust Manual:
 * doc.rust-lang.org/stable/book/2018-edition/ch02-00-guessing-game-tutorial.html
 */

// Rust automatically imports a standard lib module called 'prelude'.
use std::io;

fn main() {
    println!("Guess the number!\nPlease input a value between x and y:");

    // LET statements are used to create variables.
    // ! Variables are immutable by default. MUT makes it mutable.
    let mut guess = String::new(); // :: - Associated Function (static method)

    io::stdin()
        .read_line(&mut guess)
        .expect("Failed to read line");

    println!("Guess: {}", guess);
}
