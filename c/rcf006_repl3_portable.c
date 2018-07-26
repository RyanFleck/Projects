/*
 *  rcf006_repl3_portable.c - Implements a basic REPL.
 *  New in Version 6: Preprocessing for Win32. 
 *  Copyright (C) 2018 Ryan Fleck under the GNU GPLv3.
 */

#include<stdio.h>
#include<stdlib.h>

//PREPROCESSOR COMMANDS for Windows portability!
#ifdef _WIN32
#include<string.h>

static char buffer[2048];

//Functions for just Win32
char* readline(char* prompt){
  fputs(prompt, stdout);
  fgets(buffer, 2040, stdin);
  char* cpy = malloc(strlen(buffer)+1);
  strcpy(cpy, buffer);
  cpy[strlen(cpy)-1]='\0';
  return cpy;
}

void add_history(char* unused){}

//Otherwise use the library's functions:
#else
#include<editline/readline.h>
#include<editline/history.h>
#endif

int main(int argc, char** argv){
  puts("Ryan's Micro LISP (RML) Version 0.0.0.3"); 
  puts("Press Ctrl+C to Exit\n");
  
  while(1) {
    char* input = readline("rml > ");
    add_history(input);
    printf("      %s\n", input); //Feedback.
    /* Operations with input go here.*/
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
 *  apt-get install libedit-dev
 *  apt-get install libreadline-dev
 */
