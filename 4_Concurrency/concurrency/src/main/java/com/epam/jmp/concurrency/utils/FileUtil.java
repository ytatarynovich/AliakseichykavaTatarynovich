package com.epam.jmp.concurrency.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author Hanna_Aliakseichykava
 */
public class FileUtil {

	private static final Logger log = Logger.getLogger(FileUtil.class);

	private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	public static void writeToFile(String path, String text) {

		List<String> texts = new ArrayList<String>();
		texts.add(text);
		writeToFile(path, texts);
	}

	public static void writeToFile(String path, List<String> texts) {

		Path destination = Paths.get(path);
		 try {
			Files.write(destination, texts, DEFAULT_CHARSET);

		} catch (IOException e) {
			log.warn(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Impossible to write to file [" + path + "]: " + e.getMessage());
		}
	}

	public static List<String> readFile(String path) {

		Path destination = Paths.get(path);
		try {
			return Files.readAllLines(destination, DEFAULT_CHARSET);

		} catch (IOException e) {
			log.warn(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("File [" + path + "] can not be read: " + e.getMessage());
		}
	}

	public boolean isFileExists(String path) {
		File file = new File(path);
		return file.exists();
	}

}
