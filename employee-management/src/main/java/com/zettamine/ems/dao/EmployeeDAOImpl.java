package com.zettamine.ems.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zettamine.ems.configs.ConnectionFactory;
import com.zettamine.ems.dto.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Statement st = null;
	

	public EmployeeDAOImpl() {
		super();
		try {
			Connection con = ConnectionFactory.getDBConnection();
			st = con.createStatement();
		} catch (Exception e) {
			System.err.println("Connection to Database failed");
		}
	}

	@Override
	public Integer saveEmployee(Employee emp) {
		Integer rows = null;
		String sql = "insert into emp values("+emp.getEmpNo() + ",'" + emp.getEmpName() + "',"
				+ emp.getEmpSal() + ")";
		try {
			 rows = st.executeUpdate(sql);
		} catch (SQLException e) {
		}
		return rows;
	}

	@Override
	public Employee findById(Integer id, Employee emp) {
		String sql = "select * from emp where empno = " + id;
		try {
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
				emp = new Employee(rs.getInt(1),rs.getString(2),rs.getFloat(3));
			else
				emp = null;
				
		} catch (SQLException e) {
		}
		return emp;
	}

	@Override
	public Integer updateEmployee(Integer id, Employee emp) {
		Integer rowsAffected = 0;
		String sql = "update emp set ename=" + "'"+emp.getEmpName()+"',sal="+emp.getEmpSal()+"where empno="
				+ id;
		try {
			rowsAffected = st.executeUpdate(sql);
		} catch (SQLException e) {
		}
		return rowsAffected;
	}

	@Override
	public Integer deleteById(Integer id) {
		Integer rowsDeleted = 0;
		String sql = "delete from emp where empno=" + id;
		try {
			rowsDeleted = st.executeUpdate(sql);
		} catch (SQLException e) {
		}
		return rowsDeleted;
	}

	@Override
	public List<Employee> findAll(Employee emp) {
		List<Employee> emps = new ArrayList<>();
		String sql = "select * from emp";
		try {
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				float empSal = rs.getFloat(3);
				emp = new Employee(empId,empName,empSal);
				emps.add(emp);
			}
		} catch (SQLException e) {
		}
		
		return emps;
	}

	@Override
	public Boolean isEmployeeExist(Integer id) {
		String sql = "select empno from emp where empno = " + id;
		try {
			ResultSet rs = st.executeQuery(sql);
			if(rs!=null)
				return true;
		} catch (SQLException e) {
			
		}
		return false;
	}

}
