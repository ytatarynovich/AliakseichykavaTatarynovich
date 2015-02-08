package com.epam.jmp.patterns;


import java.util.Date;

import com.epam.jmp.patterns.dao.*;
import com.epam.jmp.patterns.model.*;

public class Runner {

	public static void main(String[] args) {

		Dao dao = new BaseDao();

		Movie movie = new Movie("The best movie");

		int ticketsCount = 10;
		double price = 100;
		Date date = new Date();
		Ticket [] tickets = new Ticket[ticketsCount];

		for(int i = 0; i < ticketsCount; i++) {
			tickets[i] = new Ticket(movie, i + 1, price, date);
		}

		dao.persist(tickets);
	}

}
