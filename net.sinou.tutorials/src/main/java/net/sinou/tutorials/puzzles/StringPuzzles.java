package net.sinou.tutorials.puzzles;

import java.util.function.Consumer;

public class StringPuzzles {

	/**
	 *
	 * @param args
	 *            the {@link java.lang.String} arguments (none expected here)
	 */
	public static void main(String... args) {
		StringPuzzles np = new StringPuzzles();
		np.testEquality();
	}

	/** Classic error */
	private void testEquality() {
		p.accept("== Test Equality");

		String first = "Hello";
		String second = "Hel" + "lo";
		String third = " mum";
		// This is true because hardcoded String are stored in a string pool, so
		// the 2 Strings are referencing the same object and are thus '=='
		p.accept("first == second: " + (first == second));
		// false: the concatenation is computed at runtime and does not use the
		// String pool
		p.accept("first + third == \"Hello mum\": " + (first + third == "Hello mum"));
	}

	// Helpers

	// Dummy pattern to play around with method reference and lambdas
	private final static Consumer<String> p = System.out::println;
}
