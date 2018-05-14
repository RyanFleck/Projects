using System;

namespace RCF_NSP01
{
  class RCF_CLS01 //Classes can be loaded separately by other programs! Ex. `using Namespace.Class;`
  {
    static void Main()
    {
      Console.WriteLine("Class one!");
    }
    static int Double(int x)
    {
      return x*2;
    }
  }
  class RCF_CLS02
  {
    static void Main()
    {
      Console.WriteLine("Class two!");
    }
    static int DivideByTwo(int x)
    {
      return x/2;
    }
  }
}
