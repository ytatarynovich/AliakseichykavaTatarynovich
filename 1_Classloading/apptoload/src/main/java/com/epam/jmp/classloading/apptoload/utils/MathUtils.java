package com.epam.jmp.classloading.apptoload.utils;

import java.util.Random;

/**
 * @author Hanna_Aliakseichykava
 */
public class MathUtils {

	private static final Random randomizer = new Random();

	public static int getRandomNumber(int maxNumber) {

		return randomizer.nextInt(maxNumber);
	}

}
