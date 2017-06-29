package net.sinou.tutorials.basics.qande.cards;

import java.util.Arrays;
import java.util.List;

/** Basic blueprint for a classic playing card */
public class Card {

	public final static String ACE = "Ace";
	public final static String TWO = "Two";
	public final static String THREE = "Three";
	public final static String FOUR = "Four";
	public final static String FIVE = "Five";
	public final static String SIX = "Six";
	public final static String SEVEN = "Seven";
	public final static String EIGHT = "Eight";
	public final static String NINE = "Nine";
	public final static String TEN = "Ten";
	public final static String JACK = "Jack";
	public final static String QUEEN = "Queen";
	public final static String KING = "King";

	public final static List<String> RANKS = Arrays
			.asList(new String[] { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING });

	public final static String HEARTS = "Hearts";
	public final static String SPADES = "Spades";
	public final static String DIAMONDS = "Diamonds";
	public final static String CLUBS = "Clubs";

	public final static List<String> SUITES = Arrays.asList(new String[] { HEARTS, SPADES, CLUBS, DIAMONDS });

	private final String rank;
	private final String suite;

	public Card(String rank, String suite) {
		assert (RANKS.contains(rank));
		assert (SUITES.contains(suite));

		this.rank = rank;
		this.suite = suite;
	}

	public String getRank() {
		return rank;
	}

	public String getSuite() {
		return suite;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Card))
			return false;
		else {
			Card otherCard = (Card) obj;
			return otherCard.getRank().equals(this.rank) && otherCard.getSuite().equals(this.suite);
		}
	}

	@Override
	public String toString() {
		return this.rank + " of " + this.suite;
	}
}
