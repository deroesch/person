package org.deroesch.models;

import java.util.Objects;

public class EmailAddress implements Emptyable {
	
	public static final EmailAddress EMPTY_EMAIL = new EmailAddress();

	/**
	 * 
	 */
	protected EmailAddress() {
		super();
	}

	/**
	 * @param value
	 */
	public EmailAddress(String value) {
		super();
		this.value = value;
		this.isEmpty = false;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	@Override
	public boolean isEmpty() {
		return isEmpty;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EmailAddress)) {
			return false;
		}
		EmailAddress other = (EmailAddress) obj;
		return Objects.equals(value, other.value);
	}
	
	private boolean isEmpty = true;
	private Integer id = -1;
	private String value = "";
}
