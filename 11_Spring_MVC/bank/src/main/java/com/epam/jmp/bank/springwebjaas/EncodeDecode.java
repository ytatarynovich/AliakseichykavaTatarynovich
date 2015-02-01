package com.epam.jmp.bank.springwebjaas;

import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

/**
 * @see http://techannotation.wordpress.com/2012/12/05/5-minutes-with-spring-
 *      authentication-and-authorization-service-jaa/
 */
@SuppressWarnings("restriction")
public class EncodeDecode {

	protected static final Logger log = Logger.getLogger(EncodeDecode.class);
	// password for encryption
	final static String keyPassword = "password12345678";
	// put this as key in AES
	static SecretKeySpec key = new SecretKeySpec(keyPassword.getBytes(), "AES");

	public final static int MINUTE_PASSWORD_EXPIRES = 2;

	public static String encrypt(String input) {

		try {
			// Parameter specific algorithm
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(
					keyPassword.getBytes());
			// Whatever you want to encrypt/decrypt
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			// You can use ENCRYPT_MODE (ENCRYPTunderscoreMODE) or DECRYPT_MODE
			// (DECRYPT underscore MODE)
			cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			// encrypt data
			byte[] ecrypted = cipher.doFinal(input.getBytes());
			// encode data using standard encoder
			@SuppressWarnings("restriction")
			String output = new BASE64Encoder().encode(ecrypted);
			return output;
		} catch (Exception e) {
			log.info("EncodeDecode: " + e.getMessage());
			return null;
		}

	}

	public static String decrypt(String input) {
		try {
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(
					keyPassword.getBytes());
			// Whatever you want to encrypt/decrypt using AES /CBC padding
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			// You can use ENCRYPT_MODE or DECRYPT_MODE
			cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
			// decode data using standard decoder
			@SuppressWarnings("restriction")
			byte[] output = new BASE64Decoder().decodeBuffer(input);
			// Decrypt the data
			byte[] decrypted = cipher.doFinal(output);

			return new String(decrypted);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
