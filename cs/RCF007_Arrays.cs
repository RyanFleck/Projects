using System;

class Program
{
  static void Main()
  {
    Console.WriteLine("RCF007 - Arrays\n");
	
	//Simple declaration:
	int[] letters = new int[5];
	
	//Iterate through and assign values, .length returns length.
	for(int i=0; i<letters.Length; i++)
	{
	  letters[i] = 10-i;
	}	
	
	//Print values
	for(int i=0; i<letters.Length; i++)
	{
	  Console.WriteLine("letters["+i+"] = "+letters[i]);
	}
	
	// Array Initialization Expression
	PrintArray("Integers", new int[] {1, 2, 3, 234, 32, 2, 1});
	PrintArray("Empty int[]",new int[3]);
	PrintArray("A few numbers",new int[]{492,200,126, 0});
	
	//TODO: Make PrintArray method able to take any array!
	//PrintArray("Empty string[]",new string[3]);
	//PrintArray("Empty char[]",new char[3]);
	
	/* COMPILER CAN'T HANDLE THIS.
	//Point tests:
	clsPoint a = new clsPoint();
	a.X = 3;
	a.Y = 5;
	Console.WriteLine("\nPoint a has coordinates ("+a.X+","+a.Y+")");
	
	clsPoint b = new clsPoint();
	Console.WriteLine("\nPoint b has coordinates ("+b.X+","+b.Y+")");
	
	//Array of structures:
	clsPoint[] scatterPlot = new clsPoint[1000];
	
	for(int x=0; x<scatterPlot.length; x++) //Hm? Compiler can't handle.
	{
	  scatterPlot[x] = new Point();
	}
	
	for(int x=0; x<scatterPlot.length; x++)
	{
	  scatterPlot[x] = new clsPoint();
	  scatterPlot[x].X = x;
	  scatterPlot[x].Y = x;
	}

	Console.WriteLine("\nPoint c has coordinates ("+scatterPlot[432].X+","+scatterPlot[432].Y+")");
	*/
	
	Console.WriteLine("\nDONE.");
  }
  
  /*
  public struct strPoint { public int X, Y; }
  public class clsPoint { public int X, Y; }
  */
  
  static void PrintArray (string name, int[] array)
  { 
	Console.WriteLine("\nPRINT ARRAY:\n"+name+"\n");  
	for(int i=0; i<array.Length; i++)
	{
	  Console.WriteLine("array["+i+"] = '"+array[i]+"'");
	}
  }
}