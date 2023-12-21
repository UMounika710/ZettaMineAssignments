package com.zettamine.ems;

import java.util.Scanner;

import com.zettamine.ems.dto.Employee;
import com.zettamine.ems.services.EmployeeSarviceImpl;
import com.zettamine.ems.services.EmployeeService;

public class EMSLauncher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee emp = null;
		EmployeeService empService = new EmployeeSarviceImpl();
		boolean flag = true;
		while(flag) {
			System.out.println("1.Save Employee");
			System.out.println("2.Search Employee By Id");
			System.out.println("3.Update Employee");
			System.out.println("4.Delete Employee By Id");
			System.out.println("5.Find All Employees");
			System.out.println("6.Exit");
			
			System.out.println();
			System.out.print("enter an option: ");
			int opt = sc.nextInt();
			
			switch(opt) {
			
			case 1:
				System.out.print("enter employee number: ");
				int empNum = sc.nextInt();
				sc.nextLine();
				System.out.print("enter employee name: ");
				String empName = sc.nextLine();
				System.out.print("enter employee slary: ");
				float empSal = sc.nextFloat();
				emp = new Employee(empNum,empName,empSal);
				empService.saveEmployee(emp);
				
				break;
				
			case 2:
				System.out.print("enter employee number to search: ");
				int empId = sc.nextInt();
				empService.findEmployeeById(empId, emp);
				break;
				
			case 3:
				System.out.print("enter employee number to be updated: ");
				int empNo = sc.nextInt();
				sc.nextLine();
				System.out.print("enter employee name: ");
				String newEmpName = sc.nextLine();
				System.out.print("enter employee slary: ");
				float newEmpSal = sc.nextFloat();
				emp = new Employee(empNo,newEmpName,newEmpSal);
				empService.updateEmployeeById(empNo, emp);
				break;
				
			case 4:
				System.out.print("enter employee number to be deleted: ");
				int num = sc.nextInt();
				empService.deleteById(num);
				break;
				
			case 5:
				empService.findAllEmployees(emp);
				break;
				
			case 6:
				flag = false;
				System.out.println("Thank you !!!");
				//sc.close();
				System.exit(0);
				break;
				
			default:
				System.err.println("Invalid input..... please try again");
				break;
			
			} //switch
			
		} // while
		sc.close();
		

	}

}
