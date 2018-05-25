using System;
//using RCF003_Namespaces.exe;

namespace TypeTest
{

	class Program
	{
	  static void Main()
	  {
		Console.WriteLine("RCF005 - Types\n"); 
		int x = 144/12;
		string message = "Hello World!";
		const int life = 42;
		bool george = true;
		Console.WriteLine("Tests: " + x + message + life + george);
		if ( life > 40 )
			Console.WriteLine("Old.");
		
		// Haven't learned how to import/use namespaces and classes yet.
		//Console.WriteLine( "7  -> " + RCF_NSP01.RCF_CLS03.DivideByThree(21) );

		// Utilizing 'Multiplier' type.
		Multiplier m1 = new Multiplier (3);
		Console.WriteLine(  "9 -> " + m1.Apply(3)  );
		
		Multiplier m2 = new Multiplier (99);
		Console.WriteLine(  "99 -> " + m2.Apply(1)  );
		
		// Utilizing 'StaticTests' type.
		StaticTests a = new StaticTests();
		StaticTests b = new StaticTests();
		StaticTests c = new StaticTests();
		StaticTests d = new StaticTests();
		StaticTests e = new StaticTests();
		// At this point, isstatic == 5.
		
		//Utilizing TernaryCompare method:
		Console.WriteLine("MAX( 4 2 )? >> "+TernaryCompare(4,2));
		Console.WriteLine("MAX( 42 212 )? >> "+TernaryCompare(42,212));
		
		Console.WriteLine((12 > 121) ?  "True" : "False"); //Bleh
		
	  }
	  
	  static int TernaryCompare(int a, int b)
	  {
		  return (a > b) ? a : b;
	  }
	  
	}
	
	public class Multiplier
	{
		// Data members:
		int factor; // Field
		
		// Function members:
		
		// Constructor
		public Multiplier ( int input ) { factor = input; }
		
		// Method
		public int Apply ( int input ) { return input * factor; }
	}
	
	public class StaticTests
	{
		public static int isstatic;
		public int notstatic;
		
		public StaticTests () 
		{
			isstatic++;
			notstatic++;
			Console.WriteLine("Static: "+isstatic);
			Console.WriteLine("Not static: "+notstatic);
		}
	}
}