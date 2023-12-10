package com.zettamine.day2;

public class SavingsAccount extends Account{
	private int roi;
	
	public SavingsAccount(long accountNumber, String accounterName, double amount, int roi) {
		super(accountNumber, accounterName, amount);
		this.roi = roi;
	}
	
	public double calculateInterest() {
		return (this.getAmount()*12*roi)/100;
	}
	
	

}
