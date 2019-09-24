package com.ryanfleck.jsftest;

import javax.faces.bean.ManagedBean;

// https://www.tutorialspoint.com/jsf/jsf_managed_beans.htm

// Eager -> Bean created before it is requested.
@ManagedBean(name = "helloWorld", eager = true)
public class HelloWorld {

	public HelloWorld() {
		System.out.println("HelloWorld started!");
	}

	public String getMessage() {
		return "Hello World!";
	}

}
