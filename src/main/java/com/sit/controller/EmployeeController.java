package com.sit.controller;

import static com.sit.constant.UrlConstant.BASE_URL;
import static com.sit.constant.UrlConstant.EMPLOYEES;
import static com.sit.constant.UrlConstant.SINGLE_EMPLOYEE;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sit.constant.Role;
import com.sit.dto.EmployeeDto;
import com.sit.entity.Employee;
import com.sit.service.EmployeeService;
import com.sit.util.ResponseMaker;
import com.sit.util.SuccessResponse;

@RestController
@RequestMapping(BASE_URL)
public class EmployeeController {

	@Autowired
	private ResponseMaker responseMaker;

	@Autowired
	private EmployeeService employeeService;


	@PostMapping(EMPLOYEES)
	@PreAuthorize(Role.MANAGER)
	public ResponseEntity<SuccessResponse<Employee>> saveEmployee(@RequestBody @Valid EmployeeDto employeeDto) {

		Employee employee = employeeService.saveEmployee(employeeDto);

		return responseMaker.successResponse(employee, HttpStatus.CREATED);
	}

	@GetMapping(EMPLOYEES)
	public ResponseEntity<SuccessResponse<List<Employee>>> allEmployees() {

		List<Employee> employees = employeeService.allEmployees();

		return responseMaker.successResponse(employees, HttpStatus.OK);
	}

	@GetMapping(SINGLE_EMPLOYEE)
	@PreAuthorize(Role.MANAGER)
	public ResponseEntity<SuccessResponse<Employee>> updateEmployee(@PathVariable String employeeUuid) {

		Employee employee = employeeService.employeeByUuid(employeeUuid);

		return responseMaker.successResponse(employee, HttpStatus.OK);
	}

	@PutMapping(SINGLE_EMPLOYEE)
	@PreAuthorize(Role.MANAGER)
	public ResponseEntity<SuccessResponse<Employee>> updateEmployee(@PathVariable String employeeUuid,
			@RequestBody @Valid EmployeeDto employeeDto) {

		Employee employee = employeeService.updateEmployee(employeeUuid, employeeDto);

		return responseMaker.successResponse(employee, HttpStatus.OK);
	}

	@DeleteMapping(SINGLE_EMPLOYEE)
	@PreAuthorize(Role.MANAGER)
	public ResponseEntity<SuccessResponse<String>> deleteEmployee(@PathVariable String employeeUuid) {

		employeeService.deleteEmployee(employeeUuid);

		return responseMaker.successResponse("Employee deleted successfully", HttpStatus.OK);
	}
}
