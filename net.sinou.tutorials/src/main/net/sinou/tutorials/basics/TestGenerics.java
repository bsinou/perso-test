package net.sinou.tutorials.basics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class TestGenerics {

	private interface Tester {
		void test();
	}

	private static void test1() {
		System.out.format("This is a test %03.3f%n", 8f);
	}

	/**
	 * Write a generic method to count the number of elements in a collection
	 * that have a specific property (for example, odd integers, prime numbers,
	 * palindromes).
	 */
	private static void test2() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		int result = countOccurrences(list, e -> (e % 2) == 1);
		System.out.format("Number of odd numbers in %s : %d%n", list.toString(), result);
	}

	private static <T> int countOccurrences(Collection<T> col, Predicate<T> predicate) {
		int count = 0;
		for (T element : col) {
			if (predicate.test(element))
				count++;
		}
		return count;
	}

	/**
	 * Write a generic method to exchange the positions of two different
	 * elements in an array.
	 */
	private static void test3() {
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Integer[] intArray2 = intArray.clone();
		swapOccurrences(intArray2, 1, 4);
		System.out.format("Initial array: %s%nSwapped array: %s%n", printArray(intArray), printArray(intArray2));

		String[] strArray = { "un", "deux", "trois", "quatre", "cinq" };
		String[] strArray2 = strArray.clone();
		swapOccurrences(strArray2, 1, 4);
		System.out.format("Initial array: %s%nSwapped array: %s%n", printArray(strArray), printArray(strArray2));
	}

	private static <T> void swapOccurrences(T[] array, int i, int j) {
		int max = array.length - 1;
		if (i > max || j > max)
			throw new IllegalArgumentException("Invalid swap index");
		else if (i == j)
			return;
		else {
			T tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}
	}

	public static void main(String[] varargs) {
		performTest("test #1", TestGenerics::test1);
		performTest("test #2", TestGenerics::test2);
		performTest("test #3", TestGenerics::test3);
	}

	// Helpers
	private static void performTest(String name, Tester currTest) {
		System.out.format("Performing %s: %n", name);
		currTest.test();
		System.out.format("%n");
	}

	private static <T> String printArray(T[] arr) {
		StringBuilder builder = new StringBuilder();
		for (T elem : arr) {
			builder.append(elem.toString()).append(", ");
		}
		if (builder.length() > 2)
			return builder.substring(0, builder.length() - 2);
		else
			return "";
	}
}
