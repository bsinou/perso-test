package net.sinou.tutorials.puzzles;

/**
 * Remarkable point of this puzzle: when using bitwise operators in condition
 * statements, all conditions will be checked, even if the first condition is
 * false (in a &and; case) or true (in a | case). This can be useful when you
 * want to execute a command in every situation on your conditions.
 * 
 * The other lesson: when the incremental operator is before the variable, it
 * will increment in the line you used it, when you use the post incremental
 * operator it will increment in the next time you use the variable
 */
public class LogicalOperatorsChallenge {

	/**
	 * Check and verify Logical operators conditions
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int a = 10;
		int b = 5;

		int c = 50;

		if (a == 11 & b++ == 5) {
			b++;
		}

		if (++c == 50 | a++ == 11 | a++ == 12 | a++ == 13 | a++ == 14) {
			b++;
		}

		if (++a == 14 | a++ == 15 & b++ == 6 & a == 13)
			a++;

		System.out.println(a + b + c);
	}
}
