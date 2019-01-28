/*
  Dual MAX7219 board control program.
  Ryan Fleck 2019

  Resources:
  1. http://www.ardumotive.com/8-digit-7seg-display-en.html
*/

#include "LedControl.h"

// DIN 2
// CS 3
// CLK 4

int pin_din = 2;
int pin_cs = 3;
int pin_clk = 4;
char incomingByte = 0; // for incoming serial data
String r = "";
int len = 0;

LedControl led_board = LedControl(pin_din, pin_clk, pin_cs, 1);

// the setup routine runs once when you press reset:
void setup()
{
    // initialize seri al communication at 9600 bits per second:
    Serial.begin(9600);
    Serial.println("Arduino Serial out is UP.");
    led_board.shutdown(0, false);
    led_board.setIntensity(0, 2);
    led_board.clearDisplay(0);

    unsigned long delaytime = 250;

    // Init sequence.
    for (int x = 0; x < 8; x++)
    {
        led_board.setDigit(0, (7 - x), (7 - x), false);
        delay(50);
    }
    delay(500);
    for (int x = 0; x < 8; x++)
    {
        led_board.setDigit(0, (7 - x), 8, true);
        delay(50);
    }
    delay(500);
    for (int x = 0; x < 8; x++)
    {
        led_board.setChar(0, (7 - x), ' ', false);
        delay(50);
    }
    led_board.clearDisplay(0);
    String intro = "A97     ";
    for (int x = 0; x < 8; x++)
    {
        led_board.setChar(0, (7 - x), intro[x], false);
        delay(50);
    }
    delay(1000);
    for (int x = 0; x < 3; x++)
    {
        led_board.setChar(0, (7 - x), ' ', false);
        delay(50);
    }
    led_board.clearDisplay(0);

    /*
  led_board.setChar(0,0,'a',false);
  delay(delaytime);
  led_board.setRow(0,0,0x05);
  delay(delaytime);
  led_board.setChar(0,0,'d',false);
  delay(delaytime);
  led_board.setRow(0,0,0x1c);
  delay(delaytime);
  led_board.setRow(0,0,B00010000);
  delay(delaytime);
  led_board.setRow(0,0,0x15);
  delay(delaytime);
  led_board.setRow(0,0,0x1D);
  delay(delaytime);
  led_board.clearDisplay(0);
  delay(delaytime);
  */
}

// the loop routine runs over and over again forever:
void loop()
{

    // send data only when you receive data:
    if (Serial.available() > 0)
    {
        // read the incoming byte:
        r = Serial.readString();

        // say what you got:
        Serial.print("\nI received: ");
        Serial.print(r);

        len = r.length() - 1;
        if (len > 8)
        {
            len = 8;
        }

        Serial.print("\nLen: ");
        Serial.println(len);
        for (int x = 0; x < 8; x++)
        {
            led_board.setChar(0, (7 - x), ' ', false);
            delay(50);
        }
        for (int x = 0; x < len; x++)
        {
            led_board.setChar(0, (7 - x), r[x], false);
            delay(50);
        }
    }

    delay(1); // delay in between reads for stability
}