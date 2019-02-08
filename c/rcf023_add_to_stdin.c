#include <stdio.h>
#include <string.h>

static char input[2048];
static char c;

int main(int argc, char **argv)
{
    char * input_ptr;
    input_ptr = input;

    while (EOF != (c = fgetc(stdin))) {
        // printf("%c", c);
        *input_ptr++ = c;
        if( c == '\n' ){
            printf("LINE: %s",input);
            memset(input, 0, 2048);
            input_ptr = input;
        }
    }
    return 0;
}
