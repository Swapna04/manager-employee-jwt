package com.sit.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sit.dao.EmployeeDao;
import com.sit.dto.EmployeeDto;
import com.sit.entity.Employee;
import com.sit.exception.CustomException;
import com.sit.exception.ErrorMessages;
import com.sit.mapper.Mapper;
import com.sit.util.CustomGenerator;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private Mapper mapper;

	@Autowired
	private CustomGenerator generator;

	//Adds new employee
	@Override
	public Employee saveEmployee(EmployeeDto employeeDto) {

		if (employeeDao.isEmployeeExistsByMobile(employeeDto.getMobile())) {
			throw new CustomException("Employee with mobile number " + employeeDto.getMobile() + " already exist",
					ErrorMessages.USER_ALREADY_EXIST);
		}

		Employee employee = mapper.convert(employeeDto, Employee.class);

		employee.setEmployeeUuid(generator.generateUUID());

		return employeeDao.saveEmployee(employee);
	}

	//All employees details
	@Override
	public List<Employee> allEmployees() {

		return employeeDao.allEmployees();
	}

	//All employees details with uuid
	
	@Override
	public Employee employeeByUuid(String employeeUuid) {

		return employeeDao.findByEmployeeUuid(employeeUuid);
	}

	//Update employee details
	@Override
	public Employee updateEmployee(String employeeUuid, @Valid EmployeeDto employeeDto) {

		Employee oldEmployee = employeeDao.findByEmployeeUuid(employeeUuid);

		if (!oldEmployee.getMobile().equals(employeeDto.getMobile())
				&& employeeDao.isEmployeeExistsByMobile(employeeDto.getMobile())) {
			throw new CustomException("Employee with mobile number " + employeeDto.getMobile() + " already exist",
					ErrorMessages.USER_ALREADY_EXIST);
		}

		Employee updatedEmployee = mapper.convert(employeeDto, Employee.class);
		updatedEmployee.setEmployeeId(oldEmployee.getEmployeeId());
		updatedEmployee.setEmployeeUuid(employeeUuid);

		return employeeDao.saveEmployee(updatedEmployee);
	}

	//Delete employee
	@Override
	public void deleteEmployee(String employeeUuid) {
		Employee employee = employeeDao.findByEmployeeUuid(employeeUuid);

		employeeDao.deleteEmployee(employee);
	}

}
