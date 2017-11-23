package net.sinou.tutorials.puzzles;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
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
		rep.testTerminatingSplitterAndWhiteSpace();
		rep.testInclusionRegexp();
		rep.testAnd();
		rep.testRegex();
		rep.testDynamicRegexp();
	}

	private void testAnd() {
		System.out.println("\n== Regexp basic tests");

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

	private void testDynamicRegexp() {
		System.out.println("\n== Dynamic Regexp ");

		Set<String> searchTerms = new HashSet<>();
		searchTerms.add("aa");
		searchTerms.add("bb");
		String searchString = "A very long String with some aa and bb and some more";
		applyDynamicRegexp(searchTerms, searchString);

		searchTerms = new HashSet<>();
		searchTerms.add("[\"");
		searchTerms.add(".");
		searchString = "A very long. String. with some [\"aa and bb . and some more";
		applyDynamicRegexp(searchTerms, searchString);

	}

	private void applyDynamicRegexp(Set<String> searchTerms, String searchString) {
		Pattern pat = buildPattern(searchTerms);
		Matcher matcher = pat.matcher(searchString);
		System.out.println("Checking \"" + searchString + "\" with regexp \"" + pat.toString() + "\": ");
		while (matcher.find()) {
			System.out.format("Found the text" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
					matcher.group(), matcher.start(), matcher.end());
		}
	}

	private Pattern buildPattern(Set<String> searchTerms) {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		for (String term : searchTerms)
			builder.append("(\\Q").append(term).append("\\E)").append("|");
		if (builder.length() > 0)
			builder.deleteCharAt(builder.length() - 1);
		builder.append(")");
		Pattern pattern = Pattern.compile(builder.toString());
		return pattern;
	}

	private void testTerminatingSplitterAndWhiteSpace() {
		System.out.println("\n== Terminating splitter Regexp tests");

		String testStr = "Special Test: Full Break 3* dan\\BMW(Z4)\\Diesel\\  \\";
		String testStr2 = "Special Test: Full Break 3* dan\\BMW(Z4)\\Diesel\\ \\";
		String pattern = "\\ \\";
		String pattern2 = "\\";
		String pattern3 = "[\\s]+\\";
		System.out.println(testStr.endsWith(pattern));
		System.out.println(testStr2.endsWith(pattern));
		System.out.println(testStr.endsWith(pattern2));
		System.out.println(testStr2.endsWith(pattern2));
		System.out.println(testStr.endsWith(pattern3));
		System.out.println(testStr2.endsWith(pattern3));
		System.out.println(testStr.endsWith(pattern));

	}

	private void testInclusionRegexp() {
		System.out.println("\n== Inclusion Regexp tests");
		String pattern = "\\[{2}snippet:[\\w\\-]+\\]{2}";

		String msg = "Simple example [[snippet:ref]] with some content";
		testAndLog(pattern, msg);

		msg = "Simple example [[snippet:ref]] with some content[[snippet:ref]] with some content";
		testAndLog(pattern, msg);

		msg = "Simple example with some content[[snippet:ref_io]] with some content";
		testAndLog(pattern, msg);

		msg = "Simple example with some content [snippet:youhou]] [http://:youhou]]with some content";
		testAndLog(pattern, msg);

		msg = "<p>Body 1</p>\n" + "<p>with a simple snippet:</p>\n" + "<p>[[snippet:SN-01]]</p>\n" + "<p>&nbsp;</p>\n"
				+ "<p>et hop</p>";
		testAndLog(pattern, msg);
	}

	private void testAndLog(String pattern, String msg) {
		System.out.print("Checking \"" + msg + "\": ");
		System.out.println(applyRegex(msg, pattern).orElse("No match"));
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
