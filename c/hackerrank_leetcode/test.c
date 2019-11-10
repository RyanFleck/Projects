#include <stdio.h>
#include <stdbool.h>

int DDRA, PORTA;

int main()
{
}

void delay(int * time){
    int delayCount = *time;
    pollDelay(delayCount);
}

void initKeyPad()
{
    printf("Initializing keypad.");
    DDRA = 0xF0;
}

void readKey()
{
    PORTA = 0x0F;

    // wait a sec...

    if (PORTA != 0x0F)
    {
        char input = getChar(PORTA);

        PORTA = 0x0F;
        delay(10);
        if (PORTA == getChar(PORTA))
        {
            translate(input);
        }
    }
}

void delay(int time) {}

void pollReadKey(PORTA)
{
    PORTA = 0x0F;

    bool keydetected = false;

    while (keydetected)
    {
        if (PORTA != 0x0F)
        {
            delay(2);
            if (PORTA != 0x0F)
            {
                readKey();
                keydetected = 1;
            }
        }
    }
}

char getChar(int x)
{
    return 'c';
}