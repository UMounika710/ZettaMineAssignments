package com.zm.bankapp.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
	private Integer custId;
	private String custName;
	private LocalDate dob;
	private String gender;
	private String mobile;
	private String email;
	private String aadhaarNo;
	private String address;
	
	public Customer(String custName, LocalDate dob, String gender, String mobile, String email, String aadhaarNo,
			String address) {
		this.custName = custName;
		this.dob = dob;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.aadhaarNo = aadhaarNo;
		this.address = address;
	}


}
