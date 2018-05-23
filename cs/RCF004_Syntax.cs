using System;

class Program
{
  static void Main()
  {
	Console.WriteLine("RCF004 - Syntax\n."); 
    int a = 123/4;
    int @int = 3; // Using @ allows you to sneak a keyword past as an identifier.
    Console.WriteLine(a);
    Console.WriteLine(@int);
  }
}
