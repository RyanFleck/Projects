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
  }
}