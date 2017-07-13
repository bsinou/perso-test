package net.sinou.tutorials.puzzles;

import java.util.function.Predicate;

/**
 * <p>RegExpPuzzle class.</p>
 */
public class RegExpPuzzle {

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		RegExpPuzzle rep = new RegExpPuzzle();
		rep.testAnd();
	}

	private void testAnd() {
		Predicate<String> first = s -> s.matches("[\\w|\\W]*");
		
		System.out.println(first.test(""));
		System.out.println(first.test("8 8"));
		
		
		
		Predicate<String> second = s -> s.matches("[\\w|\\W|\\d|$|]*");
		Predicate<String> and = first.and(second);
		System.out.println(and.test("Ned Stark 777 #$"));
	}
}
