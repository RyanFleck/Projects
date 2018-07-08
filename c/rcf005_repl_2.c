/*
 *  rcf005_repl_2.c - Implements a basic read-evaluate-print loop.
 *  Copyright (C) 2018 Ryan Fleck under the GNU GPLv3.
 */

#include<stdio.h>
#include<stdlib.h>
#include<editline/readline.h>
#include<editline/history.h>

int main(int argc, char** argv){
  puts("Ryan's Micro LISP version 0.0.0.1"); 
  puts("Press Ctrl+C to Exit\n");
  
  while(1) {
    
    char* input = readline("rml > ");

    add_history(input);
    
    printf("No, you're a %s\n", input); //Feedback.

    free(input);
  }
  
  return 0;
}

/* 
 * Notes:
 * 
 * 
 * 
 * 
 * 
 */
