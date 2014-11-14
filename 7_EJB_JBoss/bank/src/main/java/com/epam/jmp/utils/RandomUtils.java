package com.epam.jmp.utils;

/**
 * @author Hanna_Aliakseichykava
 */
public class RandomUtils {

	public static double getRandomDouble(int min, int max) {
		return Math.random() * (max - min) + min;
	}
}
