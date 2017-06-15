package net.sinou.tutorials.puzzles;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamPuzzle {

	public static void main(String... args) {
		List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");
		Map<String, String> map = new HashMap<>();
		strings.forEach(s -> map.computeIfAbsent("" + s.charAt(0), String::new).concat(",").concat(s));
		System.out.println("f: "+ map.get("f"));
	}
}
