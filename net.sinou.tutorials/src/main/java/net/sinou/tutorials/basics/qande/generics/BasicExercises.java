package net.sinou.tutorials.basics.qande.generics;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Basic questions about generics, must be run via -ea VM argument to check
 * assertions
 */
public class BasicExercises {

	/**
	 * Write a generic method to count the number of elements in a collection
	 * that have a specific property (for example, odd integers, prime numbers,
	 * palindromes).
	 */
	private <T> int countElem(Collection<T> elements, Predicate<T> predicate) {
		int i = 0;
		for (T e : elements) {
			if (predicate.test(e))
				++i;
		}
		return i;
	}

	private void testCount() {
		// Palindromes
		Predicate<String> isPalindrom = (s -> {
			// corner cases
			if (s == null)
				return false;
			else if (s.length() == 0)
				return true;

			char[] letters = s.toCharArray();
			for (int i = 0; i < letters.length / 2; i++)
				if (letters[i] != letters[letters.length - 1 - i])
					return false;
			return true;
		});

		List<String> pals = Arrays.asList("john", "elle", "kayak", "foo");
		int result = countElem(pals, isPalindrom);
		assert (result == 2);

		// Odd integers
		List<Integer> ints = Arrays.asList(1, 2, 3, 4, 19);
		result = countElem(ints, i -> i % 2 == 1);
		assert (result == 3);

		// Primary numbers
		Predicate<Integer> isPrimaryNumber = (i -> true);
		result = countElem(ints, isPrimaryNumber);
		assert (result == 5);
	}

	/**
	 * Write a generic method to exchange the positions of two different
	 * elements in an array
	 */
	private <T> void swapElement(T[] elements, int first, int second) {
		if (first == second)
			return;
		if (first >= elements.length || second >= elements.length)
			throw new IllegalArgumentException(
					"Out of range: swap indexes cannot be greater than " + (elements.length - 1));
		T tmpElement = elements[first];
		elements[first] = elements[second];
		elements[second] = tmpElement;
	}

	private void testSwap() {
		String[] strings = { "john", "elle", "kayak", "foo" };
		swapElement(strings, 0, 3);

		Integer[] ints = { 1, 2, 3, 4, 19 };
		swapElement(ints, 1, 4);

	}

	/**
	 * Write a generic method to find the maximal element in the range [begin,
	 * end) of a list.
	 */
	private <T extends Comparable<T>> T findMax(List<T> elems, int begin, int end) {
		// TODO implements corner cases and checks

		// T result = null;
		// for (int i = begin; i < end; i++) {
		// if (result == null)
		// result = elems.get(i);
		// else if (elems.get(i).compareTo(result) > 0)
		// result = elems.get(i);
		// }

		// Provided solution is more elegant:
		T result = elems.get(begin);
		for (++begin; begin < end; ++begin)
			if (elems.get(begin).compareTo(result) > 0)
				result = elems.get(begin);

		return result;
	}

	private void testFindMax() {
		List<String> pals = Arrays.asList("john", "elle", "kayak", "foo", "xylophone", "zanzibar");
		String sResult = findMax(pals, 1, 5);
		// end index is excluded
		assert (sResult.equals("xylophone"));
	}

	/**
	 * How do you invoke the following method to find the first integer in a
	 * list that is relatively prime to a list of specified integers?
	 * 
	 * public static <T> int findFirst(List<T> list, int begin, int end,
	 * UnaryPredicate<T> p)
	 * 
	 * Note that two integers a and b are relatively prime if gcd(a, b) = 1,
	 * where gcd is short for greatest common divisor.
	 */
	public static <T> int findFirst(List<T> list, int begin, int end, Predicate<T> p) {
		for (int j = begin; j <= end; j++) {
			if (p.test(list.get(j)))
				return j;
		}
		return -1;
	}

	private void testFindFirst() {
		List<Integer> pals = Arrays.asList(1, 2, 4, 17, 6, 13, 17);

		List<BigInteger> compareWith = Arrays.asList(new BigInteger("23"), new BigInteger("2"), new BigInteger("4"),
				new BigInteger("6"), new BigInteger("13"));

		Predicate<Integer> predicate = (i -> {
			BigInteger bi = new BigInteger(i.toString());
			for (BigInteger ref : compareWith)
				if (bi.gcd(ref).compareTo(BigInteger.ONE) > 0)
					return false;
			return true;
		});

		int result = findFirst(pals, 1, 5, predicate);
		assert (result == 3);
	}

	public static void main(String[] args) {
		BasicExercises exercises = new BasicExercises();
		exercises.testCount();
		exercises.testSwap();
		exercises.testFindMax();
		exercises.testFindFirst();
	}
}
