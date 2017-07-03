package net.sinou.tutorials.basics.qande.collections;

import java.util.NavigableSet;
import java.util.TreeSet;

public class BasicSetTests {

	private void testSetRemoval() {

		NavigableSet<String> original = new TreeSet<>();
		original.add("1");
		original.add("2");
		original.add("3");

		NavigableSet<String> descending = original.descendingSet();
		descending.remove("1");
		System.out.format("Original after removal on descending: %s\n", original.toString());
		
		// This also remove the element in the backing original set
		String val = descending.pollLast();
		System.out.format("Polled elem: %s\nOriginal after poll on descending: %s", val, original.toString());
	}

	public static void main(String[] args) {
		BasicSetTests bst = new BasicSetTests();
		bst.testSetRemoval();
	}
}
