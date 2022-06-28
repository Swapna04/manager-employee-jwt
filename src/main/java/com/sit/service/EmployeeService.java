package com.sit.service;

import java.util.List;

import javax.validation.Valid;

import com.sit.dto.EmployeeDto;
import com.sit.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(EmployeeDto employeeDto);

	List<Employee> allEmployees();

	Employee updateEmployee(String employeeUuid, @Valid EmployeeDto employeeDto);

	void deleteEmployee(String employeeUuid);

	Employee employeeByUuid(String employeeUuid);
}
