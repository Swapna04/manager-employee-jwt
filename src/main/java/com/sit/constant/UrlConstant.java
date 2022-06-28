package com.sit.constant;

public class UrlConstant {

	private UrlConstant() {
		throw new IllegalStateException("Constants class can not be instatiate");
	}

	public static final String BASE_URL = "api/v1";

	public static final String LOGIN = "login";
	
	public static final String SIGNUP = "signup";

	public static final String EMPLOYEES = "employees";
	
	public static final String SINGLE_EMPLOYEE = "employees/{employeeUuid}";
}
