package com.epam.jmp.patterns.tx.cinema;

import com.epam.jmp.patterns.model.cinema.Ticket;
import com.epam.jmp.patterns.tx.Transaction;

public class UpdateTicketTx extends Transaction {

	private int newPlace;

	public UpdateTicketTx(Ticket ticket, int newPlace) {
		super(ticket);
		this.newPlace = newPlace;
	}

	@Override
	protected void executeTx() {
		((Ticket)getWorkEntity()).setPlace(newPlace);
	}
}
