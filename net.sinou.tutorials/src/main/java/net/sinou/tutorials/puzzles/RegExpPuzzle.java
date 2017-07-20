package net.sinou.tutorials.puzzles;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		rep.testRegex();
	}

	private void testAnd() {
		System.out.println("== Regexp basic tests");

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

		// another test
		Predicate<String> other = s -> s.matches("b[a]*b");
		System.out.println(other.test("bb"));
		System.out.println(other.test("bab"));
		System.out.println(other.test("8 8"));
	}

	private void testRegex() {
		System.out.println("== Regexp Advanced tests");

		mailRegex("+a.ab.cd|");
		mailRegex("+a");

		internalTestRegex("test123");
		mailRegex("test123");
		internalTestRegex("lisa@gmail\\\\com");
		mailRegex("lisa@gmail\\\\com");
		internalTestRegex("lisa@gmail.com");
		mailRegex("lisa@gmail.com");
		internalTestRegex("misterburns$gmail.com");
		mailRegex("misterburns$gmail.com");
		internalTestRegex("homer_simpson@hotmail<com");
		mailRegex("homer_simpson@hotmail<com");
		internalTestRegex("elbarto_prankster@gmail>com");
		mailRegex("elbarto_prankster@gmail>com");
		internalTestRegex("margie*gmail>com");
		mailRegex("margie*gmail>com");
		mailRegex("jack.london2@apps.example-de.fr");
		mailRegex("jack.london2_do.penny@apps.example-de.berlin");
		mailRegex("jack.london2_do.penny89990@apps.example-de.berlin");
	}

	private void internalTestRegex(String msg) {
		String pattern = "^[_A-Za-z0-9-\\+]+" //
				+ "(\\.[A-Za-z0-9-_]+)*" //
				+ "[@|$]" //
				+ "[A-Za-z0-9-]+" //
				+ "([\\.|<][A-Za-z0-9]+)*"//
				+ "([\\.<][A-Za-z]{2,})$";//
		System.out.print("Checking " + msg + ": ");
		System.out.println(applyRegex(msg, pattern).orElse("No match"));
	}

	private void mailRegex(String msg) {
		String pattern = "^" // line begin
				+ "[A-Za-z0-9_-[\\.]]+"// 1 or N of these chars
				+ "@" //
				+ "[A-Za-z0-9-_]+" //
				+ "(\\.[A-Za-z0-9-_]+)*"//
				+ "(\\.[A-Za-z]{2,})" // suffix
				+ "$";// end of line
		System.out.print("Mail check " + msg + ": ");
		System.out.println(applyRegex(msg, pattern).orElse("No match"));
	}

	Optional<String> applyRegex(String msg, String patternStr) {
		final Pattern r = Pattern.compile(patternStr);
		final Matcher m = r.matcher(msg);
		String result = null;
		if (m.find())
			result = "Found matching value': " + m.group(0);
		return Optional.ofNullable(result);
	}
}
