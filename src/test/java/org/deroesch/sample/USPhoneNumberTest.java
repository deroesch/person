package org.deroesch.sample;

import org.deroesch.models.USPhoneNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class USPhoneNumberTest {

	@Test
	void testToString() {
		assertEquals("+1 (123) 456-7890", new USPhoneNumber("123", "456", "7890").toString());
		assertEquals("+1 (123) 456-7890", new USPhoneNumber("123", "456", "7890", "").toString());
		assertEquals("+1 (123) 456-7890 ext. 1234", new USPhoneNumber("123", "456", "7890", "1234").toString());
	}

}
