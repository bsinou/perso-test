package net.sinou.tutorials.basics.qande.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicListTests {

	private void testListRemoval() {
		// This creates a copy of the array as list
		List<String> list = new ArrayList<>(Arrays.asList("un", "un", "un", "deux"));
		System.out.println("Initial list: " + list.toString());
		// Removes the first found
		list.remove("un");
		System.out.println("After removal of first found \"un\": " + list.toString());

		// Remove all instances of "un"
		list = new ArrayList<>(Arrays.asList("un", "un", "un", "deux"));
		list.removeAll(Collections.singleton("un"));
		System.out.println("After removal of all occurences of \"un\": " + list.toString());

		try {
			// this does not create an ArrayList but creates a wrapper that is
			// backed by the initial array
			List<String> list2 = Arrays.asList("un", "un", "un", "deux");
			// So trying to remove an element will throw an Unsupported
			// operation exception, the above
			// See for more information
			// https://stackoverflow.com/questions/16748030/difference-between-arrays-aslistarray-vs-new-arraylistintegerarrays-aslist
			list2.remove("un");
		} catch (UnsupportedOperationException e) {
			System.out.println("Expected error happened: " + e.getClass().getName());
		}
	}

	public static void main(String[] args) {
		BasicListTests btl = new BasicListTests();
		btl.testListRemoval();
	}
}
