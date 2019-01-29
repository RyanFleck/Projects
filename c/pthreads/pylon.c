#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/fcntl.h>
#include <sys/types.h>
#include <unistd.h>
#include <ctype.h>

#include <pthread.h>

static char input[2048];

int main()
{
    printf("Ship REPL. PID-%d. Press CTRL+C to exit.\n", getpid());
    while(1){
        fputs(" >  ", stdout);
        fgets(input, 2048, stdin);
        printf(" => %s", input);
        switch(tolower(input[0])){
            case 'a':
                puts("Oh!");
                break;
            case 'c':
                puts("Creating thread...");
                break;
        }
    }
    return 0;
}
