using System;
using System.Text;

class Program
{
 
  //A 'STACK' block of memory will grow and shrink as this recursive function runs.
  static int Factorial (int x)
  {
    if ( x == 0 ) return 1;
    return x * Factorial( x-1 );
  }

  //A 'HEAP' is a 'STACK' of objects.
  static void Main()
  {
    Console.WriteLine("RCF010 - Stacks and Heaps\n"); 
    Console.WriteLine(Factorial(5)); 

    StringBuilder rcf1 = new StringBuilder( "object1" );
    Console.WriteLine( rcf1 );
    //Garbage collector should come for rcf1 now.

    StringBuilder rcf2 = new StringBuilder( "object2" ); 
    StringBuilder rcf3 = new StringBuilder( "object3" );
    StringBuilder rcf4 = rcf2;

    Console.WriteLine( rcf4 );
  }
 
}
