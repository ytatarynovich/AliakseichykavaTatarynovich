package com.epam.jmp.patterns.tx;

import com.epam.jmp.patterns.model.Status;

public class TxManager {

	public static void perform(Transaction tx) {
		tx.begin();
		if(tx.getStatus() == Status.SUCCESS) {
			tx.commit();
		} else {
			tx.abort();
		}
	}
}
