package net.sinou.tutorials.puzzles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionRemoveIfEmpty {

	public static void main(String... args) {
		List<String> arrayList = new ArrayList<>();
		arrayList.add("");
		arrayList.add(null);

		List<String> linkedList = new LinkedList<>();
		linkedList.add("");
		linkedList.add(null);

		try {
			linkedList.removeIf(String::isEmpty);
			arrayList.removeIf(String::isEmpty);
		} catch (Exception e) {
			System.out.println("Something went wrong...");
		}

		System.out.println("And the result is... " + (arrayList.size() == linkedList.size()));
	}
}
