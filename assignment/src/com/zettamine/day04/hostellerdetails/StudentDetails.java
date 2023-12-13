package com.zettamine.day04.hostellerdetails;

import java.util.Scanner;


public class StudentDetails {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		System.out.println("Enter the Student Details & Hostel Details:");
		System.out.print("Student ID: ");
		int studentId = sc.nextInt();
		
		System.out.print("Student Name: ");
		String studentName = sc.next();
		sc.nextLine();
		
		System.out.print("Department Id: ");
		int departmentId = sc.nextInt();
		
		System.out.print("Gender[M/F]: ");
		String gender = sc.next();
		if(!gender.matches("[MFmf]")) {
			System.err.println("Invalid input");
			System.exit(0);
		}
		
		System.out.print("Phone Number: ");
		String phone = sc.next();
		
		System.out.print("Hostel Name: ");
		String hostelName = sc.next();
		
		System.out.print("Room Number: ");
		int roomNum = sc.nextInt();
		
		Hosteller hosteller = new Hosteller(hostelName, roomNum);
		Student student = new Student(studentId,studentName,departmentId,gender,phone,hosteller);
		
		
		sc.close();

	}
	public static Hosteller getHostellerDetails(Student student, Hosteller hosteller) {
		if(student.getGender().equals("M")) {
			student.setGender("Male");
		}else if(student.getGender().equals("F")) {
			student.setGender("Female");
		}
		System.out.print("Modify Room Number(Y/N): ");
		String modifyRoom = sc.next();
		if(modifyRoom.equalsIgnoreCase("Y")) {
			System.out.print("New Room Number: ");
			int newRoom = sc.nextInt();
			student.getHosteller().setRoomNumber(newRoom);
		}
		System.out.print("Modify Phone Number(Y/N): ");
		String modifyPhone = sc.next();
		
		if(modifyPhone.equalsIgnoreCase("Y")) {
			System.out.print("New Phone Number: ");
			String newPhone = sc.next();
			student.setPhone(newPhone);
		}
		
		System.out.printf("The Student Details are as follows:");
		System.out.println();
		System.out.println("Student ID: " + student.getStudentId());
		System.out.println("Student Name: "  + student.getName());
		System.out.println("Department ID: "  + student.getDepartmentId());
		System.out.println("Student Gender: "  + student.getGender()); 
		System.out.println("Student Phone No: "  + student.getPhone()); 
		System.out.println("Hostel Name: "  + student.getHosteller().getHostelName());    
		System.out.println("Room No: "  + student.getHosteller().getRoomNumber());
		
		return hosteller;
	}
}


