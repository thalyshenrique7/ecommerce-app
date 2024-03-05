package br.com.dev.ecommerce.utils.data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.MappedSuperclass;

import br.com.dev.ecommerce.config.Constants;
import br.com.dev.ecommerce.utils.number.BigDecimalUtils;

@MappedSuperclass
public class DataUtils {

	public static final String DATE_PATTERN = "dd/MM/yyyy";
	public static final String DATETIME_PATTERN = "dd/MM/yyyy HH:mm:ss";
	public static final String DATEHOURMINUTE_PATTERN = "dd/MM/yyyy HH:mm";
	public static final String UTC_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String TIME = "HH:mm:ss:SSS";

	public static Date parseDateDefaultSystemFormat(String date) {

		SimpleDateFormat format = new SimpleDateFormat(Constants.CORE_DEFAULT_DATE_TIME_PATTERN);

		try {
			return format.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}

	public static String format(String format, Date date) {

		SimpleDateFormat dtFormat = new SimpleDateFormat(format);

		return dtFormat.format(date);
	}

	public static String formatDateDefaultSystemFormat(Date date) {

		return format(Constants.CORE_DEFAULT_DATE_TIME_PATTERN, date);
	}

	public static Calendar startOfDay(Calendar date) {

		if (date == null)
			return null;

		date = (Calendar) date.clone();
		date.set(Calendar.HOUR_OF_DAY, date.getActualMinimum(Calendar.HOUR_OF_DAY));
		date.set(Calendar.MINUTE, date.getActualMinimum(Calendar.MINUTE));
		date.set(Calendar.SECOND, date.getActualMinimum(Calendar.SECOND));
		date.set(Calendar.MILLISECOND, date.getActualMinimum(Calendar.MILLISECOND));

		return date;
	}

	public static Calendar endOfDay(Calendar date) {

		if (date == null)
			return null;

		date = (Calendar) date.clone();
		date.set(Calendar.HOUR_OF_DAY, date.getActualMaximum(Calendar.HOUR_OF_DAY));
		date.set(Calendar.MINUTE, date.getActualMaximum(Calendar.MINUTE));
		date.set(Calendar.SECOND, date.getActualMaximum(Calendar.SECOND));
		date.set(Calendar.MILLISECOND, date.getActualMaximum(Calendar.MILLISECOND));

		return date;
	}

	public static String fullDate(Calendar date) {

		return new SimpleDateFormat(DATETIME_PATTERN).format(date.getTime());
	}

	public static String dateOnly(Calendar date) {

		return new SimpleDateFormat(DATE_PATTERN).format(date.getTime());
	}

	public static String dateOnly(Date date) {

		return new SimpleDateFormat(DATE_PATTERN).format(date);
	}

	public static String dateOnlyWithoutDays(Calendar date) {

		return new SimpleDateFormat("MM/yyyy").format(date.getTime());
	}

	public static String timeOnly(Calendar date) {

		return new SimpleDateFormat("HH:mm:ss").format(date.getTime());
	}

	public static String yearOnly(Calendar date) {

		return new SimpleDateFormat("yyyy").format(date.getTime());
	}

	public static int diffDays(Calendar valor, Calendar comparacao) {

		if (valor == null || comparacao == null)
			return 0;

		long diferencaMiliSegundos = valor.getTimeInMillis() - comparacao.getTimeInMillis();
		double resultado = diferencaMiliSegundos / (24.0 * 60.0 * 60.0 * 1000.0);

		return BigDecimalUtils.arredondar(new BigDecimal(resultado), 0, RoundingMode.UP).intValue();
	}

	public static int diffMinutes(Calendar start, Calendar end) {

		if (start == null || end == null)
			return 0;

		double toMinutes = 1000.0 * 60.0;
		double diffMinutes = (end.getTimeInMillis() - start.getTimeInMillis()) / toMinutes;

		return BigDecimalUtils.arredondar(new BigDecimal(diffMinutes), 0, RoundingMode.HALF_UP).intValue();
	}

	public static int diffSeconds(Calendar start, Calendar end) {

		if (start == null || end == null)
			return 0;

		double toSeconds = 1000.0;
		double diffMinutes = (end.getTimeInMillis() - start.getTimeInMillis()) / toSeconds;

		return BigDecimalUtils.arredondar(new BigDecimal(diffMinutes), 0, RoundingMode.HALF_UP).intValue();
	}

	public static boolean compareDate(Calendar data1, Calendar data2) {

		if (data1.get(Calendar.DAY_OF_MONTH) == data2.get(Calendar.DAY_OF_MONTH)
				&& data1.get(Calendar.MONTH) == data2.get(Calendar.MONTH)
				&& data1.get(Calendar.YEAR) == data2.get(Calendar.YEAR))
			return true;

		return false;

	}

	public static Calendar setFirstDayOfMonth(Calendar date) {

		Calendar clone = (Calendar) date.clone();
		clone.add(Calendar.DAY_OF_MONTH, -1);

		return clone;
	}

	/**
	 * Set the calendar's hour, minute, second and ms to zero leaving the rest
	 * intact
	 * 
	 * @param calendar The calendar to reset
	 */
	public static void resetCalendar(Calendar calendar) {

		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
				0, 0);
	}

	public static void resetTime(Calendar calendar) {

		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

	}

	public static Calendar Pascoa(int ano) {

		int a = ano % 19;
		int b = ano / 100;
		int c = ano % 100;
		int d = b / 4;
		int e = b % 4;
		int f = (b + 8) / 25;
		int g = (b - f + 1) / 3;
		int h = (19 * a + b - d - g + 15) % 30;
		int i = c / 4;
		int j = c % 4;
		int k = (32 + 2 * e + 2 * i - h - j) % 7;
		int m = (a + 11 * h + 22 * k) / 451;
		int n = (h + k - 7 * m + 114) / 31;
		int p = (h + k - 7 * m + 114) % 31;
		p = p + 1;
		n = n - 1;
		Calendar pascoa = Calendar.getInstance();
		pascoa.set(ano, n, p);

		resetCalendar(pascoa);

		return pascoa;
	}

	public static Calendar Carnaval(int ano) {

		Calendar carnaval = Pascoa(ano);
		carnaval.add(Calendar.DAY_OF_MONTH, -47);
		resetCalendar(carnaval);

		return carnaval;
	}

	public static Calendar CorpusChristi(int ano) {

		Calendar corpusChristi = Pascoa(ano);
		corpusChristi.add(Calendar.DAY_OF_MONTH, 60);
		resetCalendar(corpusChristi);

		return corpusChristi;
	}

	public static Calendar natal(int ano) {

		Calendar natal = Calendar.getInstance();
		natal.set(ano, Calendar.DECEMBER, 25);
		resetCalendar(natal);

		return natal;
	}

	public static Calendar anoNovo(int ano) {

		Calendar anoNovo = Calendar.getInstance();
		anoNovo.set(ano, Calendar.JANUARY, 1);
		resetCalendar(anoNovo);

		return anoNovo;
	}

	public static boolean isValidRange(Calendar inicialDate, Calendar finalDate) {

		if (inicialDate == null || finalDate == null)
			return false;

		return inicialDate.compareTo(finalDate) <= 0;
	}

//	public static Date stringToDate(String date) {
//
//		if (StringUtils.isBlank(date))
//			return null;
//
//		int length = StringUtils.deleteWhitespace(date).length();
//		String format = DATE_PATTERN;
//
//		if (length == 18) {
//
//			// data + hora:minuto:segundo
//			format = DATETIME_PATTERN;
//
//		} else if (length == 15) {
//
//			// data + hora:minuto
//			format = DATEHOURMINUTE_PATTERN;
//
//		}
//
//		return stringToDate(date, format);
//	}

	public static Date stringToDate(String date, String format) {

		LocalDate ld = LocalDate.from(DateTimeFormatter.ofPattern(format).parse(date));
		Date d = java.sql.Date.valueOf(ld);

		return d;

	}

//	public static Calendar stringToCalendar(String date) {
//
//		if (StringUtils.isBlank(date))
//			return null;
//
//		int length = StringUtils.deleteWhitespace(date).length();
//		String format = DATE_PATTERN;
//
//		if (length == 18) {
//
//			// data + hora:minuto:segundo
//			format = DATETIME_PATTERN;
//
//		} else if (length == 15) {
//
//			// data + hora:minuto
//			format = DATEHOURMINUTE_PATTERN;
//
//		}
//
//		return stringToCalendar(date, format);
//	}

	public static Calendar stringToCalendar(String date, String format) {

		Date d = stringToDate(date, format);

		Calendar c = Calendar.getInstance();
		c.setTime(d);

		return c;

	}

	public static String getCalendarExtenso(Calendar data) {

		String mes[] = { "Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
				"Outubro", "Novembro", "Dezembro" };

		String dataExtenso = data.get(Calendar.DAY_OF_MONTH) + " de " + mes[data.get(Calendar.MONTH)] + " de "
				+ data.get(Calendar.YEAR);

		return dataExtenso;
	}

	/**
	 * Calcula a diferença em dias entre as duas datas.
	 * <p>
	 * <b>ATENÇÃO: esta comparação considera as horas nas duas datas!</b>
	 * </p>
	 * 
	 * <table border="1">
	 * <tr>
	 * <td>init</td>
	 * <td>end</td>
	 * <td>resultado</td>
	 * </tr>
	 * <tr>
	 * <td>09/01/2025 14:30:00</td>
	 * <td>10/01/2025 12:30:00</td>
	 * <td>0</td>
	 * </tr>
	 * <tr>
	 * <td>09/01/2025 12:30:00</td>
	 * <td>10/01/2025 12:30:00</td>
	 * <td>1</td>
	 * </tr>
	 * </table>
	 * 
	 * <p>
	 * Para comparar considerando apenas a data, utilizar
	 * {@link #daysBetween(Calendar, Calendar, boolean)}
	 * </p>
	 * 
	 * @param init Data inicial
	 * @param end  Data final
	 * @return Quantidade de dias entre as datas.
	 */
	public static long daysBetween(Calendar init, Calendar end) {

		return daysBetween(init, end, false);
	}

	/**
	 * Calcula a diferença em dias entre as duas datas.
	 * 
	 * @param init       Data inicial
	 * @param end        Data final
	 * @param ignoreTime Caso verdadeiro, ignora as horas das duas datas (zerando as
	 *                   mesmas para comparação).
	 * @return Quantidade de dias entre as datas.
	 */
	public static long daysBetween(Calendar init, Calendar end, boolean ignoreTime) {

		Calendar c1 = (Calendar) init.clone();
		Calendar c2 = (Calendar) end.clone();

		if (ignoreTime) {

			resetTime(c1);
			resetTime(c2);
		}

		LocalDateTime local1 = LocalDateTime.ofInstant(c1.toInstant(), init.getTimeZone().toZoneId());
		LocalDateTime local2 = LocalDateTime.ofInstant(c2.toInstant(), end.getTimeZone().toZoneId());

		return ChronoUnit.DAYS.between(local1, local2);

	}

	public static String formatDate(Calendar date) {

		return new SimpleDateFormat(DATE_PATTERN).format(date.getTime());
	}

	public static String formatDateTimeHourMinute(Calendar date) {

		return new SimpleDateFormat(DATEHOURMINUTE_PATTERN).format(date.getTime());
	}

	public static String getCurrentDateTime() {

		return formatDateTimeHourMinute(Calendar.getInstance());
	}

	public static String getCurrentTime() {

		return new SimpleDateFormat(TIME).format(new Date(System.currentTimeMillis()));
	}

	public static Calendar plusDays(Calendar date, int days) {

		Calendar d1 = (Calendar) date.clone();
		d1.add(Calendar.DATE, days);

		return d1;
	}

	public static Calendar minusDays(Calendar date, int days) {

		Calendar d1 = (Calendar) date.clone();
		d1.add(Calendar.DATE, -days);

		return d1;
	}

	public static Calendar addMonths(Calendar date, int months) {

		if (date == null)
			return null;

		Calendar newDate = (Calendar) date.clone();
		newDate.add(Calendar.MONTH, months);

		return newDate;
	}

//	public static Calendar fromString(String dateAsString) {
//
//		if (StringUtils.isBlank(dateAsString))
//			return null;
//
//		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
//
//		Date date = null;
//
//		try {
//			date = sdf.parse(dateAsString);
//		} catch (ParseException e) {
//			throw new IllegalArgumentException("Formato de data inválido");
//		}
//
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);
//
//		return calendar;
//	}

	/**
	 * Verifica se a data é posterior a data de comparação ignorando
	 * horas/minutos/segundos e milisegundos
	 * 
	 * @param date          Data
	 * @param dateToCompare Data para comparação
	 * @return True se date é posterior a dateToCompare.
	 */
	public static boolean isAfter(Calendar date, Calendar dateToCompare) {

		return isAfter(date, dateToCompare, false);
	}

	/**
	 * Verifica se a data é posterior a data de comparação
	 * 
	 * @param date          Data
	 * @param dateToCompare Data para comparação
	 * @param ignoreTime    Para indicar se deve ser ignorado as horas na comparação
	 * @return True se date é posterior a dateToCompare.
	 */
	public static boolean isAfter(Calendar date, Calendar dateToCompare, boolean ignoreTime) {

		if (date == null || dateToCompare == null)
			return false;

		Calendar newDate = ignoreTime ? startOfDay(date) : (Calendar) date.clone();
		Calendar newDateToCompare = ignoreTime ? startOfDay(dateToCompare) : (Calendar) dateToCompare.clone();

		return newDate.after(newDateToCompare);
	}

}
