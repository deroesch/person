package org.deroesch.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
	public static void main(String[] args) {
		final String regex = "(?=(?:^(?:\\+?1\\s*(?:[.-]\\s*)?)?(?!(?:(?:.*\\(.*)|(?:.*\\).*)))(?:[2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))|(?:.*\\((?:[2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\).*))(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(?([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\)?)\\s*(?:[.-]\\s*)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d{1,15}))?$";
		final String string = "// valid\n" + "(555)555-5555\n" + "1 (555) 555-5555\n" + "1 (555)-555-5555\n"
				+ "555-555-5555\n" + "+1-555-532-3455\n" + "1-555-532-3455\n" + "1-555-532-3455 ext 4\n"
				+ "1 (555) 555-5555 extension 123456789123456\n\n" + "// invalid\n" + "555-5555\n" + "1234567890\n"
				+ "555--555-5555\n" + "555-555--5555\n" + "1234567\n" + "((555))555-5555\n" + "invalidphone\n"
				+ "+91 (123) 456-7890\n" + "123.456.7890\n" + "1 (555) 555-5555 extension 0123456789012345";

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(string);

		while (matcher.find()) {
			System.out.println("Full match: " + matcher.group(0));

			for (int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println("Group " + i + ": " + matcher.group(i));
			}
		}
	}
}