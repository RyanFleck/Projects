package com.ryanfleck.ca.ceg3156.lab4;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		String s = "";

		if (args.length > 0) {
			s = args[0];
		}

		s = s.toLowerCase();

		System.out.println("Input: " + s);
		
		if (s.contains("ser")) {
			Server.run();

		} else if (s.contains("cli")) {
			Client.run();
		}

	}
}
