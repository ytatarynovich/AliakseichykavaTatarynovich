package com.epam.jmp.concurrency.euler92;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

/**
 * @author Hanna_Aliakseichykava
 */
public class Runner {

	private static final int MAX_START_NUMBER = 10000000;
	private static final int END_NUMBER = 89;

	private static final Logger log = Logger.getLogger(Runner.class);

	public static void main(String[] args) throws InterruptedException {

		Date start = new Date();

		int processorsNumber = Runtime.getRuntime().availableProcessors();
		List<int[]> intervals = IntervalUtil.getIntervals(1, MAX_START_NUMBER, processorsNumber);

		ExecutorService executor = Executors.newFixedThreadPool(processorsNumber);
		List<Future<Integer>> futures = new ArrayList<Future<Integer>>();

		for (int[] interval : intervals) {

			int min = interval[0];
			int max = interval[1];

			Callable<Integer> callable = new ChainCounter(min, max, END_NUMBER);
			Future<Integer> future = executor.submit(callable);
			futures.add(future);
		}

		int counter = 0;
		for (Future<Integer> future : futures) {
			try {
				counter += future.get();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		log.info("General count: " + counter);

		executor.shutdown();

		log.info("Time: " + (double) ((new Date()).getTime() - start.getTime()) / 1000 + " s");
	}

}
