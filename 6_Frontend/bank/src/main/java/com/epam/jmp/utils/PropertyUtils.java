package com.epam.jmp.utils;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

/**
 * @author Hanna_Aliakseichykava
 */
public class PropertyUtils {

	public static Properties loadFromResources(String path) {

		Properties props = new Properties();

		try {
			props.load(Thread.currentThread()
				.getContextClassLoader().getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return props;
	}

}
