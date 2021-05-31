package com.zensar.spring.utility;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class Password {

	public static String encrypt(String inputPassword) {
		StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
		return spe.encryptPassword(inputPassword);

	}

	public static boolean checkPassword(String inputPassword, String encodedPassword) {
		StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
		return spe.checkPassword(inputPassword, encodedPassword);
	}

}
