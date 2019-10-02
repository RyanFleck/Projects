#include <stdio.h>

int ms_delay = 3000;
int register_d = 5000;

int main(int argc, char **argv) {

  int ms_delay_active;

  while( register_d > 0 ){

    ms_delay_active = ms_delay;

    while( ms_delay_active > 0){
      ms_delay_active--; 
    }

    register_d--;
  }
  printf("Delay over.");
  return 0;
}
