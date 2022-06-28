package com.sit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sit.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

	boolean existsByEmail(String email);

	Manager findByEmail(String email);
}
