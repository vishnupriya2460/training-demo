package com.demo.user.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRequest {

	@NotEmpty(message = "name is mandatory")
	private String name;

	@NotEmpty(message = "email is mandatory")
	@Email(message = "invalid email")
	private String email;

	@Size(min = 8, message = "password length should be minimum 8 characters")
	private String password;

	public UserRequest() {
	}

	public UserRequest(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
