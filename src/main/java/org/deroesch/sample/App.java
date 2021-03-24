package org.deroesch.sample;

import java.util.LinkedList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		System.out.println("Hello World!");

		Integer integers[] = { 1, 2, 3 };

		for (Integer i : integers) {
			System.out.println(i);
		}

		List<String> items = new LinkedList<>();
		items.add("a");
		items.add("b");
		items.add("c");

		for (String item : items) {
			System.out.println(item);
		}

	}

}
