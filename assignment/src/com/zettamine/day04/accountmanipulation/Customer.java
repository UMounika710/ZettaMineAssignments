package com.zettamine.day04.accountmanipulation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
	private int customerId;
    private String customerName;
    private String emailId;
    
	public Customer(int customerId, String customerName, String emailId) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.emailId = emailId;
	}

    

}
