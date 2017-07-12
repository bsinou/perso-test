package net.sinou.tutorials.puzzles;

import java.util.ArrayList;
import java.util.List;

/** Very useless puzzle... Just a typo in the comparing String */
public class MethodRefPuzzle {

	public static void main(String[] args) {

		List<Talker> talkers = new ArrayList<>();
		talkers.add(new Talker());
		talkers.add(new Talker());
		talkers.add(new Talker());

		talkers.removeIf(e -> e.talk.equals("Hello"));
		talkers.forEach(System.out::println);
	}

	static class Talker {
		String talk = "Hello!";

		public String toString() {
			return talk;
		}
	}
}
