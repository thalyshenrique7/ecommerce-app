package br.com.dev.ecommerce.utils.exception;

public enum ExceptionEnum {

	NOT_AUTHENTICATED_EXCEPTION("exception.not.authenticated"),

	ILLEGAL_PERSISTENT_EXCEPTION("exception.illegal.persistent.object"),

	NOT_FOUND_EXCEPTION("exception.default.not.found"),

	GENERIC_BUSINESS_EXCEPTION("exception.business.generic");

	private String messageCode;

	ExceptionEnum(String messageCode) {

		this.messageCode = messageCode;
	}

	public String getMessageCode() {

		return this.messageCode;
	}
}
