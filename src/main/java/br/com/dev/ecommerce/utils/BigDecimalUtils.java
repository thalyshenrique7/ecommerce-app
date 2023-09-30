package br.com.dev.ecommerce.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {

	public static boolean isEqual(BigDecimal value1, BigDecimal value2) {
		return value1.compareTo(value2) == 0;
	}

	public static boolean isGreaterOrEqual(BigDecimal value1, BigDecimal value2) {
		return value1.compareTo(value2) >= 0;
	}

	public static boolean isGreater(BigDecimal value1, BigDecimal value2) {
		return value1.compareTo(value2) > 0;
	}

	public static boolean isLessOrEqual(BigDecimal value1, BigDecimal value2) {
		return value1.compareTo(value2) <= 0;
	}

	public static boolean isLess(BigDecimal value1, BigDecimal value2) {
		return value1.compareTo(value2) < 0;
	}
}
