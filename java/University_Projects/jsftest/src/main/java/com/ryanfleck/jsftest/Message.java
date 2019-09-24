package com.ryanfleck.jsftest;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "message", eager = true)
@RequestScoped
public class Message {
	private String message = "Pizza Pie!";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}