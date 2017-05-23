#include <SoftwareSerial.h>
#include <LedControl.h>
// Arduino Pin 7 to DIN, 6 to Clk, 5 to LOAD, no.of devices is 1
//(DIN,CLK,LOAD,Devices)_
LedControl ledPanel=LedControl(5,6,7,2);
int x=0;
void setup() {
  pinMode(13, OUTPUT);
  Serial.begin(9600);
  digitalWrite(13, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(100);              // wait for a second
  digitalWrite(13, LOW);    // turn the LED off by making the voltage LOW
  delay(100);  
  
  ledPanel.shutdown(0,false);
  delay(100);
  ledPanel.shutdown(0,true);
  delay(100);
  ledPanel.shutdown(0,false);
  ledPanel.setIntensity(0,2);
  ledPanel.clearDisplay(0);
  ledPanel.clearDisplay(1);
  ledPanel.setDigit(0,0,x,true); 
  ledPanel.setDigit(0,1,x,true); 
  ledPanel.setDigit(0,2,x,true); 
  
 
}

void loop() {

  digitalWrite(13, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(100);              // wait for a second
  digitalWrite(13, LOW);    // turn the LED off by making the voltage LOW
  delay(100);   
  ledPanel.clearDisplay(0);
  ledPanel.setDigit(0,0,x,true); 
  ledPanel.setDigit(0,1,x,true); 
  ledPanel.setDigit(0,2,x,true); 
  Serial.print("Test");
  Serial.println(x);
  delay(1000);
  if(x==9){x=0;}else{x++;}}
