package com.sit.model;

import javax.validation.constraints.NotBlank;

import com.sit.validation.ValidEmail;
import com.sit.validation.ValidPassword;

public class UserCredential {

	@NotBlank
	@ValidEmail
	private String email;

	@NotBlank
	@ValidPassword
	private String password;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
