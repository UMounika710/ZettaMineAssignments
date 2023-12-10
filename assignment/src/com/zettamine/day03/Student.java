package com.zettamine.day03;

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
		
	public Student() {
		super();
	}

	public Student(int studentId, String name, int departmentId, String gender, String phone) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.departmentId = departmentId;
		this.gender = gender;
		this.phone = phone;
	}
	
	
 

}
