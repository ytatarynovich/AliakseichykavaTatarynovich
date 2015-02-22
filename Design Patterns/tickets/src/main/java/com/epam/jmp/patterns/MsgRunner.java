package com.epam.jmp.patterns;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.epam.jmp.patterns.model.cinema.Movie;
import com.epam.jmp.patterns.model.cinema.Ticket;
import com.epam.jmp.patterns.msg.Consumer;
import com.epam.jmp.patterns.msg.ChannelAdapter;
import com.epam.jmp.patterns.msg.model.TicketMsg;

public class MsgRunner {

	public static void main(String[] args) {
		// Creating shared object
		BlockingQueue<TicketMsg> sharedQueue = new LinkedBlockingQueue<TicketMsg>();
		List<Ticket> tickets = createTickets();

		// Creating Producer and Consumer Thread
		Thread prodThread = new Thread(new ChannelAdapter(tickets, sharedQueue));
		Thread consThread = new Thread(new Consumer(tickets, sharedQueue));

		// Starting producer and Consumer thread
		prodThread.start();
		consThread.start();
	}

	private static List<Ticket> createTickets() {
		//create model objects
		String originalMovieName = "The best movie";
		Movie movie = new Movie(originalMovieName);

		int ticketsCount = 10;
		double initialPrice = 1000;
		Date date = new Date();
		List<Ticket> tickets = new ArrayList<Ticket>();

		for(int i = 0; i < ticketsCount; i++) {
			tickets.add(new Ticket(movie.getId(), i + 1, initialPrice + i * 10, date));
		}

		return tickets;
	}

}
