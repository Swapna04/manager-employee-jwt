package com.sit.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sit.validation.ValidMobile;
import com.sit.validation.ValidName;

public class EmployeeDto extends CommonFields {

	@NotBlank
	@ValidMobile
	private String mobile;

	@NotBlank
	@ValidName
	@Size(max = 60, message = "Max 60 characters are allowed")
	private String city;

	public String getMobile() {
		return mobile;
	}

	public String getCity() {
		return city;
	}

}
