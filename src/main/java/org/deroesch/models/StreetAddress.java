package org.deroesch.models;

import java.util.Objects;

public class StreetAddress implements Emptyable {

	/**
	 * Empty object constructor
	 */
	protected StreetAddress() {
		super();
	}

	/**
	 * Valid object constructor
	 * 
	 * @param addr1
	 * @param addr2
	 * @param city
	 * @param state
	 * @param zip
	 */
	public StreetAddress(String addr1, String addr2, String city, String state, String zip) {
		super();
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.isEmpty = false;
	}

	public Integer getId() {
		return id;
	}

	public String getAddr1() {
		return addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	@Override
	public boolean isEmpty() {
		return isEmpty;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addr1, addr2, city, state, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof StreetAddress)) {
			return false;
		}
		StreetAddress other = (StreetAddress) obj;
		return Objects.equals(addr1, other.addr1) && Objects.equals(addr2, other.addr2)
				&& Objects.equals(city, other.city) && Objects.equals(state, other.state)
				&& Objects.equals(zip, other.zip);
	}

	private boolean isEmpty = true;
	private Integer id = -1;
	private String addr1 = "";
	private String addr2 = "";
	private String city = "";
	private String state = "";
	private String zip = "";
}
