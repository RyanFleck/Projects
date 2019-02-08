#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define BLOCK 2048
#define SCHAR sizeof(char)

// RCF023 only processes after STDIN ends. Not what I want.
// Goal: Stream from STDIN to STDOUT with minimal delay.
// ...still couldn't do what I wanted. Will return later.

int main(int argc, char **argv)
{
    char buf[BLOCK];
    while (!feof(stdin)) {
        size_t bytes = fread(buf, SCHAR, BLOCK,  stdin);
        fwrite(buf, SCHAR, bytes, stdout);
        fflush(stdout);
    }
    return 0;
}
