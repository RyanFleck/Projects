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
 *  Simple Run: 1. gcc *this                      -> compile.
 *              2. clear                          -> clear screen.
 *              3. cat tests/text.txt | ./a.out   -> pipe a file to stdin.
 *
 *    gcc rcf012_grep_ish.c && clear && cat tests/text.txt | ./a.out
 */

#include <stdio.h>
#define MAXLINE 1000

int r_getline(char line[]);
int r_strindex(char source[], char searchfor[]);

// Search Pattern
char pattern[] = "ould";

int main()
{
    char line[MAXLINE];
    int  found = 0;
    int  lineno = 0;

    while( r_getline(line) > 0 ) {
        printf("%i  %s", lineno, line);
        lineno++;
    }

    return found;
}

int r_getline(char line[])
{
    int c, i;
    int bound = MAXLINE - 1;

    // Alternatively, this can all be a one-liner: fgets(line, MAXLINE, stdin);

    for( i=0; i < bound && (c=getchar())!=EOF && c!='\n'; i++) {
        line[i] = c;
    }

    if( c == '\n' ) {
        line[i] = c;
        i++;
    }

    line[i] = '\0';

    return i;
}

int r_strindex(char source[], char searchfor[])
{


}
