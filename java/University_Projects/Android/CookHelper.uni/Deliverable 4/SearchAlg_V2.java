/*
 * SearchAlg.java
 * 
 * Copyright 2016 Ryan Fleck <ryan@ryan-Candy>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
import java.util.Arrays;

public class SearchAlg_V2 {
	
	private String type, category;
	private String[] ingredients;
	private int[] priority;
	//private static int recipeIndex = 0;
	
	//string.toLowerCase()
	
	public static void Search(String input, String type, String category, Recipe[] recipes)
	{
		if(!input.isEmpty()) //SHIT we need to account for when this is true!
		{
			System.out.print("Text processing initiated.\nIngredients:\n");
			input = input.toLowerCase();
			String[] tempInputList = input.split(" ");
			
			String[][] inputList = new String[tempInputList.length][2]; //  Pair with operator and ingredient
			//String[][] outputList = new String[tempInputList.length][2]; //  Pair with value and recipe
			
			//Process query into 2D array.
			
			for(int i=0;tempInputList.length>i;i++)
			{
				String tempString = tempInputList[i].substring(1);
				String tempOperator = String.valueOf(tempInputList[i].charAt(0));
				inputList[i][0] = tempOperator;
				inputList[i][1] = tempString;

				switch(inputList[i][0])
				{
				case "+":
					System.out.println("Including "+inputList[i][1]);
					break;
				case "-":
					System.out.println("Excluding "+inputList[i][1]);
					break;
				case "*":
					System.out.println("Maybe including "+inputList[i][1]);
					break;	
				}
			}
				
			//Begin search in recipes
			System.out.println("Beginning recipe search.");
			
			
			for(int z=0;z<recipes.length;z++) //Iterate through recipes
				{
					int recipeValue = 0;
					boolean include = true;
					String[] ingredientsList = recipes[z].getIngredients();
				
					
					if((recipes[z].getType().equals(type)||recipes[z].getType().equals(""))&&(recipes[z].getCategory().equals(category)||recipes[z].getCategory().equals("")))
					{
					for(int y=0; y < inputList.length; y++) //Iterate through search terms
					{
						for(int x=0;x <ingredientsList.length;x++) //Iterate through recipe ingredients
							{
								if( ingredientsList[x].toLowerCase().equals(inputList[y][1]) )
								{
										switch(inputList[y][0])
										{
										case "+":
											//System.out.println("Including "+inputList[i][1]);
											recipeValue += 2;
											break;
										case "-":
											//System.out.println("Excluding "+inputList[i][1]);
											include = false;
											break;
										case "*":
											//System.out.println("Maybe including "+inputList[i][1]);
											recipeValue += 1;
											break;	
										}
									
								}
									
							}
					}
					
				
				}
				else{include=false;}
				
				System.out.println(recipes[z].getTitle()+" has rank "+recipeValue+" Included: "+include);	
				if(include)
				{
					//outputList[recipeIndex][0] = Integer.toString(recipeValue); //nope
					//outputList[recipeIndex][1] = recipes[z];  //nope
					//recipeIndex++;
				}			
				}
				
					
				//Arrays.sort(outputList);	
				}
			}
			
	
	
	
	public static void main (String args[]) {
		System.out.println("Loading recipes.");
		Recipe[] recipeBank = new Recipe[]{
		new Recipe("Guac A", "Breakfast", "Mexican", new String[]{"Avocado","Pepper","Mango","CellPhone","Magnesium","Lemon","Lime"}),
		new Recipe("Guac B", "Breakfast", "Mexican", new String[]{"Avocado","Pepper","Mango","Violin","Drums","Magnesium","Lime"}),
		new Recipe("Guac C", "Breakfast", "Mexican", new String[]{"Avocado","Pepper","Mango","Magnesium","Lime"}),
		new Recipe("Guac D", "Lunch", "Mexican", new String[]{"Avocado","Pepper","Mango","Magnesium","Lime"}),
		new Recipe("Guac E", "Breakfast", "Danish", new String[]{"Avocado","Pepper","Mango","Magnesium","Lime"}),
		new Recipe("Guac F", "Breakfast", "Mexican", new String[]{"Avocado","Pepper","Mango","CellPhone","Magnesium","Lemon","Sassafras"})
		};
		String searchString = "+Avocado +Cellphone +Violin +Drums  -Sassafras *Magnesium *Orange";
		System.out.println("Recipes loaded. Searching for '"+searchString+"'");
		String typ = "Breakfast";
		String cat = "Mexican";
		Search(searchString,typ,cat,recipeBank);
		
	}
}


//TEST COMMENT TO MAKE SURE GIT IS WORKING
