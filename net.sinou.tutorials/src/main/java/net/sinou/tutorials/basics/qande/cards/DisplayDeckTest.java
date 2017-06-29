package net.sinou.tutorials.basics.qande.cards;

public class DisplayDeckTest {

	public static void main(String[] args) {
		Deck deck = new Deck();
		for (Card card : deck.getAllCards())
			System.out.println(card.toString());
	}
}
