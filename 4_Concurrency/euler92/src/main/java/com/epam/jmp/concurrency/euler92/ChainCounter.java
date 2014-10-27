package com.epam.jmp.concurrency.euler92;

import java.util.concurrent.Callable;

public class ChainCounter implements Callable<Integer> {

	private int minStartNumber;
	private int maxStartNumber;
	private int desiredEndNumber;
	
	public ChainCounter(int minStartNumber, int maxStartNumber, int desiredEndNumber) {
		this.minStartNumber = minStartNumber;
		this.maxStartNumber = maxStartNumber;
		this.desiredEndNumber = desiredEndNumber;
	}

	@Override
	public Integer call() {
		return ChainCounterUtil.countChains(minStartNumber, maxStartNumber, desiredEndNumber);
	}
}
