package net.sinou.tutorials.puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Test and verify various puzzles gathered on the internet via the
 * #100DaysOfJava hashtag
 */
public class StreamPuzzles {

	/**
	 *
	 * @param args
	 *            a {@link java.lang.String} object.
	 */
	public static void main(String... args) {

		StreamPuzzles sp = new StreamPuzzles();
		sp.map1();
		sp.map2();
		sp.consumerPuzzle();
		sp.simpsonPuzzle();
		sp.optionalPuzzle();
	}

	/** What will be printed? */
	private void map1() {
		System.out.println("== ComputeIfAbsent test");

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
		System.out.println("== RemoveIf test");

		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		// Integer are objects, so we must use equals to compare them
		list.removeIf(e -> e == new Integer(10) || e.equals(new Integer(20)));
		System.out.println(list);
	}

	/** One of Raphael Del Nero Puzzle: what will be printed out? */
	private void consumerPuzzle() {
		System.out.println("== Consumer puzzle");
		List<String> srcList = new ArrayList<>();
		srcList.add("D");
		srcList.add("A");
		srcList.add("T");
		List<String> resultList = new ArrayList<>();
		Consumer<String> c1 = System.out::println;
		Consumer<String> c2 = resultList::add;
		Consumer<String> c3 = c -> resultList.removeIf(e -> e.matches("T"));
		srcList.forEach(c2.andThen(c1).andThen(c3));
		System.out.println(resultList);

		// The same result with streams and functional programming
		System.out.println(Stream.of("D", "A", "T").peek(System.out::println).filter(e -> !e.matches("T"))
				.collect(Collectors.toList()));
	}

	private void simpsonPuzzle() {
		System.out.println("== Simpson Puzzle");

		List<Simpson> list = Arrays.asList(new Simpson("Homer", 35), new Simpson("Maggie", 30), new Simpson("Bart", 10),
				new Simpson("Lisa", 8));
		Integer simpsonAge = list.stream().map(e -> e.age).filter(age -> age >= 20).min(Comparator.naturalOrder())
				.get();
		System.out.println(Optional.of(simpsonAge).orElse(2));
	}

	private static class Simpson {

		int age;
		@SuppressWarnings("unused")
		String name;

		public Simpson(String name, int age) {
			this.name = name;
			this.age = age;
		}
	}

	private void optionalPuzzle() {
		System.out.println("== Optional Puzzle");

		List<String> list = Arrays.asList("A", "B", "M", "W");
		Optional<String> op = list.stream().findFirst();
		Optional<String> op2 = list.stream().filter(e -> e.equals("N")).findAny();

		System.out.println(op.orElse(""));
		System.out.println(op2.orElse("Double"));
	}
}
