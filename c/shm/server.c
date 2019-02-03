#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <unistd.h>

#define SHMSZ   27

int main(){
    printf("Server started.\n");

    char c;
    int shmid;
    key_t key;
    char *shm, *s;
    
    key = 5678;

    if( (shmid = shmget(key, SHMSZ, IPC_CREAT | 0666)) < 0 ){
        perror("shmget");
        exit(1); 
    }else{
        puts("shm-get - passed.");
    }
    
    if( (shm = shmat(shmid, NULL, 0)) == (char *) -1 ){
        perror("shmat");
        exit(1); 
    }else{
        puts("shm-at - passed.");
    }

    s = shm;

    for( c='a'; c <= 'z'; c++ ){
        printf("*s: %i s: %c --> %c (%i)\n",*s,s[(int)c],c, (int)c);
        *s++ = c;
    }

    while( *shm != '*'){
        sleep(1);
    }

    exit(0);
}
