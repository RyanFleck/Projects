package com.ryanfleck.jsftest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

// https://www.tutorialspoint.com/jsf/jsf_managed_beans.htm

// Eager -> Bean created before it is requested.
@ManagedBean(name = "helloWorld", eager = true)
@RequestScoped
public class HelloWorld {

	@ManagedProperty(value = "#{message}")
	private Message messageBean;
	private String message;

	public HelloWorld() {
		System.out.println("HelloWorld started!");
	}

	public String getMessage() {
		if (messageBean != null) {
			message = messageBean.getMessage();
		}
		return message;
	}

	public void setMessageBean(Message message) {
		this.messageBean = message;
	}

}

/*
 * Software Architecture Notes 2019-09-12:
 * 4+1 Architecture:
 * - Use case view
 * - Logical view
 * - Component view
 * - Process view
 * - Physical view
 */
