package com.epam.jmp.patterns.tx;

import java.util.List;

import com.epam.jmp.patterns.model.Status;

public abstract class CompositeTransaction extends Transaction {

	private List<Transaction> subTransactions;

	public CompositeTransaction(List<Transaction> subTransactions) {
		this.subTransactions = subTransactions;
	}

	@Override
	public void abort() {
		for(Transaction tx : subTransactions) {
			tx.abort();
		}
	}

	@Override
	protected boolean isSuccessful() {
		boolean isSuccessful = true;
		for(Transaction tx : subTransactions) {
			isSuccessful = isSuccessful && tx.isSuccessful();
		}
		return isSuccessful;
	}

	@Override
	public void commit() {
		for(Transaction tx : subTransactions) {
			tx.commit();
		}
	}

	public void begin() {
		try {
			for(Transaction tx : subTransactions) {
				tx.begin();
			}
			if(isSuccessful()) {
				setStatus(Status.SUCCESS);
			} else {
				setStatus(Status.FAIL);
			}
		}
		catch(Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			setStatus(Status.FAIL);
		}
	}
}
