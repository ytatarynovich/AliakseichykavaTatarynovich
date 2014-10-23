package com.epam.jmp.concurrency.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Hanna_Aliakseichykava
 */
public class ScannerUtil {

	public static String scanStr() {

		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

	public static int scanInt() {

		try {
			Scanner scanner = new Scanner(System.in);
			return scanner.nextInt();

		} catch (InputMismatchException e) {
			return -1;
		}
	}

	public static double scanDouble() {

		try {
			Scanner scanner = new Scanner(System.in);
			return scanner.nextDouble();

		} catch (InputMismatchException e) {
			return -1;
		}
	}

}
