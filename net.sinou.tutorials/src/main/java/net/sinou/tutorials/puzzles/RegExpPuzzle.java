package net.sinou.tutorials.puzzles;

import java.util.function.Predicate;

/**
 * Some regexp puzzles.
 */
public class RegExpPuzzle {

	/**
	 * @param args
	 *            an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		RegExpPuzzle rep = new RegExpPuzzle();
		rep.testAnd();
	}

	private void testAnd() {
		// tricky (false) syntax : [\w|\W]* (I replaced the \\ for lisibility
		// the | character is not a special character in regexp: (and is
		// included in \W)

		// Similarly: [\w|\W|\d|$|]* is equivalent to [\w\W\d$|]*


		Predicate<String> first = s -> s.matches("[\\w|\\W]*");
		Predicate<String> second = s -> s.matches("[\\w|\\W|\\d|$|]*");
		// Equivalent to
		second = s -> s.matches("[\\w\\W\\d$|]*");
		Predicate<String> and = first.and(second);
		System.out.println(and.test("Ned Stark 777 #$"));
		// returns true
		
		// another test
		Predicate<String> other = s -> s.matches("b[a]*b");
		System.out.println(other.test("bb"));
		System.out.println(other.test("bab"));
		System.out.println(other.test("8 8"));
	}

}
