package com.epam.jmp.patterns.tx.cinema;

import com.epam.jmp.patterns.model.cinema.Ticket;
import com.epam.jmp.patterns.tx.Transaction;

public class UpdateTicketTx extends Transaction {

	private double newPrice;

	public UpdateTicketTx(Ticket ticket, double newPrice) {
		super(ticket);
		this.newPrice = newPrice;
	}

	@Override
	protected void executeTx() {
		((Ticket)getWorkEntity()).setPrice(newPrice);
	}
}
