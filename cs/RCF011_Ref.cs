using System;

class Program
{
  static void Main()
  {
    Console.WriteLine("RCF011 - Ref Modifier\n"); 

    int x = 3;
    int y = 3;

    Console.WriteLine("X="+x+" Y="+y);
    
    addone(x);
    addoneref(ref y);
   
    // This should show that Y has been incremented, but X has not.
    Console.WriteLine("X="+x+" Y="+y);

  }

  private static void addone(int a){
    a = a + 1;
  }
  private static void addoneref(ref int a){
    a = a + 1;
  }
}
