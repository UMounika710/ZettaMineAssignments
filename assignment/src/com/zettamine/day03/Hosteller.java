package com.zettamine.day03;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hosteller extends Student {
	private String hostelName;
	private int roomNumber;

	public Hosteller(int studentId, String name, int departmentId, String gender, String phone,String hostelName, int roomNumber) {
		super(studentId, name, departmentId, gender, phone);
		this.hostelName = hostelName;
		this.roomNumber = roomNumber;
	}

}
