package net.sinou.tutorials.basics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * From:
 * https://docs.oracle.com/javase/tutorial/java/generics/QandE/generics-questions.html
 */

public class GenericExercices {

	public static void main(String[] args) {
		ex1();
		ex2();
		ex3();
	}

	/**
	 * Write a generic method to count the number of elements in a collection that
	 * have a specific property (for example, odd integers, prime numbers,
	 * palindromes).
	 */
	private static void ex1() {
		List<String> list = Arrays.asList("One", "Two", "Three");
		Predicate<String> tester = s -> s.toLowerCase().lastIndexOf('o') >= 0;
		System.out.println(count(list, tester));

		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Predicate<Integer> tester2 = i -> i % 2 == 1;
		System.out.println(count(list2, tester2));

	}

	private static <T> long count(Collection<T> elements, Predicate<T> tester) {
		return elements.stream().filter(tester).count();
	}

	/**
	 * Write a generic method to exchange the positions of two different elements in
	 * an array.
	 */
	private static void ex2() {
		Integer[] ints = { 1, 3, 2, 4 };
		System.out.println("Before swap: " + printableArray(ints));
		swap(ints, 1, 2);
		System.out.println("After swap: " + printableArray(ints));

		String[] strs = { "One", "Three", "Two", "Four" };
		System.out.println("Before swap: " + printableArray(strs));
		swap(strs, 1, 2);
		System.out.println("After swap: " + printableArray(strs));
	}

	private static <T> String printableArray(T[] arr) {
		StringBuilder builder = new StringBuilder("[ ");
		Arrays.stream(arr).forEach(t -> builder.append(t).append(" "));
		builder.append("]");
		return builder.toString();
	}

	private static <T> void swap(T[] items, int i, int j) {
		if (i == j)
			return;
		if (i < 0 || i > items.length - 1 || j < 0 || j > items.length - 1)
			throw new IllegalArgumentException();
		T tmp = items[i];
		items[i] = items[j];
		items[j] = tmp;
	}

	/**
	 * Write a generic method to find the maximal element in the range [begin, end)
	 * of sa List
	 */
	private static void ex3() {
		List<Integer> ints = Arrays.asList(1, 3, 2, 4, 5);
		System.out.println("Max value in " + printableArray(ints.toArray()) + ": " + findMax(ints));
		System.out
				.println("Max value in " + printableArray(ints.toArray()) + " for i in [2,3): " + findMax(ints, 2, 3));
		System.out.println(
				"Max value in " + printableArray(ints.toArray()) + " between index 0 and 4: " + findMax(ints, 0, 4));

		List<String> strs = Arrays.asList("One", "Three", "Two", "Four", "Zero", "a");
		System.out.println("Max value in " + printableArray(strs.toArray()) + ": " + findMax(strs));
		System.out.println(
				"Max value in " + printableArray(strs.toArray()) + " between index 2 and 3: " + findMax(strs, 2, 3));
		System.out.println(
				"Max value in " + printableArray(strs.toArray()) + " between index 0 and 5: " + findMax(strs, 0, 5));
	}

	private static <T extends Comparable<T>> T findMax(List<T> items) {
		return items.stream().max(T::compareTo).orElse(null);
	}

	private static <T extends Comparable<T>> T findMax(List<T> items, int i, int j) {
		T max = items.get(i);
		for (++i; i < j; ++i)
			if (items.get(i).compareTo(max) > 0)
				max = items.get(i);
		return max;
	}
}
