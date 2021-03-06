package com.sit.dao;

import java.util.List;

import com.sit.entity.Employee;

public interface EmployeeDao {

	Employee saveEmployee(Employee employee);

	boolean isEmployeeExistsByMobile(String mobile);

	List<Employee> allEmployees();

	Employee findByEmployeeUuid(String employeeUuid);

	void deleteEmployee(Employee employee);
}
