package br.com.dev.ecommerce.estoque.exception;

import br.com.dev.ecommerce.utils.exception.ExceptionBase;
import br.com.dev.ecommerce.utils.exception.ExceptionEnum;

public class NotFoundException extends ExceptionBase {
	private static final long serialVersionUID = -1805276581385127022L;

	private Class<?> classEntity;

	private String query;

	public NotFoundException(Class<?> classEntity, String query) {
		super(ExceptionEnum.NOT_FOUND_EXCEPTION);

		this.classEntity = classEntity;
		this.query = query;
	}

	public NotFoundException(String str) {
		super(str);
	}

	public Class<?> getClassEntity() {
		return classEntity;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
