package com.epam.jmp.classloading.apptoload;

/**
 * @author Hanna_Aliakseichykava
 */
public class Runner {

	private static final int MAX_NUMBER = 1000;

	public static void main(String[] args) {

		new MenuHandler(MAX_NUMBER).start();
	}

}
