package com.stp.bpalert;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;

public class EmailContent {
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
