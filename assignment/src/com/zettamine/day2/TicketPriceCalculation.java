 package com.zettamine.day2;

import java.util.Scanner;

public class TicketPriceCalculation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no of bookings: ");
		int noOfBookings = sc.nextInt();
		System.out.print("Enter the available tickets: ");
		Ticket.setAvailableTickets(sc.nextInt());
		while (noOfBookings > 0) {
			System.out.print("Enter the ticketid: ");
			int ticketId = sc.nextInt();
			System.out.print("Enter the price: ");
			int price = sc.nextInt();
			System.out.print("Enter the no of tickets: ");
			int noOfTickets = sc.nextInt();

			Ticket ticket = new Ticket(ticketId, price);
			System.out.println("Available tickets: " + ticket.getAvailableTickets());
			System.out.println("Total amount: " + ticket.calculateTicketCost(noOfTickets));
			System.out.println("Available tickets after booking: " + ticket.getAvailableTickets());
			noOfBookings--;

		}
		sc.close();

	}

	
	
	

}
