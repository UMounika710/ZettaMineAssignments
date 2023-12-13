package com.zettamine.day04.accountmanipulation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavingsAccount extends Account {
	private double minimumBalance;

	public SavingsAccount(int accountNumber, Customer customerObj, double balance, double minimumBalance) {
		super(accountNumber, customerObj, balance);
		this.minimumBalance = minimumBalance;
	}

	@Override
	public boolean withdraw(double amount) {
		if(balance> minimumBalance) {
			if(balance > amount) {
			balance -= amount;
			return true;
			}
		}
		return false;
	}
	
	
	
	

}
