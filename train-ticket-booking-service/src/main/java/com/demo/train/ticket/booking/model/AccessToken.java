package com.demo.train.ticket.booking.model;

public class AccessToken {

	private String token;
	private String email;

	public AccessToken() {
	}

	public AccessToken(String token, String email) {
		this.token = token;
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
