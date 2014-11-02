package com.epam.jmp.utils;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

/**
 * @author Hanna_Aliakseichykava
 */
public class PropertyUtils {
	
	public static Properties loadProperties(String propsPath) {

		Properties props = new Properties();

		try {
			FileInputStream is = new FileInputStream(propsPath);
			props.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return props;
	}

}
