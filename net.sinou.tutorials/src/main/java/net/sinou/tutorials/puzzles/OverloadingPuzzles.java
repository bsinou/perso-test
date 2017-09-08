package net.sinou.tutorials.puzzles;

public class OverloadingPuzzles {

	/**
	 *
	 * @param args
	 *            the {@link java.lang.String} arguments (none expected here)
	 */
	public static void main(String... args) {
		OverloadingPuzzles np = new OverloadingPuzzles();
		np.testOne();
	}

	static String x1 = "";

	private void testOne() {
		executeAction(1);
		executeAction(1.0);
		executeAction(new Double("5"));
		executeAction(1L);

		System.out.println(x1);
	}

	static void executeAction(int... var) {
		x1 += "1";
	}

	static void executeAction(Integer var) {
		x1 += "2";
	}

	static void executeAction(Object var) {
		x1 += "3";
	}

//	static void executeAction(int var) {
//		x1 += "4";
//	}

	static void executeAction(short var) {
		x1 += "5";
	}

	static void executeAction(float var) {
		x1 += "6";
	}

	static void executeAction(double var) {
		x1 += "7";
	}

}
