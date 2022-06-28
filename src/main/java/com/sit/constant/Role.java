package com.sit.constant;

public class Role {
	
	private Role() {
		throw new IllegalStateException("Constants class can not be instatiate");
	}

	public static final String MANAGER = "hasRole('MANAGER')";
}
