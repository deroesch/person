package org.deroesch.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person implements Emptyable {

	public static final Person EMPTY_PERSON = new Person();

	/**
	 * 
	 */
	protected Person() {
		super();
	}

	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param socialSecurity
	 * @param birthday
	 */
	public Person(String firstName, String middleName, String lastName, String socialSecurity, LocalDate birthday) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.socialSecurity = socialSecurity;
		this.birthday = birthday;
		this.isEmpty = false;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the socialSecurity
	 */
	public String getSocialSecurity() {
		return socialSecurity;
	}

	/**
	 * @return the birthday
	 */
	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	 * @return the addressIDs
	 */
	public Map<String, Integer> getAddresses() {
		return addressIDs;
	}

	/**
	 * @param key
	 * @param value
	 */
	public void addOrReplaceAddress(String key, StreetAddress value) {
		addressIDs.put(key, value.getId());
	}

	/**
	 * @param key
	 */
	public void removeAddress(String key) {
		addressIDs.remove(key);
	}

	/**
	 * @param key
	 * @param value
	 */
	public void addOrReplacePhone(String key, USPhoneNumber value) {
		phoneIDs.put(key, value.getId());
	}

	/**
	 * @param key
	 */
	public void removePhone(String key) {
		phoneIDs.remove(key);
	}

	/**
	 * @return the isEmpty
	 */
	@Override
	public boolean isEmpty() {
		return isEmpty;
	}

	/**
	 * @return the phoneIDs
	 */
	public Map<String, Integer> getPhones() {
		return phoneIDs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthday, firstName, lastName, middleName, socialSecurity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
				&& Objects.equals(socialSecurity, other.socialSecurity);
	}

	private boolean isEmpty = true;
	private Integer id = -1;
	private String firstName = "";
	private String middleName = "";
	private String lastName = "";
	private String socialSecurity = "";
	private LocalDate birthday;
	private final Map<String, Integer> addressIDs = new HashMap<>();
	private final Map<String, Integer> phoneIDs = new HashMap<>();

}
