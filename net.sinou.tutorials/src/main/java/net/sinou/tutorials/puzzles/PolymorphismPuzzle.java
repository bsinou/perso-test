package net.sinou.tutorials.puzzles;

/** Interesting use of inheritance and static blocks thanks to @Rafadelnero */
public class PolymorphismPuzzle {

	static {
		System.out.println("Static");
	}

	public static void main(String[] args) {
		class Michael extends Vito {
			{
				System.out.println("SMIke");
			}

			void execute() {
				System.out.println("IMike");
			}
		}
		Vito vito = new Michael();
		vito.execute();
	}

	static class Vito {
		{
			System.out.println("SVito");
		}

		void execute() {
			System.out.println("IVito");
		}
	}

}
