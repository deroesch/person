package org.deroesch.models;

import java.util.Objects;

public class USPhoneNumber implements CanBeEmpty {

	public static final USPhoneNumber EMPTY_PHONE = new USPhoneNumber();

	/**
	 * 
	 */
	protected USPhoneNumber() {
		super();
	}

	/**
	 * @param areaCode
	 * @param prefix
	 * @param suffix
	 * @param extension
	 */
	public USPhoneNumber(String areaCode, String prefix, String suffix) {
		this(areaCode, prefix, suffix, "");
	}

	/**
	 * @param areaCode
	 * @param prefix
	 * @param suffix
	 * @param extension
	 */
	public USPhoneNumber(String areaCode, String prefix, String suffix, String extension) {
		super();
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.suffix = suffix;
		this.extension = extension;
		this.isEmpty = false;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	@Override
	public boolean isEmpty() {
		return isEmpty;
	}

	@Override
	public int hashCode() {
		return Objects.hash(areaCode, extension, prefix, suffix);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof USPhoneNumber)) {
			return false;
		}
		USPhoneNumber other = (USPhoneNumber) obj;
		return Objects.equals(areaCode, other.areaCode) && Objects.equals(extension, other.extension)
				&& Objects.equals(prefix, other.prefix) && Objects.equals(suffix, other.suffix);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("+1 (");
		builder.append(areaCode);
		builder.append(") ");

		builder.append(prefix);
		builder.append("-");
		builder.append(suffix);

		if (!extension.isBlank()) {
			builder.append(" ext. ");
			builder.append(extension);
		}

		return builder.toString();
	}

	private Integer id = -1;
	private String areaCode = "";
	private String prefix = "";
	private String suffix = "";
	private String extension = "";
	private boolean isEmpty = true;

}
