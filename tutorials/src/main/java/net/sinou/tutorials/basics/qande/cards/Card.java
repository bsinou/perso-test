package net.sinou.tutorials.basics.qande.cards;

import java.util.Arrays;
import java.util.List;

/**
 * Basic blueprint for a classic playing card
 */
public class Card {

	/** Constant <code>ACE="Ace"</code> */
	public final static String ACE = "Ace";
	/** Constant <code>TWO="Two"</code> */
	public final static String TWO = "Two";
	/** Constant <code>THREE="Three"</code> */
	public final static String THREE = "Three";
	/** Constant <code>FOUR="Four"</code> */
	public final static String FOUR = "Four";
	/** Constant <code>FIVE="Five"</code> */
	public final static String FIVE = "Five";
	/** Constant <code>SIX="Six"</code> */
	public final static String SIX = "Six";
	/** Constant <code>SEVEN="Seven"</code> */
	public final static String SEVEN = "Seven";
	/** Constant <code>EIGHT="Eight"</code> */
	public final static String EIGHT = "Eight";
	/** Constant <code>NINE="Nine"</code> */
	public final static String NINE = "Nine";
	/** Constant <code>TEN="Ten"</code> */
	public final static String TEN = "Ten";
	/** Constant <code>JACK="Jack"</code> */
	public final static String JACK = "Jack";
	/** Constant <code>QUEEN="Queen"</code> */
	public final static String QUEEN = "Queen";
	/** Constant <code>KING="King"</code> */
	public final static String KING = "King";

	/** Constant <code>RANKS</code> */
	public final static List<String> RANKS = Arrays
			.asList(new String[] { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING });

	/** Constant <code>HEARTS="Hearts"</code> */
	public final static String HEARTS = "Hearts";
	/** Constant <code>SPADES="Spades"</code> */
	public final static String SPADES = "Spades";
	/** Constant <code>DIAMONDS="Diamonds"</code> */
	public final static String DIAMONDS = "Diamonds";
	/** Constant <code>CLUBS="Clubs"</code> */
	public final static String CLUBS = "Clubs";

	/** Constant <code>SUITES</code> */
	public final static List<String> SUITES = Arrays.asList(new String[] { HEARTS, SPADES, CLUBS, DIAMONDS });

	private final String rank;
	private final String suite;

	/**
	 * <p>Constructor for Card.</p>
	 *
	 * @param rank a {@link java.lang.String} object.
	 * @param suite a {@link java.lang.String} object.
	 */
	public Card(String rank, String suite) {
		assert (RANKS.contains(rank));
		assert (SUITES.contains(suite));

		this.rank = rank;
		this.suite = suite;
	}

	/**
	 * <p>Getter for the field <code>rank</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * <p>Getter for the field <code>suite</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getSuite() {
		return suite;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Card))
			return false;
		else {
			Card otherCard = (Card) obj;
			return otherCard.getRank().equals(this.rank) && otherCard.getSuite().equals(this.suite);
		}
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return this.rank + " of " + this.suite;
	}
}
