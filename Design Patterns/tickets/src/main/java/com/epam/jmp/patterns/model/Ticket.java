package com.epam.jmp.patterns.model;

import java.io.Serializable;
import java.util.Date;

public class Ticket extends Entity implements Serializable {

	private Movie movie;
	private int place;
	private double price;
	private Date date;

	public Ticket(Movie movie, int place, double price, Date date) {
		super();
		this.movie = movie;
		this.place = place;
		this.price = price;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Ticket: \n" + movie + "\n Place: " + place + 
				"\n Date: " + date + "\n Price: " + price;
	}

}
