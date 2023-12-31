package com.zm.bankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private String userId;
	private String password;
	private String userType;
	private Integer custId;
	private Integer adminId;
	
	public User(String userId,String password) {
		this.userId = userId;
		this.password = password;
	}
	

}
