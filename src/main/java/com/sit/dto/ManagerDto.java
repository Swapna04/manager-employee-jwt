package com.sit.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sit.validation.ValidEmail;
import com.sit.validation.ValidPassword;

public class ManagerDto extends CommonFields {

	@NotBlank
	@ValidEmail
	private String email;

	@NotBlank
	@ValidPassword
	private String password;

	@NotBlank
	@Size(max = 60, message = "Max 60 characters are allowed")
	private String company;

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getCompany() {
		return company;
	}

}
