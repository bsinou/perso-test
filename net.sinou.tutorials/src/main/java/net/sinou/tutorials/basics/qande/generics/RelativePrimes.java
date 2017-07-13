package net.sinou.tutorials.basics.qande.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Provided solution for the relatively prime exercise, reduced in a single
 * class just to see it running
 */
public class RelativePrimes {

	/**
	 * <p>findFirst.</p>
	 *
	 * @param list a {@link java.util.List} object.
	 * @param begin a int.
	 * @param end a int.
	 * @param p a {@link java.util.function.Predicate} object.
	 * @param <T> a T object.
	 * @return a int.
	 */
	public static <T> int findFirst(List<T> list, int begin, int end, Predicate<T> p) {
		for (; begin < end; ++begin)
			if (p.test(list.get(begin)))
				return begin;
		return -1;
	}

	/**
	 * <p>gcd.</p>
	 *
	 * @param x a int.
	 * @param y a int.
	 * @return a int.
	 */
	public static int gcd(int x, int y) {
		// Nice way to find the gcd
		for (int r; (r = x % y) != 0; x = y, y = r) {
		}
		
		// int r = x % y;
		// while (r!=0){
		// x = y;
		// y = r;
		// r = x % y;
		// }
		return y;
	}

	private class RelativelyPrimePredicate implements Predicate<Integer> {
		private Collection<Integer> c;

		public RelativelyPrimePredicate(Collection<Integer> c) {
			this.c = c;
		}

		public boolean test(Integer x) {
			for (Integer i : c)
				if (gcd(x, i) != 1)
					return false;

			return c.size() > 0;
		}
	}

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 * @throws java.lang.Exception if any.
	 */
	public static void main(String[] args) throws Exception {

		List<Integer> li = Arrays.asList(3, 4, 6, 8, 11, 15, 28, 32);
		Collection<Integer> c = Arrays.asList(7, 18, 19, 25);
		Predicate<Integer> p = new RelativePrimes().new RelativelyPrimePredicate(c);

		int i = findFirst(li, 0, li.size(), p);

		if (i != -1) {
			System.out.print(li.get(i) + " is relatively prime to ");
			for (Integer k : c)
				System.out.print(k + " ");
			System.out.println();
		}
	}
}
