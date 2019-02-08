/*-------------------------------------------------------------------
File: filter.c

Description:  Quick and dirty code. In particular, gets() is not a 
              good function to use since it can write past the end
              of the memory buffer it receives.
              This program is specific to processing output received
	      from the procmon program.
---------------------------------------------------------------------*/
#include <stdio.h>
#include <stdlib.h>

/* It's all done in main */
int main(int argc, char **argv)
{
    char    buffer[128], oldstate[32], state[32];
    int     i;

    state[0] = oldstate[0] = 0;
    /* Simply copy the first five lines */
    for(i=0; i<5; i++) 
    {
        if (gets(buffer)==NULL)
            exit(-1); /* procmon produces 5 header lines - fatal error */
        else puts(buffer);
    }

    while(gets(buffer)) 
    {
        sscanf(buffer, "%*s %s", state);
        if (strcmp(state, oldstate))  /* copy only if different from oldstate */
	{
            strcpy(oldstate, state);
            puts(buffer);
            fflush(stdout);
        }
    }
}
