package com.epam.jmp.patterns;

import java.util.Arrays;
import java.util.Date;

import com.epam.jmp.patterns.model.Status;
import com.epam.jmp.patterns.model.cinema.*;
import com.epam.jmp.patterns.tx.*;
import com.epam.jmp.patterns.tx.cinema.*;

public class Runner {

	public static void main(String[] args) {

		//create model objects
		String originalMovieName = "The best movie";
		Movie movie = new Movie(originalMovieName);

		int ticketsCount = 10;
		double initialPrice = 1000;
		Date date = new Date();
		Ticket [] tickets = new Ticket[ticketsCount];

		for(int i = 0; i < ticketsCount; i++) {
			tickets[i] = new Ticket(movie.getId(), i + 1, initialPrice, date);
		}

		//create and execute simple transactions

		//movie
		String newMovieNameValid = "New movie name";
		Transaction updMovieTxSuccess = new UpdateMovieTx(movie, newMovieNameValid);
		TxManager.perform(updMovieTxSuccess);
		assert(updMovieTxSuccess.getStatus() == Status.SUCCESS);
		assert(movie.getName().equals(newMovieNameValid));

		String newMovieNameInvalid = "New movie name 123456789";
		Transaction updMovieTxFail = new UpdateMovieTx(movie, newMovieNameInvalid);
		TxManager.perform(updMovieTxFail);
		assert(updMovieTxFail.getStatus() == Status.FAIL);
		assert(movie.getName().equals(newMovieNameValid));

		//tickets
		double newValidPrice = 10000;
		Ticket ticket1 = tickets[0];
		Transaction updTicketTxSuccess = new UpdateTicketTx(ticket1, newValidPrice);
		TxManager.perform(updTicketTxSuccess);
		assert(updTicketTxSuccess.getStatus() == Status.SUCCESS);
		assert(ticket1.getPrice() == newValidPrice);

		double newInvalidPrice = 1000000;
		Ticket ticket2 = tickets[1];
		Transaction updTicketTxFail = new UpdateTicketTx(ticket2, newInvalidPrice);
		TxManager.perform(updTicketTxFail);
		assert(updTicketTxFail.getStatus() == Status.FAIL);
		assert(ticket2.getPrice() == initialPrice);

		//create and execute composite transaction 1
		newMovieNameValid = "New movie name 2";
		updMovieTxSuccess = new UpdateMovieTx(movie, newMovieNameValid);

		newValidPrice = 20000;
		updTicketTxSuccess = new UpdateTicketTx(ticket1, newValidPrice);

		Transaction successCompositeTx = new CompositeTransaction(Arrays.asList(updMovieTxSuccess, updTicketTxSuccess));
		TxManager.perform(successCompositeTx);
		assert(successCompositeTx.getStatus() == Status.SUCCESS);
		//all transactions are commited
		assert(movie.getName().equals(newMovieNameValid));
		assert(ticket1.getPrice() == newValidPrice);

		//create and execute composite transaction 2
		newMovieNameValid = "New movie name 3";
		updMovieTxSuccess = new UpdateMovieTx(movie, newMovieNameValid);

		newValidPrice = 30000;
		updTicketTxSuccess = new UpdateTicketTx(ticket1, newValidPrice);

		newInvalidPrice = 2000000;
		updTicketTxFail = new UpdateTicketTx(ticket2, newInvalidPrice);

		Transaction failCompositeTx = new CompositeTransaction(Arrays.asList(updMovieTxSuccess, updTicketTxSuccess, updTicketTxFail));
		TxManager.perform(failCompositeTx);
		assert(failCompositeTx.getStatus() == Status.FAIL);
		//all transactiona are rolled back
		assert(!movie.getName().equals(newMovieNameValid));
		assert(!(ticket1.getPrice() == newValidPrice));
		assert(!(ticket2.getPrice() == newInvalidPrice));
	}


}
