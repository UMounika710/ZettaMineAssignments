package com.zettamine.ems.services;

import java.util.List;

import com.zettamine.ems.dao.EmployeeDAO;
import com.zettamine.ems.dao.EmployeeDAOImpl;
import com.zettamine.ems.dto.Employee;

public class EmployeeSarviceImpl implements EmployeeService {
	private EmployeeDAO dao;
	
	

	public EmployeeSarviceImpl() {
		super();
		dao = new EmployeeDAOImpl();
		
	}

	@Override
	public void saveEmployee(Employee emp) {
		Integer row = dao.saveEmployee(emp);
		if(row > 0) {
			System.out.println("####---- Employee saved successfully ----####");
		}else {
			System.err.println("Unable to save employee");
		}

	}

	@Override
	public void findEmployeeById(Integer id, Employee emp) {
		emp = dao.findById(id, emp);
		if(emp != null)
			System.out.printf("%-5d | %-15s | %.2f",emp.getEmpNo(),emp.getEmpName(),emp.getEmpSal());
		else
			System.err.println("No matching employee found");

	}

	@Override
	public void updateEmployeeById(Integer id, Employee emp) {
		Integer rowsAffected = dao.updateEmployee(id, emp);
		if(rowsAffected > 0)
			System.out.println("Employee updated successfully");
		else
			System.err.println("no employee updated");

	}

	@Override
	public void deleteById(Integer id) {
		Integer rowsDeleted = dao.deleteById(id);
		if(rowsDeleted > 0) {
			System.out.printf("Employee with id:%d deleted successfully", id);
		}else {
			System.err.println("Employee deletion failed");
		}

	}

	@Override
	public void findAllEmployees(Employee emp) {
		List<Employee> emps = dao.findAll(emp);
		for(Employee employee : emps) {
			System.out.println(employee);
		}

	}

}
