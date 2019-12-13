#include <stdio.h>
#include <string.h>

struct person {
  long id;
  char name[50];
};

void printRecord(struct person *identity);

void main(void) {

  struct person richard;
  richard.id = 12345;
  strcpy(richard.name, "Richard Wright");
  printRecord(&richard);

  struct person staff[10];
  staff[0].id = 53423;
  strcpy(staff[0].name, "Stewart Holmes");
  printRecord(&staff[0]);
}

void printRecord(struct person *identity) {
  printf("%s's ID: %i\n", identity->name, identity->id);
}
