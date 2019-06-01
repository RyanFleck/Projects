/*
 * SearchAlg_V3.java
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
import java.util.ArrayList;

public class SearchAlg_V3 {
	
	//Variables
	ArrayList<Recipe> results = new ArrayList<Recipe>();
	
	
	
	//Test cases.
	public static void main (String args[]) 
	{
		ArrayList<String> iText = new ArrayList<String>();
		iText.add("Sassafras");
		iText.add("Drums");
		iText.add("CellPhone");
		iText.add("Lime");
		iText.add("Avocado");
		ArrayList<Integer> iPriority = new ArrayList<Integer>();
		iPriority.add(1);
		iPriority.add(2);
		iPriority.add(3);
		iPriority.add(3);
		iPriority.add(3);
		Recipe[] recipeBank = new Recipe[]{
		new Recipe("Guac A", "Breakfast", "Mexican", new String[]{"Avocado","Pepper","Mango","CellPhone","Magnesium","Lemon","Lime"}),
		new Recipe("Guac B", "Breakfast", "Mexican", new String[]{"Avocado","Pepper","Mango","Violin","Drums","Magnesium","Lime"}),
		new Recipe("Guac C", "Breakfast", "Mexican", new String[]{"Avocado","Pepper","Mango","Magnesium","Lime"}),
		new Recipe("Guac D", "Lunch", "Mexican", new String[]{"Avocado","Pepper","Mango","Magnesium","Lime"}),
		new Recipe("Guac E", "Breakfast", "Danish", new String[]{"Avocado","Pepper","Mango","Magnesium","Lime"}),
		new Recipe("Guac F", "Breakfast", "Mexican", new String[]{"Avocado","Pepper","Mango","CellPhone","Magnesium","Lemon","Sassafras"})
		};
		SearchAlg_V3("Mexican","Breakfast",iText,iPriority,recipeBank);
	}
	
	
	
	
	//Search algorithm. Takes the type, category, two arraylists and an array of recipes for input.
	public static void SearchAlg_V3(String type, String category, ArrayList<String> ingredientsText, ArrayList<Integer> ingredientsPriority, Recipe[] recipes)
	{
		
		
		for(int i=0;ingredientsPriority.size()>i;i++)//Test print for ingredient priorities
			{
				switch(ingredientsPriority.get(i))//Prints the priority of each requested ingredient.
					{//Start of switch
						case 1:
							System.out.println("Excluding "+ingredientsText.get(i));
							break;
						case 2:
							System.out.println("Maybe including "+ingredientsText.get(i));
							break;
						case 3:
							System.out.println("Including "+ingredientsText.get(i));
							break;	
					}//End of switch
			}//End of test print.
		
		
		
		
		for(int x=0;  recipes.length>x  ;x++)//Iterate through recipes and assign priority, then add to 2D array.
		{
			String[] recipeIngredients = recipes[x].getIngredients();
			int recipePriority = 0;
			boolean validResult = true;
			
			for(int y=0;  ingredientsText.size()>y  ;y++)//Iterate through search terms
			{
				for(int z=0;  recipeIngredients.length>z  ;z++)//Iterate through ingredients
				{
					if(ingredientsText.get(y).toLowerCase().equals(recipeIngredients[z].toLowerCase()))
					{//System.out.println("Match found: "+ingredientsText.get(y).toLowerCase()+" == "+recipeIngredients[z].toLowerCase());
						
						
						switch(ingredientsPriority.get(y))//Prints the priority of each requested ingredient.
							{//Start of switch
								case 1:
									validResult = false;
									break;
								case 2:
									recipePriority+=1;
									break;
								case 3:
									recipePriority+=2;
									break;	
							}//End of switch
						}//closes if statement.
				}}//Closes search and recipe iteration.
		
		if(validResult){System.out.println(recipes[x].getTitle()+" has rank "+recipePriority);}
		
		}//Closes last for loop.
		
	}//End of search algorithm
		
}
//EOF
