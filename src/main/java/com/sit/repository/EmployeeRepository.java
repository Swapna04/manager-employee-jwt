package com.sit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sit.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	boolean existsByMobile(String mobile);

	Employee findByEmployeeUuid(String employeeUuid);
}
