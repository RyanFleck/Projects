#include <stdio.h>
#include <string.h>

char str[20];

void main(void) {

  strcpy(str, "Hello World!\n");
  printf("%s", str);

  char *pt;
  pt = str;
  printf("%s", pt);

  pt = &str[0];
  printf("%s", pt);
}
