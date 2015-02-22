package com.epam.jmp.patterns.msg;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.epam.jmp.patterns.model.cinema.Ticket;
import com.epam.jmp.patterns.msg.model.TicketMsg;

public class ChannelAdapter implements Runnable {

	private final BlockingQueue<TicketMsg> sharedQueue;
	private final List<Ticket> tickets;

	public ChannelAdapter(List<Ticket> tickets, BlockingQueue<TicketMsg> sharedQueue) {
		this.tickets = tickets;
		this.sharedQueue = sharedQueue;
	}

	//@Override
	public void run() {

		int i = 0;
		try {
			for(Ticket ticket : tickets) {
				TicketMsg msg = new TicketMsg(ticket.getId(), ticket.getPrice() + 10);
				sharedQueue.put(msg);
				System.out.println("Produced [" + i++ + "]: " + msg);
			}
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
	}

}