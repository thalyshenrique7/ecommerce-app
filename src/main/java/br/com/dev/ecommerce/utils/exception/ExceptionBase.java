package br.com.dev.ecommerce.utils.exception;

public abstract class ExceptionBase extends Exception {

	private static final long serialVersionUID = -9174772623106562296L;

	public ExceptionEnum exceptionEnum;

	public ExceptionBase(ExceptionEnum exceptionEnum) {
		this.exceptionEnum = exceptionEnum;
	}

	public ExceptionEnum getExceptionEnum() {
		return exceptionEnum;
	}

	public ExceptionBase(String str) {

	}
}
