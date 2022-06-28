package com.sit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sit.entity.Employee;
import com.sit.exception.CustomException;
import com.sit.exception.ErrorMessages;
import com.sit.repository.EmployeeRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public Employee saveEmployee(Employee employee) {

		try {
			return employeeRepo.save(employee);
		} catch (Exception e) {
			throw new CustomException("Error while saving employee", ErrorMessages.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public boolean isEmployeeExistsByMobile(String mobile) {

		return employeeRepo.existsByMobile(mobile);
	}

	@Override
	public List<Employee> allEmployees() {

		return employeeRepo.findAll();
	}

	@Override
	public Employee findByEmployeeUuid(String employeeUuid) {

		Employee employee = employeeRepo.findByEmployeeUuid(employeeUuid);

		if (employee != null) {
			return employee;
		} else {
			throw new CustomException("Employee not found with uuid " + employeeUuid, ErrorMessages.NOT_FOUND);
		}
	}

	@Override
	public void deleteEmployee(Employee employee) {

		try {
			employeeRepo.delete(employee);
		} catch (Exception e) {
			throw new CustomException("Error while deleting employee", ErrorMessages.INTERNAL_SERVER_ERROR);
		}

	}
}
