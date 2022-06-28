package com.sit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sit.dao.ManagerDao;
import com.sit.dto.ManagerDto;
import com.sit.entity.Manager;
import com.sit.exception.CustomException;
import com.sit.exception.ErrorMessages;
import com.sit.mapper.Mapper;
import com.sit.security.AuthToken;
import com.sit.security.JwtTokenUtil;
import com.sit.util.CustomGenerator;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerDao managerDao;

	@Autowired
	private Mapper mapper;

	@Autowired
	private CustomGenerator generator;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	//Adds new manager
	@Override
	public void saveManager(ManagerDto managerDto) {

		if (managerDao.isManagerExistsByEmail(managerDto.getEmail())) {
			throw new CustomException("Manager with Email id " + managerDto.getEmail() + " already exist",
					ErrorMessages.USER_ALREADY_EXIST);
		}

		Manager manager = mapper.convert(managerDto, Manager.class);

		manager.setManagerUuid(generator.generateUUID());
		manager.setPassword(passwordEncoder.encode(managerDto.getPassword()));

		managerDao.saveManager(manager);
	}

	//Login of Manager
	@Override
	public AuthToken managerLogin(Authentication authentication) {

		String token = jwtTokenUtil.generateToken(authentication);

		return new AuthToken(token);
	}
}
