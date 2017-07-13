package net.sinou.tutorials.basics.qande.cards;

/**
 * <p>DisplayDeckTest class.</p>
 */
public class DisplayDeckTest {

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		Deck deck = new Deck();
		for (Card card : deck.getAllCards())
			System.out.println(card.toString());
	}
}
