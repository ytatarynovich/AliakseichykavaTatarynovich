package com.epam.jmp.concurrency.utils;

/**
 * @author Hanna_Aliakseichykava
 */
public class RandomUtil {

	public static double getRandomDouble(int min, int max) {
		return Math.random() * (max - min) + min;
	}
}
