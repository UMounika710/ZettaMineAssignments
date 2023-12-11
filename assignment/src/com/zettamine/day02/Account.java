package com.zettamine.day02;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Account {
	private long accountNumber;
	private String accounterName;
	private double amount;
	
	
	public double deposit(double amt) {
		if(amt < 0) {
			System.err.println("Invalid amount, can't deposit!!!!");
		}else {
			this.amount += amt;
		}
		return this.amount;
	}
	
	public double withdraw(double amt) {
	if(this.amount < amt) {
		System.err.println("Error-------> Insufficient balance");
	}else {
		this.amount -= amt; 
	}
	return amount;
	}
	
	public double getBalance() {
		return this.amount;
		
	}

	public Account(long accountNumber, String accounterName, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.accounterName = accounterName;
		this.amount = amount;
	}

}
