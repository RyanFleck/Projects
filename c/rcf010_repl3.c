#include <stdio.h>

static char input[2048];

int main(int argc, char **argv)
{
    puts("TestREPL v1. Depress CTRL+C to exit.");
    while (1) {
        fputs("\n >  ", stdout);
        fgets(input, 2048, stdin);
        printf(" => %c", input[0]);
    }
    return 0;
}
