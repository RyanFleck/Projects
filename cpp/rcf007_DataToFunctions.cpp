#include <iostream>

/*
 * rcf007-DataToFunctions.cpp
 *
 * Simple example showing how to pass by value, pointer and reference
 * to functions in C++.
 *
 * Copyright 2019 Ryan Fleck - Ryan.Fleck@protonmail.com
 *
 */

struct Complex {
  double r, i;
};

int random2(void);
void display_by_value(Complex c);
void display_by_pointer(Complex *pc);
void display_by_reference(Complex &rc);

int main(void) {
  std::cout << "Hello, World!\n";
  random2();

  // Define a complex thing.
  struct Complex thing;
  Complex *ptr;
  ptr = &thing;

  thing.r = 2;
  thing.i = 4;

  std::cout << thing.r << "\n";

  display_by_value(thing);
  display_by_pointer(ptr);
  display_by_reference(thing);
  display_by_value(thing);

  return 0;
}

int random2(void) {
  std::cout << "func!\n";
  return 0;
}

void display_by_value(Complex c) {
  std::cout << "\nValue:\n";
  std::cout << c.r << " " << c.i << "\n";
  std::cout << "Set to 12 and 13:\n";
  c.r = 12;
  c.i = 13;
  std::cout << c.r << " " << c.i << "\n";
}

void display_by_pointer(Complex *pc) {
  std::cout << "\nPointer:\n";
  std::cout << pc->r << " " << pc->i << "\n";
  std::cout << "Set to 24 and 25:\n";
  pc->r = 24;
  pc->i = 25;
  std::cout << pc->r << " " << pc->i << "\n";
}

void display_by_reference(Complex &rc) {
  std::cout << "\nReference:\n";
  std::cout << rc.r << " " << rc.i << "\n";
  std::cout << "Set to 36 and 37:\n";
  rc.r = 34;
  rc.i = 35;
  std::cout << rc.r << " " << rc.i << "\n";
}
