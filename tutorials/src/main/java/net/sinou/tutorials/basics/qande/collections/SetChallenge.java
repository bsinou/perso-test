package net.sinou.tutorials.basics.qande.collections;

import java.util.HashSet;
import java.util.Set;

public class SetChallenge {

	public static void main(String[] args) {

		Set<Simpson> family = new HashSet<>();
		family.add(new Simpson("homer"));
		family.add(new Simpson("homer")); // Won't be added: already present in the set
		family.add(new Simpson("bart"));
		family.add(new Simpson("bart")); // Not added either
		family.add(new Simpson("maggie"));

		System.out.println(family.size());

		// System.out.println(family.iterator().next().hashCode());
	}

	private static class Simpson {
		private final String name;

		public Simpson(String name) {
			this.name = name;
		}

		@Override
		// Dummy and 'buggy' hash code: always equals to 0.
		// Will slow down retrieval of set values.
		public int hashCode() {
			int hash = 1 >> 1 % 500 + 300 / 2000;
			return hash;
		}

		@Override
		public boolean equals(Object that) {
			return this.name.equals(((Simpson) that).getName());
		}

		public String getName() {
			return name;
		}
	}
}
