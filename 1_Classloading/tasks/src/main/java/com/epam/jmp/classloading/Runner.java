package com.epam.jmp.classloading;

/**
 * @author Hanna_Aliakseichykava
 */
public class Runner {

	private static final String JAR_PATH = "jar-to-load/apptoload-1.0.jar";
	private static final String CLASS_NAME = "com.epam.jmp.classloading.apptoload.Runner";
	private static final String METHOD_NAME = "main";
	
	public static void main(String[] args) throws ClassNotFoundException {

		new MenuHandler(JAR_PATH, CLASS_NAME, METHOD_NAME).start();
	}

}
