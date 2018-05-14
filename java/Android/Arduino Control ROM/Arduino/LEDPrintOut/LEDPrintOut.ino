                                                                                 //We always have to include the library
#include "LedControl.h"

/*
 Now we need a LedControl to work with.
 ***** These pin numbers will probably not work with your hardware *****
 pin 11 is connected to the DataIn
 pin 9 is connected to the CLK
 pin 10 is connected to LOAD
 We have only a single MAX72XX.
 */
LedControl lc=LedControl(11,9,10,1);
int leds[] = {7,6,5,4,3,2};

/* we always wait a bit between updates of the display */
unsigned long delaytime=750;

void setup() {

for(int y=2;y<=7;y++){
  pinMode(y,OUTPUT);}

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
//ledTest();
countUp();
}


void countUp(){

for(int x=0;x<=1500;x++){
  if(x==0)
  {resetLeds();digitalWrite(leds[0],HIGH);}
  if(x==300)
  {resetLeds();digitalWrite(leds[1],HIGH);}
  if(x==600)
  {resetLeds();digitalWrite(leds[2],HIGH);}
  if(x==900)
  {resetLeds();digitalWrite(leds[3],HIGH);}
  if(x==1200)
  {resetLeds();digitalWrite(leds[4],HIGH);}
  if(x==1500)
  {resetLeds();digitalWrite(leds[5],HIGH);}

  ledPrint(x);
  delay(1000);}

  for(int x=1500;x>300;x--){
  ledPrint(x);
  delay(1);}
  
  for(int x=300;x>=0;x--){
  ledPrint(x);
  delay(1000);}
  
  ledPrint(0000);
  delay(1000);
}

void ledTest(){
int last = 0;
for(int y=2;y<=8;y++){
  digitalWrite(y,HIGH);
  digitalWrite(last,LOW);
  last = y;
  
  delay(1);
  }
}

void ledBlink(int led,int timx)
{
  if(timx%2==0){digitalWrite(led,HIGH);}else{
    digitalWrite(led,LOW);}
}

void resetLedsX()
{
int leds[] = {7,6,5,4,3,2};
for(int x = 0;x<=5;x++){digitalWrite(leds[x],LOW);}
}
void resetLeds()
{digitalWrite(leds[0],LOW);
digitalWrite(leds[1],LOW);
digitalWrite(leds[2],LOW);
digitalWrite(leds[3],LOW);
digitalWrite(leds[4],LOW);
digitalWrite(leds[5],LOW);}

void testLeds()
{
resetLeds();
for(int x = 0;x<sizeof(leds);x++){digitalWrite(leds[x],HIGH);}
delay(200);
resetLeds();
delay(200);
for(int x = 0;x<sizeof(leds);x++){digitalWrite(leds[x],HIGH);}
delay(200);
resetLeds();
}

void ledPrint(int value)
{
  int mins = value/60;
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

    lc.setDigit(0,1,mins/10,false);
    lc.setDigit(0,0,mins%10,false);

}

