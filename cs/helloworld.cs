using System;

public class HelloWorld
{
  static public void Main ()
  {
    Console.WriteLine ("Hello World!");
    int x = 12 * 30;
    Console.WriteLine (x);
    Console.WriteLine (Double(x));
  }

  static int Double (int x)
  {
    int doubled = x * 2;
    return doubled;
  }

}
