package net.sinou.tutorials.puzzles;

import java.math.BigDecimal;

/**
 * The result of division by zero is, mathematically speaking, undefined, which
 * can be expressed with a float/double as NaN - not a number.
 * 
 * As an integer or a long must hold a specific numerical value, an error must
 * be thrown on division by zero when dealing with them.
 * 
 * Same for big decimal. NOTE: this interesting link lists a large number of
 * possible traps and mistakes when working with big decimals:
 * http://www.stichlberger.com/software/java-bigdecimal-gotchas
 *
 */

public class DivisionByZeroChallenges {

	public static void main(String... args) {
		DivisionByZeroChallenges dbz = new DivisionByZeroChallenges();

		dbz.forInt();
		dbz.forLong();
		dbz.forFloat();
		dbz.forDouble();
		dbz.forBigDecimal();
	}

	private void forInt() {
		try {
			int x = 1;
			int y = 0;
			System.out.println(x / y);
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException: int divisions do not accept 0 as divisor");
		}
	}

	private void forLong() {
		try {
			long x = 1;
			long y = 0;
			System.out.println(x / y);
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException: long divisions do not accept 0 as divisor");
		}
	}

	private void forFloat() {
		try {
			float x = 1;
			float y = 0;
			System.out.println(x / y);
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException: float divisions do not accept 0 as divisor");
		}
	}

	private void forDouble() {
		try {
			double x = 1;
			double y = 0;
			System.out.println(x / y);
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException: double divisions do not accept 0 as divisor");
		}
	}

	/**
	 * Be sure to check *
	 * http://www.stichlberger.com/software/java-bigdecimal-gotchas
	 * 
	 */
	private void forBigDecimal() {
		try {
			BigDecimal x = new BigDecimal("1");
			BigDecimal y = new BigDecimal("0");
			System.out.println(x.divide(y));
			// could also be written:
			System.out.println(BigDecimal.ONE.divide(BigDecimal.ZERO));
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException: BigDecimal divisions do not accept 0 as divisor");
		}
	}
}
