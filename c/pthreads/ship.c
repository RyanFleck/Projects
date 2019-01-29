#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/fcntl.h>
#include <sys/types.h>
#include <unistd.h>

static char input[2048];

int main()
{
    printf("Ship REPL. PID-%d. Press CTRL+C to exit.\n", getpid());
    while(1){
        fputs(" >  ", stdout);
        fgets(input, 2048, stdin);
        printf(" => %s", input);
    }
    return 0;
}
