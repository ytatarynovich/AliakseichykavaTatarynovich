package com.epam.jmp.concurrency.euler92;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author Hanna_Aliakseichykava
 */
public class IntervalUtil {

	private static final Logger log = Logger.getLogger(IntervalUtil.class);

	public static List<int[]> getIntervals(int min, int max, int count) {

		int intervalSize = (max - min) / count;
		List<int[]> intervals = new ArrayList<int[]>();

		int start = min;
		for(int i = 1; i <= count; i++) {
			int end;
			if(i == count) {
				end = max;
			} else {
				end = start + intervalSize;
			}
			intervals.add(new int[] {start, end});
			log.info("Interval: [" + start + ", " + end + "]");
			start = end + 1;
		}
		return intervals;
	}

}
