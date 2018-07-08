/*
 *  rcf005_repl_2.c - Implements a basic read-evaluate-print loop.
 *  Copyright (C) 2018 Ryan Fleck under the GNU GPLv3.
 */

#include<stdio.h>
#include<stdlib.h>
#include<editline/readline.h>
#include<editline/history.h>

int main(int argc, char** argv){
  puts("Ryan's Micro LISP (RML) Version 0.0.0.2"); 
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
 * Must be compiled with the correct libraries linked: 
 * cc -std=c99 -Wall $x -L/usr/local/lib -I/usr/local/include -lreadline
 * 
 * After further experimentation, all you need is -ledit flag.
 * 
 * 
 */
