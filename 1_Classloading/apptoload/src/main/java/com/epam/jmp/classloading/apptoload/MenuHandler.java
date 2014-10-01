package com.epam.jmp.classloading.apptoload;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.epam.jmp.classloading.apptoload.utils.MathUtils;

/**
 * @author Hanna_Aliakseichykava
 */
public class MenuHandler {

	private static final Logger log = Logger.getLogger(MenuHandler.class);

	private int maxNumber;

	private static int appRunNumber = 1;
	private int menuCalledNumber = 1;
	
	public MenuHandler(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public void start() {

		log.info("\n\nLOADED APP IS STARTED (APP CALL NUMBER - " + (appRunNumber++) + ")\n");

		boolean exit = false;

		while (!exit) {

			printMenu();

			int action = scanNumber();

			exit = handleAction(action);
		}

		log.info("----LOADED APP IS CLOSED-----");
	}

	private void printMenu() {

		log.info("------------ ( Method call numer number - " + (menuCalledNumber++) + " ) ------------");
		log.info("Select option:");
		log.info("1 - Print Random Number");
		log.info("2 - Exit");
		log.info("Your input:");
	}

	private int scanNumber() {

		try {

			Scanner scanner = new Scanner(System.in);
			return scanner.nextInt();

		} catch (InputMismatchException e) {
			return -1;
		}
	}

	private boolean handleAction(int action) {

		boolean exit = false;

		switch (action) {

		case 1:
			log.info("Random integer: " + MathUtils.getRandomNumber(maxNumber));
			break;

		case 2:
			exit = true;
			break;

		default:
			log.error("Not supported option (" + action + ")");
		}

		log.info("\n");

		return exit;
	}

}
