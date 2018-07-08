/*
 *  rcf004_repl.c - Implements a basic read-evaluate-print loop.
 *  Copyright (C) 2018 Ryan Fleck under the GNU GPLv3.
 */

#include<stdio.h>

static char input[2048]; //Buffer for user input.

int main(int argc, char** argv){
  puts("Ryan's Micro LISP version 0.0.0.1"); 
  puts("Press Ctrl+C to Exit\n");
  
  while(1) {
    fputs("rml > ", stdout); //Input prompt. 
    fgets(input, 2048, stdin); //Read user input.
    printf("No, you're a %s", input); //Feedback.
  }
  
  return 0;
}

/* 
 * Notes:
 * 
 * fputs is puts without a newline.
 * stdin and stdout are defined in <stdio.h>, standard input and output. 
 * 
 * fputs("rml > ", stdout);
 *  first, prints "rml > " without a newline.
 *  not sure why stdout is specified; further investigation needed. 
 * 
 * fgets(input, 2048, stdin); 
 *  input is our input buffer
 *  2048 is the max size
 *  written to stdin, standard input.
 * 
 */
