package com.sit.dao;

import com.sit.entity.Manager;

public interface ManagerDao {

	void saveManager(Manager manager);

	boolean isManagerExistsByEmail(String email);

	Manager findByEmail(String email);
}
