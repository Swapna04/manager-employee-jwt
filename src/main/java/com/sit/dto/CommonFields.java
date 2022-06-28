package com.sit.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sit.validation.ValidName;


public class CommonFields {

	@NotBlank
	@ValidName
	@Size(max = 40, message = "{name.size}")
	private String firstName;

	@NotBlank
	@ValidName
	@Size(max = 40, message = "{name.size}")
	private String lastName;

	private Date dateOfBirth;

	@NotBlank
	@Size(max = 250, message = "Max 250 characters are allowed")
	private String address;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

}
