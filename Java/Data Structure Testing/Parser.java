/*
 * Parser.java
 * 
 * Copyright 2017:
 * 		Ryan Fleck <rflec028@uottawa.ca>
 * 		Arsham Jalayer <TODO: Get contact info.>
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

class Parser{
	
private static File file;
private static FileReader fread;
private static BufferedReader bread;
private static String token;

	public static void main(String[] args)
	{
		String filename = "input2.txt"; //We could implement this to take command line input (args[0])
		
		try{
			System.out.println("Loading text file: "+filename);
			file = new File(filename);
			fread = new FileReader(file);
			bread = new BufferedReader(fread);
			System.out.println(filename+" loaded!");
		}catch(Exception e){System.out.println("Error loading file...");}
		
		System.out.println(token);
		System.out.println(mainthing());
		
	}
	//check the first grammar of program//

	private static String mainthing(){
		token=nextLine();
		System.out.println(token);
		if(Program().equals("ERROR")||!token.equals("$")){
			System.out.println(token);
			return "ERROR";
		}
		else return "OK";
	}
	
	private static String Program(){
		if(token.equals("begin")){
			token=nextLine();
			System.out.println(token);
			if(statementList().equals("OK")){
				if(token.equals("end")){
					token=nextLine();
					System.out.println(token);
					return "OK";
				}
				else return "ERROR";
			}
			else return "ERROR";
		}
		else{
			return "ERROR";
		}
	}
	
	private static String statementList(){
		if(statement().equals("ERROR")){
			return "ERROR";
		}
		else{
			if(token.equals(";")){
				token=nextLine();
				System.out.println(token);
				return statementListPrime();
			}
			else return "ERROR";
		}
	}
	
	private static String statement(){
		if(token.equals("id")){
			token=nextLine();
			System.out.println(token);
			if(token.equals("=")){
				token=nextLine();
				System.out.println(token);
				return Expression();
			}
			else return "ERROR";
		}
		else return "ERROR";
	}
	
	private static String Expression(){
		if(factor().equals("ERROR")){
			return "ERROR";
		}
		else return ExpressionPrime();
	}
	
	private static String ExpressionPrime(){
		if(token.equals("+")){
			token=nextLine();
			System.out.println(token);
			return factor();
		}
		else if(token.equals("-")){
			token=nextLine();
			System.out.println(token);
			return factor();
		}
		else return "OK";
	}
	
	private static String factor(){
		if(token.equals("id")){
			token=nextLine();
			System.out.println(token);
			return "OK";
		}
		else if(token.equals("num")){
			token=nextLine();
			System.out.println(token);
			return "OK";
		}
		else return "ERROR";
		
	}
	private static String statementListPrime(){
		if(statementList().equals("OK")){
		return "OK";
		}
		else return "OK";
	}
	
	private static String nextLine() //Returns the next line in text file as a string.
	{	String line = null;
		try{
			line = bread.readLine();
		}catch(Exception e){System.out.println("Could not read line.");}
		
		return line;
	}
	
	}
