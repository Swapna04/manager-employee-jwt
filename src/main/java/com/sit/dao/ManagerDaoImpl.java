package com.sit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sit.entity.Manager;
import com.sit.exception.CustomException;
import com.sit.exception.ErrorMessages;
import com.sit.repository.ManagerRepository;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	private ManagerRepository managerRepo;

	@Override
	public void saveManager(Manager manager) {

		try {
			managerRepo.save(manager);
		} catch (Exception e) {
			throw new CustomException("Error while saving manager", ErrorMessages.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public boolean isManagerExistsByEmail(String email) {

		return managerRepo.existsByEmail(email);
	}

	@Override
	public Manager findByEmail(String email) {
		Manager manager = managerRepo.findByEmail(email);

		if (manager != null) {
			return manager;
		} else {
			throw new CustomException("Manager not exist by email id " + email, ErrorMessages.MANAGER_NOT_FOUND);
		}

	}
}
