/*--------------------------------------------------------------------------
File: procmon.c

Description: This program provides similar functions to the shell scripts
             tstcalc and tstcp.  It starts a process, monitors it, and
	     terminates the process after 20 seconds.
--------------------------------------------------------------------------*/
#include <stdio.h>
#include <stdlib.h>

#define BUFFSIZE 50
#define OK 0
#define ERR1 -1

typedef struct dStruct {
    char        *state;
    long int    sysTime;
    long int    userTime;
} DataStruct;

/*--------------------------------------------------------------------------
Function: main
Description: The main function processes command line arguments and invokes
             appropriate functions to read in data from kernel and write
             to the standard output the information collected. This should
             be a relatively simple function.
--------------------------------------------------------------------------*/
int main(int argc, char **argv)
{
    DataStruct  data;
    char        statFile[BUFFSIZE];
    int         t;

    if (argc != 2) 
    {
        printf("Usage: procmon PID\n where PID is a process ID of a running process.\n");
        exit(-1);
    }
    sprintf(statFile, "/proc/%s/stat", argv[1]);

    printf("\n\n        Monitoring %s:\n\n", statFile);
    printf("Time        State           SysTm    UsrTm\n");
    for(t=0; ;t++) 
    {
        if (getData(statFile, &data) == ERR1)
            exit(0);
        else
            printf("%3d     %s %6ld %8ld\n", t, data.state, data.sysTime, data.userTime);
	fflush(stdout);
        sleep(1);
    }
}

/*--------------------------------------------------------------------------
Function: getData
Description:  This function reads the process state, its used system time 
              and used user time from the specified statFile and fills the 
	      specified data structure. If the file cannot be read (i.e. the 
	      monitored process no longer exists, reurns NULL pointer, 
	      otherwise returns pointer to the procided data structure.
--------------------------------------------------------------------------*/
int getData(char *statFile, DataStruct *data) 
{
    FILE *fp;
    char state;

    fp = fopen(statFile, "r");
    if (!fp) 
    {
        printf("procmon: Cannot open %s, the monitored process is not running any more.\n", 
	       statFile);
        return ERR1;
    }
    fscanf(fp, "%*s %*s %c %*s %*s %*s %*s %*s %*s %*s %*s %*s %*s %ld %ld",
        &state, &(data->userTime), &(data->sysTime));

    switch(state) 
    {
        case 'R': data->state = "Running          "; break;
        case 'S': data->state = "Sleeping(memory) "; break;
        case 'D': data->state = "Sleeping(disk)   "; break;
        case 'Z': data->state = "Zombie           "; break;
        case 'T': data->state = "Traced/Stopped   "; break;
        case 'W': data->state = "Paging           "; break;
    }
    fclose(fp);
    return OK;
}
