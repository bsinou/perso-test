package net.sinou.tutorials.puzzles;

public class DefaultMethodPuzzle {

	public static void main(String[] args) {

		Prince prince = new Prince() {
			public void kill() {
				// This is tricky:
				// This is the new syntax used to disambiguate methods calls
				// when having a diamond problem that has been introduced by the
				// default method of interfaces in Java 8

				// Quote: "If desired, one of the inherited methods can be
				// selected using the new syntax X.super.m(...) where X is the
				// superinterface and m the method to select:"

				// so this refers to the kill method of the super interface
				// Prince
				Prince.super.kill();
			}
		};
		prince.kill();
	}

	interface King {
		default void kill() {
			System.out.println("Sometimes you loose");
		}
	}

	interface Prince extends King {
		@Override
		default void kill() {
			System.out.println("Kill them all");
		}
	}
}
