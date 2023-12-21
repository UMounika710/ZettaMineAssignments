package com.zettamine.ems.services;

import java.util.List;

import com.zettamine.ems.dto.Employee;

public interface EmployeeService {

	void saveEmployee(Employee emp);

	void findEmployeeById(Integer id, Employee emp);

	void updateEmployeeById(Integer id, Employee emp);

	void deleteById(Integer id);

	void findAllEmployees(Employee emp);

}
