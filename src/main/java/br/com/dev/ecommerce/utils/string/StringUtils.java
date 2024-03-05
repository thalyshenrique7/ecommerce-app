package br.com.dev.ecommerce.utils.string;

import java.util.regex.Pattern;

public class StringUtils {
	
	public static final String TAB = "\t";
	public static final String BR_LINE_HTML = "<br>";
	public static final String SYMBOL_PERCENT = "%";
	public static final String SYMBOL_COMMA = ",";
	public static final String SYMBOL_DOT = ".";
	public static final String SYMBOL_RS = "R$";
	public static final String SYMBOL_BACKSLASH = "/";

	public static boolean isEmailValido(String email) {

		return Pattern.compile("^(.+)@(\\S+)$").matcher(email).matches();
	}

	public static boolean isNotEmpty(String str) {
		return str != null && !str.isEmpty();
	}

	public static boolean isNotBlank(String str) {
		return str != null && !str.isBlank();
	}

//	public static String substituirQuebraLinhaPorEspaco(String str) {
//
//		if (isBlank(str))
//			return EMPTY;
//
//		return str.trim().replaceAll("\\n", " ").replaceAll("\\r", " ");
//	}
//
//	/**
//	 * Remove acentos de uma string utilizando Normalizer.
//	 * 
//	 * @return String normalizada
//	 */
//	public static String removeAccents(String str) {
//
//		CharSequence cs = new StringBuilder(isBlank(str) ? EMPTY : str);
//		return Normalizer.normalize(cs, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
//	}
//
//	public static boolean containsAccents(String str) {
//
//		if (isBlank(str))
//			return false;
//
//		return !Normalizer.isNormalized(str, Normalizer.Form.NFKD);
//	}
//
//	public static String emptyIfBlank(String str) {
//
//		return isBlank(str) ? EMPTY : str;
//	}
//
//	public static String removeZeroLeft(String str) {
//
//		return str.trim().replaceFirst("^0+(?!$)", "");
//	}
//
//	/**
//	 * Obtém apenas números contidos na string, descartando todos os outros caracteres.
//	 */
//	public static String extractNumbers(String str) {
//
//		if (isBlank(str))
//			return EMPTY;
//
//		return str.trim().replaceAll("\\D", EMPTY);
//	}
//
//	public static String extractStringAndNumbers(String str) {
//
//		if (isBlank(str))
//			return EMPTY;
//
//		return str.trim().replaceAll("[^a-zA-Z0-9]", EMPTY);
//	}
//
//	public static boolean isEqualIgnoreSpecial(String str1, String str2) {
//
//		if (isBlank(str1) && isBlank(str2))
//			return true;
//
//		String s1 = removeAccents(str1.trim().toLowerCase());
//		String s2 = removeAccents(str2.trim().toLowerCase());
//
//		return compareIgnoreCase(s1, s2) == 0;
//
//	}
//
//	public static boolean isEmailValid(String email) {
//
//		return Pattern.compile("^(.+)@(\\S+)$").matcher(email).matches();
//	}
//
//	public static String removeQuotationMarks(String str) {
//
//		if (isBlank(str))
//			return str;
//
//		return str.trim().replace("'", EMPTY).replace("\"", EMPTY);
//	}
//
//	public static String nullIfBlank(String str) {
//
//		return isBlank(str) ? null : str;
//	}
//	
//	public static String removerAcentos(String str) {
//
//		CharSequence cs = new StringBuilder(StringUtils.isBlank(str) ? StringUtils.EMPTY : str);
//		return Normalizer.normalize(cs, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
//	}
//	
//	public static String substituirQuebraDeLinhaPorEspaco(String value) {
//
//		return value == null ? null : value.replaceAll("\n", " ").replaceAll("\r", " ").trim();
//	}
//
//	public static String formatarCep(String texto) {
//
//		if (StringUtils.isBlank(texto))
//			return StringUtils.EMPTY;
//
//		try {
//			MaskFormatter mf = new MaskFormatter("##.###-###");
//			mf.setValueContainsLiteralCharacters(false);
//			return mf.valueToString(texto);
//		} catch (Exception e) {
//			return StringUtils.EMPTY;
//		}
//	}
//
//	public static String formatarCnpj(String texto) {
//
//		texto = getDigits(texto);
//
//		if (StringUtils.isBlank(texto))
//			return StringUtils.EMPTY;
//
//		try {
//			texto = String.format("%014d", Long.parseLong(texto));
//			MaskFormatter mf = new MaskFormatter("##.###.###/####-##");
//			mf.setValueContainsLiteralCharacters(false);
//			return mf.valueToString(texto);
//		} catch (Exception e) {
//			return texto;
//		}
//	}
//	
//	public static String formatarCpf(String texto) {
//
//		texto = getDigits(texto);
//
//		if (StringUtils.isBlank(texto))
//			return StringUtils.EMPTY;
//
//		try {
//			texto = String.format("%011d", Long.parseLong(texto));
//			MaskFormatter mf = new MaskFormatter("###.###.###-##"); 
//			mf.setValueContainsLiteralCharacters(false);
//			return mf.valueToString(texto);
//		} catch (Exception e) {
//			return texto;
//		}
//	}

}
