package net.sinou.tutorials.basics;

/**
 * <p>
 * Algorithm class.
 * </p>
 */
public final class Algorithm {
	/**
	 * <p>
	 * max.
	 * </p>
	 *
	 * @param <T>
	 *            the considered type.
	 * @param x
	 *            a T object.
	 * @param y
	 *            a T object.
	 * @return the greatest T object
	 */
	public static <T extends Comparable<T>> T max(T x, T y) {
		return x.compareTo(y) > 0 ? x : y;
	}
}
