package br.com.dev.ecommerce.utils;

import java.util.regex.Pattern;

public class StringUtils {

	public static boolean isEmailValido(String email) {

		return Pattern.compile("^(.+)@(\\S+)$").matcher(email).matches();
	}

	public static boolean isNotEmpty(String str) {
		return str != null && !str.isEmpty();
	}

	public static boolean isNotBlank(String str) {
		return str != null && !str.isBlank();
	}

}
