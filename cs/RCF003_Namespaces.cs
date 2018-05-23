using System;

namespace RCF_NSP01
{
  class RCF_CLS01 //Classes can be loaded separately by other programs! Ex. `using Namespace.Class;`
  {
    static void Main() // Only a single class can have the entry point.
    {
      Console.WriteLine("RCF003 - Namespaces.\n"); 
      Console.WriteLine("Class one loaded!");
	  Console.WriteLine( "16 -> " + Double(8) );
	  //Console.WriteLine( "4  -> " + RCF_NSP01.RCF_CLS02.DivideByTwo(8) );
	  //Console.WriteLine( "7  -> " + RCF_NSP01.RCF_CLS03.DivideByThree(21) );
	  Console.WriteLine( "4  -> " + RCF_CLS02.DivideByTwo(8) );
	  Console.WriteLine( "7  -> " + RCF_CLS03.DivideByThree(21) );
    }
    static int Double(int x)
    {
      return x*2;
    }
  }
  class RCF_CLS02
  {
    public static int DivideByTwo(int x) //! Haven't learned pub/priv yet.
    {
      return x/2;
    }
  }
  class RCF_CLS03
  {
    public static int DivideByThree(int x)
    {
      return x/3;
    }
  }
}
