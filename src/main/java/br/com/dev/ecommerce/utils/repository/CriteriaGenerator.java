package br.com.dev.ecommerce.utils.repository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.Assert;

import br.com.dev.ecommerce.utils.EntityBaseRoot;
import br.com.dev.ecommerce.utils.data.DataUtils;
import br.com.dev.ecommerce.utils.number.BigDecimalUtils;

public class CriteriaGenerator {

	/**
	 * Gera o predicado para a relação atributo valor recebida.
	 * 
	 * @param columnName Coluna filtrada.
	 * @param value Valor Buscado
	 * @param selector Tipo do seletor utilizado.
	 * @return Predicado para filtragem dos objetos.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <TEntity extends EntityBaseRoot> Predicate getPredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb, String columnName, String value, Selector selector) {

		Assert.hasLength(columnName, "columnName");
		Assert.notNull(value, "value");

		Path<Object> path = root.get(columnName);
		if (path.getJavaType() == Boolean.class || path.getJavaType().toString().equals("boolean"))
			return getBooleanPredicate(root, query, cb, columnName, value, selector);
		else if (path.getJavaType() == String.class)
			return getStringPredicate(root, query, cb, columnName, value, selector);
		else if (path.getJavaType() == Date.class)
			return getDatePredicate(root, query, cb, columnName, value, selector);
		else if (path.getJavaType() == Calendar.class)
			return getCalendarPredicate(root, query, cb, columnName, value, selector);
		else if (path.getJavaType() == BigDecimal.class)
			return getBigDecimalPredicate(root, query, cb, columnName, value, selector);
		else if (path.getJavaType() == Double.class)
			return getDoublePredicate(root, query, cb, columnName, value, selector);
		else if (path.getJavaType() == Float.class)
			return getFloatPredicate(root, query, cb, columnName, value, selector);
		else if (path.getJavaType() == Long.class)
			return getLongPredicate(root, query, cb, columnName, value, selector);
		else if (path.getJavaType().isEnum())
			return getEnumPredicate(root, query, cb, columnName, value, selector, ((Class<Enum>) path.getJavaType()));
		else
			throw new IllegalArgumentException("exception.query.column.type.unsupported");
	}

	private static <TEntity extends EntityBaseRoot> Predicate getBooleanPredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb, String columnName, String value, Selector selector) {

		Predicate predicate = null;

		Boolean valueParsed = Boolean.parseBoolean(value);

		switch (selector) {
			case EQUALS:
				predicate = cb.equal(root.<Boolean> get(columnName), valueParsed);
				break;
			case NOT_EQUAL:
				predicate = cb.notEqual(root.<Boolean> get(columnName), valueParsed);
				break;
			default:
				throw new IllegalArgumentException("exception.query.column.type.unsupported");
		}

		return predicate;
	}

	private static <TEntity extends EntityBaseRoot> Predicate getStringPredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb, String columnName, String value, Selector selector) {

		Predicate predicate = null;

		/*
		 * Todas as consultas são realizadas com lower case, tanto no banco quanto na variável de pesquisa
		 */
		value = value.trim().toLowerCase();

		switch (selector) {
			case CONTAINS:
				predicate = cb.like(cb.lower(root.<String> get(columnName)), "%" + value + "%");
				break;
			case CONTAINS_PREFIX:
				predicate = cb.or(cb.equal(cb.lower(root.<String> get(columnName)), value),
						cb.like(cb.lower(root.<String> get(columnName)), value + "-"));
				break;
			case CONTAINS_WORD:
				predicate = cb.like(cb.lower(root.<String> get(columnName)), "% " + value + " %");
				break;
			case ENDS_WITH:
				predicate = cb.like(cb.lower(root.<String> get(columnName)), "% " + value);
				break;
			case EQUALS:
				predicate = cb.equal(cb.lower(root.<String> get(columnName)), value);
				break;
			case NOT_EQUAL:
				predicate = cb.notEqual(cb.lower(root.<String> get(columnName)), value);
				break;
			case STARTS_WITH:
				predicate = cb.like(cb.lower(root.<String> get(columnName)), value + "%");
				break;
			default:
				throw new IllegalArgumentException("exception.query.column.type.unsupported");
		}

		return predicate;
	}

	private static <TEntity extends EntityBaseRoot> Predicate getDatePredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb, String columnName, String value, Selector selector) {

		Predicate predicate = null;

		Date valueDate = DataUtils.parseDateDefaultSystemFormat(value);

		switch (selector) {
			case GREATER_THAN:
				predicate = cb.greaterThan(root.<Date> get(columnName), valueDate);
				break;
			case LESS_THAN:
				predicate = cb.lessThan(root.<Date> get(columnName), valueDate);
				break;
			default:
				throw new IllegalArgumentException("exception.query.column.type.unsupported");
		}

		return predicate;
	}

	private static <TEntity extends EntityBaseRoot> Predicate getCalendarPredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb, String columnName, String value, Selector selector) {

		Predicate predicate = null;

		Date valueDate = DataUtils.parseDateDefaultSystemFormat(value);
		Calendar valueCalendar = Calendar.getInstance();
		valueCalendar.setTime(valueDate);

		switch (selector) {
			case GREATER_THAN:
				predicate = cb.greaterThan(root.<Calendar> get(columnName), valueCalendar);
				break;
			case LESS_THAN:
				predicate = cb.lessThan(root.<Calendar> get(columnName), valueCalendar);
				break;
			default:
				throw new IllegalArgumentException("exception.query.column.type.unsupported");
		}

		return predicate;
	}

	private static <TEntity extends EntityBaseRoot> Predicate getBigDecimalPredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb, String columnName, String value, Selector selector) {

		Predicate predicate = null;

		BigDecimal valueParsed = BigDecimalUtils.parseToBigDecimal(value);

		switch (selector) {
			case GREATER_THAN:
				predicate = cb.greaterThan(root.<BigDecimal> get(columnName), valueParsed);
				break;
			case LESS_THAN:
				predicate = cb.lessThan(root.<BigDecimal> get(columnName), valueParsed);
				break;
			case EQUALS:
				predicate = cb.equal(root.<BigDecimal> get(columnName), valueParsed);
				break;
			case NOT_EQUAL:
				predicate = cb.notEqual(root.<BigDecimal> get(columnName), valueParsed);
				break;
			default:
				throw new IllegalArgumentException("exception.query.column.type.unsupported");
		}

		return predicate;
	}

	private static <TEntity extends EntityBaseRoot> Predicate getDoublePredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb, String columnName, String value, Selector selector) {

		Predicate predicate = null;

		Double valueParsed = Double.parseDouble(value);

		switch (selector) {
			case GREATER_THAN:
				predicate = cb.greaterThan(root.<Double> get(columnName), valueParsed);
				break;
			case LESS_THAN:
				predicate = cb.lessThan(root.<Double> get(columnName), valueParsed);
				break;
			case EQUALS:
				predicate = cb.equal(root.<Double> get(columnName), valueParsed);
				break;
			case NOT_EQUAL:
				predicate = cb.notEqual(root.<Double> get(columnName), valueParsed);
				break;
			default:
				throw new IllegalArgumentException("exception.query.column.type.unsupported");
		}

		return predicate;
	}

	private static <TEntity extends EntityBaseRoot> Predicate getFloatPredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb, String columnName, String value, Selector selector) {

		Predicate predicate = null;

		Float valueParsed = Float.parseFloat(value);

		switch (selector) {
			case GREATER_THAN:
				predicate = cb.greaterThan(root.<Float> get(columnName), valueParsed);
				break;
			case LESS_THAN:
				predicate = cb.lessThan(root.<Float> get(columnName), valueParsed);
				break;
			case EQUALS:
				predicate = cb.equal(root.<Float> get(columnName), valueParsed);
				break;
			case NOT_EQUAL:
				predicate = cb.notEqual(root.<Float> get(columnName), valueParsed);
				break;
			default:
				throw new IllegalArgumentException("exception.query.column.type.unsupported");
		}

		return predicate;
	}

	private static <TEntity extends EntityBaseRoot> Predicate getLongPredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb, String columnName, String value, Selector selector) {

		Predicate predicate = null;

		Long valueParsed = Long.parseLong(value);

		switch (selector) {
			case GREATER_THAN:
				predicate = cb.greaterThan(root.<Long> get(columnName), valueParsed);
				break;
			case LESS_THAN:
				predicate = cb.lessThan(root.<Long> get(columnName), valueParsed);
				break;
			case EQUALS:
				predicate = cb.equal(root.<Long> get(columnName), valueParsed);
				break;
			case NOT_EQUAL:
				predicate = cb.notEqual(root.<Long> get(columnName), valueParsed);
				break;
			default:
				throw new IllegalArgumentException("exception.query.column.type.unsupported");
		}

		return predicate;
	}

	private static <TEntity extends EntityBaseRoot, T extends Enum<T>> Predicate getEnumPredicate(Root<TEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb, String columnName, String value, Selector selector, Class<T> entityType) {

		Predicate predicate = null;

		switch (selector) {
			case EQUALS:
				predicate = cb.equal(root.<String> get(columnName), Enum.valueOf(entityType, value));
				break;
			case NOT_EQUAL:
				predicate = cb.notEqual(root.<String> get(columnName), Enum.valueOf(entityType, value));
				break;
			default:
				throw new IllegalArgumentException("exception.query.column.type.unsupported");
		}

		return predicate;
	}
}
