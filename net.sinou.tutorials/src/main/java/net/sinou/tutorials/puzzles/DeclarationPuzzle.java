package net.sinou.tutorials.puzzles;

public class DeclarationPuzzle {

	int nobugs = getInt();
	int noStress = 50;

	public int getInt() {
		// will return 1: nostress has not been explicitly initiated and is thus still
		// to default aka 0
		return noStress + 1;
	}

	public static void main(String... args) {
		DeclarationPuzzle d = new DeclarationPuzzle();
		System.out.println(d.nobugs + " " + d.noStress);
	}
}
