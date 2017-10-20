package net.sinou.tutorials.puzzles;

/**
 * Verify answer for the puzzle of the day, see #100DaysOfJava
 */
public class InheritencePuzzle {

	static final int FORCE = 10;

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {

		DV dv = new DV() {
			public int getNumber(int number) {
				return number;
			}
		};

		InheritencePuzzle ip = new InheritencePuzzle();

		MY my = ip.new MY() {
			public int getNumber(int number) {
				return number;
			}
		};

		System.out.println(dv.getNumber(FORCE));
		System.out.println(my.getNumber(new Integer(FORCE)));
		System.out.println(my.getNumber(FORCE));
		System.out.println("The stronger Jedi is: " + (dv.getNumber(FORCE) > my.getNumber(FORCE) ? "DV" : "MY"));
	}

	abstract class MY implements LS {
		public int getNumber(Integer force) {
			return force + 10;
		}
	}

	interface LS extends DV {
		int getNumber(int force);
	}

	interface DV {
		int getNumber(int force);
	}
}
