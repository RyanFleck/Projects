using System;

class Program
{
  static void Main()
  {
    Console.WriteLine("RCF007 - Arrays\n");
	
	//Simple declaration:
	int[] letters = new int[5];
	
	//Iterate through and assign values
	for(int i=0; i<letters.Length; i++)
	{
		letters[i] = 10-i;
	}	
	
	//Print values
	for(int i=0; i<letters.Length; i++)
	{
		Console.WriteLine("letters["+i+"] = "+letters[i]);
	}
	
	PrintArray(new int[] {1, 2, 3, 234, 32, 2, 1});
  }
  
  
  static void PrintArray (int[] array)
  {
	Console.WriteLine("Contents of Array:");  
	for(int i=0; i<array.Length; i++)
	{
		Console.WriteLine("array["+i+"] = "+array[i]);
	}
  }
  
}