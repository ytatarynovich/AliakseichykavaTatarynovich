package com.epam.jmp.classloading;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.epam.jmp.classloading.utils.MethodCaller;

/**
 * @author Hanna_Aliakseichykava
 */
public class MenuHandler {

	private static final Logger log = Logger.getLogger(MenuHandler.class);

	private String jarPath;
	private String className;
	private String methodName;

	public MenuHandler(String jarPath, String className, String methodName) {
		this.jarPath = jarPath;
		this.className = className;
		this.methodName = methodName;
	}

	public void start() throws ClassNotFoundException {

		log.info("----START-----");

		boolean exit = false;

		while (!exit) {

			printMenu();

			int action = scanNumber();

			exit = handleAction(action);
		}

		log.info("----END-----");
	}

	private void printMenu() {

		log.info("------------------------");
		log.info("Select option:");
		log.info("1 - Load app");
		log.info("2 - Run app");
		log.info("3 - Reload app");
		log.info("4 - Exit");
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

	private static final boolean INITIALIZE_STATIC_VARS = true;

	private ClassLoader loader = null;
	private Class clazz = null;

	private boolean handleAction(int action) throws ClassNotFoundException {

		boolean exit = false;

		switch (action) {

		case 1:
			log.info("LOADING app...");
			if(loader == null) {
				loader = JarClassLoader.newInstance(jarPath);
			}
			clazz = Class.forName(className, INITIALIZE_STATIC_VARS, loader);
			log.info("APP IS LOADED");
			break;

		case 2:
			log.info("RUNNING loaded app...");
			if(clazz == null) {
				log.info("App can not be started as it is not loaded yet, load it before.");
			} else {
				MethodCaller.callVoidMethod(clazz, methodName);
			}
			break;

		case 3:
			log.info("RELOADING app...");
			loader = JarClassLoader.newInstance(jarPath);
			clazz = Class.forName(className, INITIALIZE_STATIC_VARS, loader);
			log.info("APP IS RELOADED");
			break;

		case 4:
			exit = true;
			break;

		default:
			log.error("Not supported option (" + action + ")");
		}

		log.info("\n");

		return exit;
	}
}
