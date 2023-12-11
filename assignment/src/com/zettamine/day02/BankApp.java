package com.zettamine.day02;

import java.util.Scanner;

public class BankApp {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account ac = null;
		while(true) {
		System.out.println("1. Create Account");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Details");
		System.out.println("5. Interest");
		System.out.println("6. Service Charges");
		System.out.println("7. Exit");
		
		System.out.print("enter an option: ");
		int opt = sc.nextInt();
		
		switch(opt) {
		case 1:
			if(ac != null) {
				System.out.println("Account is already opened with us..");
			}else {
				System.out.println("1. Savings Account");
				System.out.println("2. Current Account");
				System.out.print("enter an option: ");
				int accType = sc.nextInt();
				System.out.print("Enter account number: ");
				long acNum = sc.nextLong();
				System.out.print("enter name: ");
				String name = sc.next();
				System.out.print("enter initial deposite: ");
				double amount = sc.nextDouble();
				if(accType == 1) {
					System.out.print("enter rate of interest: ");
					int roi = sc.nextInt();
					ac = new SavingsAccount(acNum,name,amount,roi);
					System.out.println("### Welcome to our Bank ###");
				}
				else if(accType == 2) {
					ac = new CurrentAccount(acNum,name,amount);
					System.out.println("### Welcome to our Bank ###");
				}else {
					System.out.println("Invalid input");
				}
				
				
			}
			break;
		case 2:
			if(ac != null) {
				System.out.print("enter amount to deposite: ");
				double amt = sc.nextDouble();
				ac.deposit(amt);
				System.out.println("Total amount: " + ac.getAmount());
			}else {
				System.out.println("Please open an account with us...");
			}
			break;
		case 3:
			if(ac != null) {
				System.out.print("enter amount to withdraw: ");
				double amt = sc.nextDouble();
				ac.withdraw(amt);
				System.out.println("Total amount: " + ac.getAmount());
			}else {
				System.out.println("Please open an account with us...");
			}
			break;
		case 4:
			if(ac != null) {
				System.out.println("A/C NO: " + ac.getAccountNumber() + " | NAME: " + ac.getAccounterName() +
						 " | BALANCE: " + ac.getBalance());
			}else {
				System.out.println("Please open an account with us...");
			}
			break;
		case 5:
			if(ac == null) {
				System.out.println("Please open an account with us...");
			} else {
				if(ac instanceof SavingsAccount) {
					System.out.println("Interest is: " + ((SavingsAccount)ac).calculateInterest());
				}else {
					System.out.println("This account does not support this service.");
				}
			}
			break;
		case 6:
			if(ac == null) {
				System.out.println("Please open an account with us...");
			} else {
				if(ac instanceof CurrentAccount) {
					System.out.println("Service charge is: " + ((CurrentAccount)ac).serviceCharges());
				}else {
					System.out.println("This account does not support this service.");
				}
			}
			break;
		case 7:
			System.out.println("BYE BYE ");
			System.exit(0);
			break;
		default:
			System.err.println("enter valid option");
			break;
		
		}
		
		
	}
		//sc.close();
	}

}
