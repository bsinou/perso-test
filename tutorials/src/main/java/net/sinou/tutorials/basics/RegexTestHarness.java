package net.sinou.tutorials.basics;

import java.io.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Enable 'live' testing of regular expressions
 *
 * Note: The word "class" in the phrase "character class" does not refer
 * to a .class file. In the context of regular expressions, a character class is
 * a set of characters enclosed within square brackets. It specifies the
 * characters that will successfully match a single character from a given input
 * string.
 *
 * @see <a href=
 *      "https://docs.oracle.com/javase/tutorial/essential/regex/test_harness.html">
 *      Oracle tutorial on regexp</a>
 * 
 * 
 */
public class RegexTestHarness {

	/**
	 * @param args
	 *            an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		Console console = System.console();
		if (console == null) {
			System.err.println("No console.");
			System.exit(1);
		}
		while (true) {

			Pattern pattern = Pattern.compile(console.readLine("%nEnter your regex: "));

			Matcher matcher = pattern.matcher(console.readLine("Enter input string to search: "));

			boolean found = false;
			while (matcher.find()) {
				console.format("I found the text" + " \"%s\" starting at " + "index %d and ending at index %d.%n",
						matcher.group(), matcher.start(), matcher.end());
				found = true;
			}
			if (!found) {
				console.format("No match found.%n");
			}
		}
	}
}
