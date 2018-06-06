using System;

class Program
{
  static void Main()
  {
    Console.WriteLine("RCF008 - Jagged Arrays\n");

	//Simple declaration:
	int[] Letters = new int[5];
  
  //SQUARE arrays:
  //Declare a matrix:
  int[,] Matrix = new int[3,3];

  //Declare and fill a matrix:
  int[,] MatrixTwo = new int[,]
  {
    {0,1,2},
    {3,4,5},
    {6,7,8}
  };
  
  //JAGGED arrays:
  //Jagged array with outermost dimension 3:
  int[][] JaggedOne = new int[3][];
  //(Internal arrays are null.)

  //Jagged array with alternate instantiation:
  int[][] JaggedTwo = new int[][]
  {
    new int[]{1,2,3},
    new int[]{4,5,6,7,8},
    new int[]{9,10,11}
  };

  //Initialize internal arrays:
  for (int x=0; x<JaggedOne.Length; x++)
  {
    JaggedOne[x] = new int[3];
    for (int y=0; y<JaggedOne[x].Length; y++)
    {
      JaggedOne[x][y]= x*3+y; 
    }
  }

  //Print JaggedOne:
  for (int x=0; x<JaggedOne.Length; x++)
  {
    for (int y=0; y<JaggedOne[x].Length; y++)
    {
      Console.WriteLine(JaggedOne[x][y]);
    }
  }


	//Iterate through and assign values, .length returns length.
	for(int i=0; i<Letters.Length; i++)
	{
	  Letters[i] = 10-i;
	}

	//Print values
	for(int i=0; i<Letters.Length; i++)
	{
	  Console.WriteLine("Letters["+i+"] = "+Letters[i]);
	}
  }
}
