/*
 *  RCF012 - "Grep-Ish". Alternatively, "RGrep".
 *    Written while reading K&R Chapter 4, derived from the program written
 *    within the chapter. No license applies to this program.
 *
 *  Program Structure:
 *
 *    while( another line exists in text file ){
 *      if( the line contains the pattern ){
 *        print the line
 *      }
 *    }
 *
 */

#include <stdio.h>
#define MAXLINE 1000

int getline(char line[], int max);
int strindex(char source[], char searchfor[]);

// Search Pattern
char pattern[] = "ould";

int main()
{
    char line[MAXLINE];
    int  found = 0;


    return found;
}
