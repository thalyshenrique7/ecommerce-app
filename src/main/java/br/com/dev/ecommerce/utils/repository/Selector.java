package br.com.dev.ecommerce.utils.repository;

public enum Selector {

	/**
	 * Attribute Contains Prefix Selector [name|=value] Selects elements that have
	 * the specified attribute with a value either equal to a given string or
	 * starting with that string followed by a hyphen (-).
	 */
	CONTAINS_PREFIX("|="),
	/**
	 * Attribute Contains Selector [name*=value] Selects elements that have the
	 * specified attribute with a value containing a given substring.
	 */
	CONTAINS("*="),
	/**
	 * Attribute Contains Word Selector [name~=value] Selects elements that have the
	 * specified attribute with a value containing a given word, delimited by
	 * spaces.
	 */
	CONTAINS_WORD("~="),
	/**
	 * Attribute Ends With Selector [name$=value] Selects elements that have the
	 * specified attribute with a value ending exactly with a given string. The
	 * comparison is case sensitive.
	 */
	ENDS_WITH("$="),
	/**
	 * Attribute Not Equal Selector [name!=value] Select elements that either don't
	 * have the specified attribute, or do have the specified attribute but not with
	 * a certain value.
	 */
	NOT_EQUAL("!="),
	/**
	 * Attribute Starts With Selector [name^=value] Selects elements that have the
	 * specified attribute with a value beginning exactly with a given string.
	 */
	STARTS_WITH("^="),
	/**
	 * Attribute Equals Selector [name=value] Selects elements that have the
	 * specified attribute with a value exactly equal to a certain value.
	 */
	EQUALS("="),
	/**
	 * Attribute Greater Than Selector [name>value] Selects elements that have the
	 * specified attribute with a value greater than to a certain value.
	 */
	GREATER_THAN(">"),
	/**
	 * Attribute Less Than Selector [name<value] Selects elements that have the
	 * specified attribute with a value less than to a certain value.
	 */
	LESS_THAN("<");

	private String code;

	Selector(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
