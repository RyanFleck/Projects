#include <LedControl.h>
// Arduino Pin 7 to DIN, 6 to Clk, 5 to LOAD, no.of devices is 1
//(DIN,CLK,LOAD,Devices)_
LedControl ledPanel=LedControl(26,28,27,1);

void setup() {
  pinMode(13, OUTPUT);
  
  digitalWrite(13, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(100);              // wait for a second
  digitalWrite(13, LOW);    // turn the LED off by making the voltage LOW
  delay(100);  
  
  ledPanel.shutdown(0,false);
  
  ledPanel.setIntensity(0,2);
  ledPanel.clearDisplay(0);
  
}

void loop() {

  digitalWrite(13, HIGH);   // turn the LED on (HIGH is the voltage level)
  delay(100);              // wait for a second
  digitalWrite(13, LOW);    // turn the LED off by making the voltage LOW
  delay(100);   
  ledPanel.clearDisplay(0);
  ledPanel.setDigit(0,0,1,false); 
  delay(1000);

}


