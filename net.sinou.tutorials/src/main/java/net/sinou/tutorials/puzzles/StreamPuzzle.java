package net.sinou.tutorials.puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Test and verify various puzzles gathered on the internet via the
 * #100DaysOfJava hashtag
 */
public class StreamPuzzle {

	/**
	 * <p>main.</p>
	 *
	 * @param args a {@link java.lang.String} object.
	 */
	public static void main(String... args) {

		StreamPuzzle sp = new StreamPuzzle();
		sp.map1();

		sp.map2();

	}

	/** What will be printed? */
	private void map1() {
		List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
		Map<String, String> map = new HashMap<>();
		// Creates a new record with form (key=o, value=o, by instance for
		// "one")
		// The ending concat calls are effectless because the returned value is
		// never stored
		// Five will be skipped because it starts with a f like four (same for 3
		// and 7)
		strings.forEach(s -> map.computeIfAbsent("" + s.charAt(0), String::new).concat(",").concat(s));
		System.out.println("Resulting map: " + map);
		// returns: "f: f"
		System.out.println("f: " + map.get("f"));
	}

	/** What will be printed? */
	private void map2() {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		// Integer are objects, so we must use equals to compare them
		list.removeIf(e -> e == new Integer(10) || e.equals(new Integer(20)));
		System.out.println(list);
	}
}
