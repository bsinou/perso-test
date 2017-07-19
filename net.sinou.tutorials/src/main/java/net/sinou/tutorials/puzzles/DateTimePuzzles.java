package net.sinou.tutorials.puzzles;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

/** Test and explore date time puzzles */
public class DateTimePuzzles {

	/**
	 * @param args
	 *            the {@link java.lang.String} arguments (none expected here)
	 */
	public static void main(String... args) {
		DateTimePuzzles dtp = new DateTimePuzzles();
		dtp.testPeriod();
	}

	/** Classic error */
	private void testPeriod() {
		System.out.println("== Test Period");

		List<Costume> costumeList = Arrays.asList(new Costume("The Spider Man", LocalDate.of(1962, Month.SEPTEMBER, 8)),
				new Costume("The Black Suit", LocalDate.of(1984, Month.SEPTEMBER, 8)),
				new Costume("Spider-Man 2099", LocalDate.of(1992, Month.SEPTEMBER, 8)));

		LocalDate now = LocalDate.of(2017, Month.SEPTEMBER, 8);

		costumeList.stream().forEach(s -> {
			Period p = Period.between(s.creationDate, now);
			System.out.println(s.name + " costume has " + p.get(ChronoUnit.YEARS) + " years");
		});
	}

	private static class Costume {
		private String name;
		private LocalDate creationDate;

		public Costume(String name, LocalDate creationDate) {
			this.name = name;
			this.creationDate = creationDate;
		}
	}
	// Helpers
}
