package org.deroesch.sample;

import org.deroesch.models.USPhoneNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class USPhoneNumberTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testToString() {

		USPhoneNumber a = new USPhoneNumber("123", "456", "7890");
		USPhoneNumber b = new USPhoneNumber("123", "456", "7890", "");
		USPhoneNumber c = new USPhoneNumber("123", "456", "7890", "1234");

		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
	}

}
