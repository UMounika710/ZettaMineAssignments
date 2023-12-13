package com.zettamine.day04.hostellerdetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
	protected int studentId;
	protected String name;
	protected int departmentId;
	protected String gender;
	protected String phone;
	protected Hosteller hosteller;
	
	public Student(int studentId, String name, int departmentId, String gender, String phone, Hosteller hosteller) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.departmentId = departmentId;
		this.gender = gender;
		this.phone = phone;
		this.hosteller = hosteller;
	}
		
	


}
