package com.zettamine.day04.accountmanipulation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Account {
	protected int accountNumber;
	protected Customer customerObj;   
	protected double balance;
	
	public Account(int accountNumber, Customer customerObj, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.customerObj = customerObj;
		this.balance = balance;
	}
	
	public abstract boolean withdraw(double amount);


}
