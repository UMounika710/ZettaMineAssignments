package com.zettamine.day02;

import java.util.Scanner;

public class Loan {

	public static void main(String[] args) {
		
		Employee perEmp = new PermanentEmployee(101, "Sanjay", 60000);
		Employee tempEmp = new TemporaryEmployee(102, "Vijay", 40, 100);
		
		System.out.println("Loan amount : " + calculateLoanAmount(perEmp));

	}
	
	public static double calculateLoanAmount(Employee emp) {
		double loan = 0;
		
		if(emp instanceof PermanentEmployee) {
			emp.calculateSalary();
			loan = emp.getSalary()*0.15;
		}
		if(emp instanceof TemporaryEmployee) {
			emp.calculateSalary();
			loan = emp.getSalary()*0.10;
		}
		return loan;
	}

}
