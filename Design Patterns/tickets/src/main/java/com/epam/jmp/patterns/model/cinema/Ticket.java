package com.epam.jmp.patterns.model.cinema;

import java.io.Serializable;
import java.util.Date;

import com.epam.jmp.patterns.model.Entity;

public class Ticket extends Entity implements Serializable {

	private long movieId;
	private int place;
	private double price;
	private Date date;

	public Ticket(long movieId, int place, double price, Date date) {
		super();
		validate(price);
		this.movieId = movieId;
		this.place = place;
		this.price = price;
		this.date = date;
	}

	private Ticket(long id, long movieId, int place, double price, Date date) {
		this(movieId, place, price, date);
		this.setId(id);
	}

	@Override
	public String toString() {
		return "Ticket: id: " + getId() + "\n Movie id: \n" + movieId + "\n Place: " + place + 
				"\n Date: " + date + "\n Price: " + price;
	}

	@Override
	public Ticket copy() {
		return new Ticket(this.getId(), this.movieId, this.place, this.price, this.date);
	}

	@Override
	public void populate(Entity entity) {
		Ticket ticket = (Ticket) entity;
		setId(ticket.getId());
		this.movieId = ticket.getMovieId();
		this.place = ticket.getPlace();
		this.price = ticket.getPrice();
		this.date = ticket.getDate();
	}

	public long getMovieId() {
		return movieId;
	}

	public int getPlace() {
		return place;
	}

	public double getPrice() {
		return price;
	}

	public Date getDate() {
		return date;
	}

	public void setPrice(double price) {
		validate(price);
		this.price = price;
	}

	public static double MIN_PRICE = 1000D;
	public static double MAX_PRICE = 100000D;

	private void validate(double price) {
		if(price < MIN_PRICE || price > MAX_PRICE) {
			throw new RuntimeException("New price is not correct: " + price);
		}
	}
}
