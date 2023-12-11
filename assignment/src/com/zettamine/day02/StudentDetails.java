package com.zettamine.day02;

import java.util.Scanner;

public class StudentDetails {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Student's Id: ");
		int studentId = sc.nextInt();
		
		System.out.print("Enter Student's Name: ");
		String studentName = sc.next();
		
		System.out.print("Enter Student's address: ");
		String address = sc.next();
		
		System.out.print("Whether the student is from NIT(Yes/No): ");
		String nit = sc.next();
		Student student = null;
		
		if(nit.equalsIgnoreCase("YES")) {
			student = new Student(studentId,studentName,address);
			student.setCollegeName("NIT");
		}else if(nit.equalsIgnoreCase("No")) {
			System.out.print("Enter the college name: ");
			String collegeName = sc.next();
			student = new Student(studentId,studentName,address,collegeName);
		}else {
			System.err.println("Wrong Input");
		}
		
		
		System.out.println("Student id: " + student.getStudentId());
		System.out.println("Student name: " + student.getStudentName());
		System.out.println("Address: " + student.getStudentAddress());
		System.out.println("College name: " + student.getCollegeName());
		
		sc.close();
	}

}


