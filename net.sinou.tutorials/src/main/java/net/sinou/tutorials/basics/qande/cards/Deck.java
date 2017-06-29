package net.sinou.tutorials.basics.qande.cards;

import java.util.ArrayList;
import java.util.List;

/** A basic full set of card */
public class Deck {

	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<>();
		for (String suite : Card.SUITES)
			for (String rank : Card.RANKS)
				cards.add(new Card(rank, suite));
	}

	public Card getCard(int index) {
		if (index < 0 || index >= cards.size())
			throw new IllegalArgumentException("We only have " + cards.size() + " on deck, cannot get the " + index);
		else
			return cards.get(index - 1);
	}

	public List<Card> getAllCards() {
		return cards;
	}

	public void shuffle() {
		// TODO implement shuffling
	}
}
