package com.sit.service;

import org.springframework.security.core.Authentication;

import com.sit.dto.ManagerDto;
import com.sit.security.AuthToken;

public interface ManagerService {

	void saveManager(ManagerDto managerDto);

	AuthToken managerLogin(Authentication authentication);
}
