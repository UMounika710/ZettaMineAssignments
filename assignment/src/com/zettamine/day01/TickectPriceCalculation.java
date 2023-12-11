package com.zettamine.day01;

import java.util.Scanner;

public class TickectPriceCalculation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the no of ticket: ");
		int noOfTickets = sc.nextInt();
		if((noOfTickets < 5) || (noOfTickets > 40)) {
			System.err.println("Minimum of 5 and Maximum of 40 Tickets");
			System.exit(0);
		}
			System.out.print("Do you want refreshment: ");
			String refreshment  = sc.next();
		    System.out.print("Do you have coupon code: ");
		    String coupon  = sc.next();
		    System.out.print("Enter the circle: ");
		    String circle  = sc.next();
		    if(!(circle.equalsIgnoreCase("K")) && !(circle.equalsIgnoreCase("Q"))) {
		    	System.err.println("Invalid Input");
		    }
		
		System.out.printf("Ticket cost: %.2f", totalTicketPrice(noOfTickets, refreshment, coupon, circle));
		    sc.close();

	}
	public static double totalTicketPrice(int noOfTickets, String refreshment, String coupon, String circle) {
		double total=0;
		if(circle.equalsIgnoreCase("K")) {
			total = noOfTickets * 75;
		}
		if(circle.equalsIgnoreCase("Q")) {
			total = noOfTickets * 150;
		}
		if(noOfTickets > 20) {
			total = total - (total * 0.1);
		}
		if(coupon.equalsIgnoreCase("Y")) {
			total = total - (total * 0.02);
		}
		if(refreshment.equalsIgnoreCase("Y")) {
			total = total + (noOfTickets * 50);
		}
		return total;
	}

}
