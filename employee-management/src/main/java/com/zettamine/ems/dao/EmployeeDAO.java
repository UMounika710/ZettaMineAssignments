package com.zettamine.ems.dao;

import java.util.List;

import com.zettamine.ems.dto.Employee;

public interface EmployeeDAO {
	
	Integer saveEmployee(Employee emp);
	
	Employee findById(Integer id, Employee emp);
	
	Integer updateEmployee(Integer id, Employee emp);
	
	Integer deleteById(Integer id);
	
	List<Employee> findAll(Employee emp);
	
	Boolean isEmployeeExist(Integer id);
	
}
