package org.deroesch.sample;

import org.deroesch.models.USPhoneNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class USPhoneNumberTest {

	USPhoneNumber tenDigit = new USPhoneNumber("123", "456", "7890");
	USPhoneNumber tenPlus4 = new USPhoneNumber("123", "456", "7890", "1234");
	USPhoneNumber failure = USPhoneNumber.EMPTY_PHONE;

	@Test
	void testToString() {
		assertEquals("+1 (123) 456-7890", new USPhoneNumber("123", "456", "7890").toString());
		assertEquals("+1 (123) 456-7890", new USPhoneNumber("123", "456", "7890", "").toString());
		assertEquals("+1 (123) 456-7890 ext. 1234", new USPhoneNumber("123", "456", "7890", "1234").toString());
	}

	@Test
	void testParser() {
		assertEquals(tenDigit, USPhoneNumber.parse("123-456-7890"));
		assertEquals(tenPlus4, USPhoneNumber.parse("123-456-7890 ex. 1234"));
	}

}
