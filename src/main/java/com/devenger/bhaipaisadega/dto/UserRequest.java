package com.devenger.bhaipaisadega.dto;

import javax.validation.constraints.NotNull;

public class UserRequest {

	@NotNull
	private String userName;

	@NotNull
	private String password;

	@NotNull
	private String email;

	@NotNull
	private String name;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
