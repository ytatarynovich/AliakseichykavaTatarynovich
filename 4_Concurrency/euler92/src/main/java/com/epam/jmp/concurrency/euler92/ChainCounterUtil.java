package com.epam.jmp.concurrency.euler92;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

/**
 * @author Hanna_Aliakseichykava
 */
public class ChainCounterUtil {

	private static final Logger log = Logger.getLogger(ChainCounterUtil.class);

	private static final int CYCLIC_NUM_1 = 1;
	private static final int CYCLIC_NUM_2 = 89;

	private static Set<Integer> leadsToCycle1 = Collections.synchronizedSet(new HashSet<Integer>());
	private static Set<Integer> leadsToCycle2 = Collections.synchronizedSet(new HashSet<Integer>());

	public static int countChains(int minStartNumber, int maxStartNumber, int expectedEndNumber) {

		int counter = 0;
		for(int i = minStartNumber; i <= maxStartNumber; i++) {
			int endNumber = getEndChainNumber(i);
			if(endNumber == expectedEndNumber) {
				counter++;
			}
		}
		log.info("------------------------------");
		log.info("Thread [" + Thread.currentThread().getName() + "])");
		log.info("Count of chains, end with " + expectedEndNumber + 
				" in [" + minStartNumber + ", " + maxStartNumber + "] - " + counter);

		return counter;
	}

	public static int getEndChainNumber(int startNumber) {

		int nextNumber = startNumber;

		List<Integer> seenBefore = new ArrayList<Integer>();
		seenBefore.add(nextNumber);

		while((nextNumber != CYCLIC_NUM_1) && (nextNumber != CYCLIC_NUM_2)){

			nextNumber = getDigitsSquare(nextNumber);

			if(leadsToCycle1.contains(nextNumber)) {
				return CYCLIC_NUM_1;
			} 

			if(leadsToCycle2.contains(nextNumber)) {
				return CYCLIC_NUM_2;
			}

			seenBefore.add(nextNumber);
		}

		if(nextNumber == CYCLIC_NUM_1) {
			leadsToCycle1.addAll(seenBefore);
		} else if(nextNumber == CYCLIC_NUM_2) {
			leadsToCycle2.addAll(seenBefore);
		}

		printChain(seenBefore);
		return nextNumber;
	}

	public static int getDigitsSquare(int number) {

		List<Integer> digits = new ArrayList<Integer>();
		String strNumber = String.valueOf(number);
		for(int i = 0; i < strNumber.length(); i++) {
			int digit = Integer.valueOf(strNumber.substring(i, i + 1));
			digits.add(digit);
		}

		int digitsSquare = 0;
		for(int digit : digits) {
			digitsSquare += Math.pow(digit, 2);
		}

		return digitsSquare;
	}

	public static void printChain(List<Integer> numbers) {
		String chain = "";
		for(int number : numbers) {
			if(chain != "") {
				chain += " -> " + number;
			} else {
				chain += number;
			}
		}
		log.info("# " + chain + " #");
	}

}
