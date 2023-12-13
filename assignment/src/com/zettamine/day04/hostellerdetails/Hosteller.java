package com.zettamine.day04.hostellerdetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hosteller {
	private String hostelName;
	private int roomNumber;
	
	public Hosteller(String hostelName, int roomNumber) {
		super();
		this.hostelName = hostelName;
		this.roomNumber = roomNumber;
	}

}
