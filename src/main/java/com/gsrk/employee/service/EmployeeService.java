package com.gsrk.employee.service;

import java.util.List;

import com.gsrk.employee.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> findAll();
}
