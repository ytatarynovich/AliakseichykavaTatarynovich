package com.epam.jmp.classloading;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.Logger;

/**
 * @author Hanna_Aliakseichykava
 */
public class JarClassLoader extends URLClassLoader {

	private static final Logger log = Logger.getLogger(JarClassLoader.class);

	private JarClassLoader(final URL[] urls) {
		super(urls);
	}

	public static JarClassLoader newInstance(String pathToJar) {

		try {

			URL[] urls = { new URL("jar:file:" + pathToJar + "!/") };
			return new JarClassLoader(urls);

		} catch (MalformedURLException e) {
			log.error("Loader creation error:" + e.getMessage());
			throw new RuntimeException(e);
		}
	}

}
