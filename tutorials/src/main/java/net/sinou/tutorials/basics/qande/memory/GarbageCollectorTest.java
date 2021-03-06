package net.sinou.tutorials.basics.qande.memory;

/**
 * From https://nobugsproject.com/2017/06/20/java-challenge-garbage-collector/
 */
public class GarbageCollectorTest {

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		HowManyObjectsWillBeCleanedByTheGarbageCollector gc = new GarbageCollectorTest().new HowManyObjectsWillBeCleanedByTheGarbageCollector();

		gc.executeAction();

		System.out.println("How many objects are eligible be collected by " + "the Garbage Collector after "
				+ "the executeAction() method invokation?" + gc);
	}

	private class HowManyObjectsWillBeCleanedByTheGarbageCollector {
		private Character homer = new Character("Dooh");
		private Character misterBurns = new Character("you are fired");
		private Character bart = new Character("eat my shorts");
		private Character elBarto;

		public void executeAction() {
			homer.talk();
			misterBurns.talk();
			makeTwoCharactersTalk(misterBurns, homer);

			misterBurns = null;

			elBarto = bart;
			bart = null;

			elBarto.talk();
		}

		private void makeTwoCharactersTalk(Character misterBurns, Character homer) {
			misterBurns.talk();
			homer.talk();

			misterBurns = null;
			homer = null;
		}
	}
}

class Character {
	private String talk;

	/**
	 * <p>Constructor for Character.</p>
	 *
	 * @param talk a {@link java.lang.String} object.
	 */
	public Character(String talk) {
		this.talk = talk;
	}

	/**
	 * <p>talk.</p>
	 */
	public void talk() {
		System.out.println(this.talk);
	}
}
