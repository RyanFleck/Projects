using System;

class Program
{
  static void Main() // Default entry point of execution.
  {
    Console.WriteLine("30 feet to inches: "+ FeetToInches(30));
    Console.WriteLine("100 feet to inches: "+ FeetToInches(100));
    Console.WriteLine("13 feet to inches: "+ FeetToInches(13));
    Console.WriteLine("44 feet to inches: "+ FeetToInches(44));
  }

  static int FeetToInches(int feet)
  {
    int inches = feet * 12;
    return inches;
  }
}
