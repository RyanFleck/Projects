                                                                                 //We always have to include the library
#include "LedControl.h"

/*
 Now we need a LedControl to work with.
 ***** These pin numbers will probably not work with your hardware *****
 pin 12 is connected to the DataIn
 pin 11 is connected to the CLK
 pin 10 is connected to LOAD
 We have only a single MAX72XX.
 */
LedControl lc=LedControl(11,9,10,1);

/* we always wait a bit between updates of the display */
unsigned long delaytime=750;

void setup() {
  /*
   The MAX72XX is in power-saving mode on startup,
   we have to do a wakeup call
   */
  lc.shutdown(0,false);
  /* Set the brightness to a medium values */
  lc.setIntensity(0,2);
  /* and clear the display */
  lc.clearDisplay(0);
  
}


void loop() {
  ledPrint(9920);
  ledPrint(4000);
  ledPrint(329);
  ledPrint(500);
  ledPrint(29);
  ledPrint(8866);
}


void ledPrint(int value)
{
  lc.clearDisplay(0);

  if(value<10)
  { lc.setDigit(0,4,value,false);}

  else if(value<100)
  { lc.setDigit(0,5,value/10,false);
    lc.setDigit(0,4,value%10,false);}

  else if(value<1000)
  { lc.setDigit(0,6,value/100,false);
    lc.setDigit(0,5,(value%100)/10,false);
    lc.setDigit(0,4,(value%100)%10,false);}

  else if(value<10000)
  { lc.setDigit(0,7,value/1000,false);
    lc.setDigit(0,6,(value%1000)/100,false);
    lc.setDigit(0,5,((value%1000)%100)/10,false);
    lc.setDigit(0,4,(((value%1000)%100)%10),false);}

   delay(400);
}


