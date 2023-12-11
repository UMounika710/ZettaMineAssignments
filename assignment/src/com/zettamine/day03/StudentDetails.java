package com.zettamine.day03;

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
		
		System.out.print("Phone Number: ");
		String phone = sc.next();
		
		System.out.print("Hostel Name: ");
		String hostelName = sc.next();
		
		System.out.print("Room Number: ");
		int roomNum = sc.nextInt();
		
		System.out.print("Modify Room Number(Y/N): ");
		String modifyRoom = sc.next();
		
		System.out.print("Modify Phone Number(Y/N): ");
		String modifyPhone = sc.next();
		
		//Hosteller hosteller = new Hosteller(studentId,studentName,departmentId,gender,phone,hostelName,roomNum);
		Student student = new Hosteller(studentId,studentName,departmentId,gender,phone,hostelName,roomNum);
		
		getHostellerDetails(student, modifyRoom, modifyPhone);
		
		System.out.printf("The Student Details are as follows:");
		System.out.println();
		System.out.println("Student ID: " + student.getStudentId());
		System.out.println("Student Name: "  + student.getName());
		System.out.println("Department ID: "  + student.getDepartmentId());
		System.out.println("Student Gender: "  + student.getGender()); 
		System.out.println("Student Phone No: "  + student.getPhone()); 
		System.out.println("Hostel Name: "  + ((Hosteller)student).getHostelName());    
		System.out.println("Room No: "  + ((Hosteller)student).getRoomNumber());
		
		sc.close();

	}
	public static Hosteller getHostellerDetails(Student student, String modifyRoom, String modifyPhone) {
		if(modifyRoom.equalsIgnoreCase("Y")) {
			System.out.print("New Room Number: ");
			int newRoom = sc.nextInt();
			((Hosteller)student).setRoomNumber(newRoom);
		}
		if(modifyPhone.equalsIgnoreCase("Y")) {
			System.out.print("New Phone Number: ");
			String newPhone = sc.next();
			((Hosteller)student).setPhone(newPhone);
		}
		return (Hosteller)student;
	}

}


