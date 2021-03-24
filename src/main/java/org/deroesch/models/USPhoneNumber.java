package org.deroesch.models;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	private final String regex = "/(?=(?:^(?:\\+?1\\s*(?:[.-]\\s*)?)?(?!(?:(?:.*\\(.*)|(?:.*\\).*)))(?:[2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))|(?:.*\\((?:[2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\).*))(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(?([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\)?)\\s*(?:[.-]\\s*)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d{1,15}))?$/gm";

	private USPhoneNumber parse(String string) {

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(string);
		final String[] parts = new String[4];

		boolean found = false;
		while (matcher.find()) {
			found = true;
			for (int i = 1; i <= matcher.groupCount(); i++) {
				parts[i - 1] = matcher.group(i);
			}

			// Might be null. Fix it to "".
			parts[3] = nullToEmpty(parts[3]);
		}

		return found ? new USPhoneNumber(parts[0], parts[1], parts[2], parts[3]) : USPhoneNumber.EMPTY_PHONE;
	}

	private String nullToEmpty(String s) {
		return null == s ? "" : s;
	}
}
