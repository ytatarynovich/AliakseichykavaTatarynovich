package com.epam.jmp.patterns.tx.cinema;

import com.epam.jmp.patterns.model.cinema.Movie;
import com.epam.jmp.patterns.tx.Transaction;

public class UpdateMovieTr extends Transaction {

	private String newName;

	public UpdateMovieTr(Movie movie, String newName) {
		super(movie);
		this.newName = newName;
	}

	@Override
	protected void executeTx() {
		((Movie)getWorkEntity()).setName(newName);
	}

}
