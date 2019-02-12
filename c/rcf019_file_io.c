/*
 *  file_io.c - Simple file I/O learing program.
 *  Copyright (C) 2019 Ryan Fleck under the GNU GPLv3.
 */

#include<stdio.h>
#include<stdlib.h>

int readToStdOut(FILE *fp);
int writeToFile(FILE *fp, char *s);


int main(int argc, char **argv)
{
    FILE * fp;
    char testfile[] = "data/test.txt";

    // Reading files.
    fp = fopen(testfile, "r");
    if( fp == NULL ) {
        perror("Could not open test file for reading.");
        exit(1);
    }

    char x;
    printf("Reading from %s:\n", testfile);
    while( (x = fgetc(fp)) != EOF ) {
        printf("%c",x);
    }

    fclose(fp);

    // Writing files.
    fp = fopen(testfile, "w");
    if( fp == NULL ) {
        perror("Could not open test file for writing.");
        exit(1);
    }

    fprintf(fp, "Contents of test file replaced.\n");

    fclose(fp);

    // Appending content to files.
    fp = fopen(testfile, "a");
    if( fp == NULL ) {
        perror("Could not open test file for writing.");
        exit(1);
    }

    fprintf(fp, "Contents of test file appended.\n");
    fprintf(fp, "Great!\n");

    fclose(fp);

    return 0;
}




int readToStdOut(FILE *fp)
{
    fp = fopen("data/test.txt", "r");
    if( fp == NULL ) {
        perror("Could not open test file for reading.");
        exit(1);
    }

    char x;
    while( (x = fgetc(fp)) != EOF ) {
        printf("%c",x);
    }

    fclose(fp);
    return 0;
}

int writeToFile(FILE *fp, char *s)
{
    fp = fopen("data/test.txt", "w");
    if( fp == NULL ) {
        perror("Could not open test file for writing.");
        exit(1);
    }

    fprintf(fp, s);

    fclose(fp);
    return 0;
}

