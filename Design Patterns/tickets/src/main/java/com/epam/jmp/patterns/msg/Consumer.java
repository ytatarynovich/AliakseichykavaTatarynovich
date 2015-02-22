package com.epam.jmp.patterns.msg;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.epam.jmp.patterns.model.Status;
import com.epam.jmp.patterns.model.cinema.Ticket;
import com.epam.jmp.patterns.msg.model.TicketMsg;
import com.epam.jmp.patterns.tx.Transaction;
import com.epam.jmp.patterns.tx.TxManager;
import com.epam.jmp.patterns.tx.cinema.UpdateTicketTx;

public class Consumer implements Runnable {

	private final BlockingQueue<TicketMsg> sharedQueue;
	private final List<Ticket> tickets;

	public Consumer(List<Ticket> tickets, BlockingQueue<TicketMsg> sharedQueue) {
		this.tickets = tickets;
		this.sharedQueue = sharedQueue;
	}

	// @Override
	public void run() {
		while (true) {
			try {
				TicketMsg msg = sharedQueue.take();
				System.out.println("Consumed: " + msg);
				Ticket ticket = getTicket(msg.getId());
				Transaction ticketTx = new UpdateTicketTx(ticket, msg.getPrice());
				TxManager.perform(ticketTx);
				assert(ticketTx.getStatus() == Status.SUCCESS);
			} catch (InterruptedException ex) {
				System.out.println(ex);
			}
		}
	}

	private Ticket getTicket(Long id) {
		for(Ticket ticket : tickets) {
			if(ticket.getId() == id) {
				return ticket;
			}
		}
		throw new RuntimeException("Ticket [" + id + "] is not found");
	}

}