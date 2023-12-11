package com.zettamine.day02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Ticket {
	private int ticketId;
	private int price;
	private static int availableTickets;
	
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public static void setAvailableTickets(int availableTickets) {
		if(availableTickets>0) {
		Ticket.availableTickets = availableTickets;
		}
	}
	
	public static int getAvailableTickets() {
		return availableTickets;
	}
	
	public int calculateTicketCost(int noOfTickets) {
		int amount;
		if(Ticket.getAvailableTickets() >= noOfTickets) {
			Ticket.setAvailableTickets(Ticket.getAvailableTickets()-noOfTickets);
			amount = noOfTickets*price;
			return amount;
		}
		return -1;
	}

	
	
	

	

	

}


