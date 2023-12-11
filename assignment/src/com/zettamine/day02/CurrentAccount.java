package com.zettamine.day02;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrentAccount extends Account{
	private final int TRANSACTION_LIMIT = 5;
	private static int transactioncount;
	
	public CurrentAccount(long accountNumber, String accounterName, double amount) {
		super(accountNumber, accounterName, amount);
	}
	
	@Override
	public double deposit(double amt) {
		transactioncount++;
		return super.deposit(amt);
		
	}
	
	@Override
	public double withdraw(double amt) {
		transactioncount++;
		return super.withdraw(amt);
		
	}
	
	@Override
	public double getBalance() {
		transactioncount++;
		return super.getBalance();
		
	}
	
	public double serviceCharges() {
		if(transactioncount > TRANSACTION_LIMIT) {
			double charge = (transactioncount - TRANSACTION_LIMIT) * 100;
			setAmount(getAmount() - charge);
			System.out.println("Remaining balance: " + getAmount());
			return charge;
		}
		return 0;
	}

}
