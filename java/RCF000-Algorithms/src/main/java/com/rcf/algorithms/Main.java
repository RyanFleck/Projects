
package com.rcf.algorithms;

/**
 * @author Ryan Fleck
 *
 */
public class Main {

	private static String helloMessage = "Hello, World!";

	public static void main(String[] args) {
		System.out.println(getHelloMessage());
	}

	public static String getHelloMessage() {
		return Main.helloMessage;
	}

	public static void setHelloMessage(String helloMessage) {
		Main.helloMessage = helloMessage;
	}
}
