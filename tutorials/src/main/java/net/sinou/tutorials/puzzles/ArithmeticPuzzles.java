package net.sinou.tutorials.puzzles;

public class ArithmeticPuzzles {

	public static void main(String[] args) {

		ArithmeticPuzzles ap = new ArithmeticPuzzles();
		ap.simple();
	}

	/**
	 * 0123 means octal 123, that is 1*8*8 + 2*8 + 3, which equals 83
	 */
	private void simple() {
		// will print 3293, parsed as octal notation
		System.out.println(0123 + 3210);
		// will print the expected 3333
		System.out.println(123 + 3210);
	}
}
