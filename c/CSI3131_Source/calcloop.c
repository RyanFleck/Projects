/*--------------------------------------------------------------------------
File: calcloop.c

Description:  This program runs 10 iterations of a loop that
		1) sleeps for 3 seconds
		2) increments a variable 400,000,000 times
--------------------------------------------------------------------------*/

#include <stdio.h>

int main()
{
   int i;
   int k;
   long x; 

   for(k=0 ; k < 10 ; k++) /* loop only 10 time */
   {
      sleep(3);
      for(i=0 ; i<400000000 ; i++) x += 1;
   }
   
}
