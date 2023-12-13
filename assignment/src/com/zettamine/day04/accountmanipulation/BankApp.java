package com.zettamine.day04.accountmanipulation;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("enter A/C number: ");
		int acNum = sc.nextInt();
		
		System.out.print("enter customer id: ");
		int custId = sc.nextInt();
		
		System.out.print("enter customer name: ");
		String custName = sc.next();
		
		System.out.print("enter customer email: ");
		String custEmail = sc.next();
		sc.nextLine();
		System.out.print("enter balance: ");
		double balance = sc.nextDouble();
		
		System.out.print("enter minimum balance: ");
		double minBalance = sc.nextDouble();
		
		System.out.print("enter amount to withdraw: ");
		double amount = sc.nextDouble();
		sc.close();
		
		Customer customer = new Customer(custId,custName,custEmail);
		Account ac = new SavingsAccount(acNum, customer, balance, minBalance);
		if(ac.withdraw(amount)) {
			System.out.printf("RS. %.2f debited | Balance: %.2f",amount, ac.getBalance());
		}else {
			System.err.println("Balance is less than minimum balance or insufficient balance");
		}
		

	}

}

/*
 * Rs. 5000.00 debited | Balance:  20000.00
 enter A/C number: 123456
enter customer id: 9010
enter customer name: Pankaj Kumar
enter customer email: pankaj@gmail.com
enter balance: 25000
enter minimum balance: 1000

enter amount to withdraw: 5000
*/
