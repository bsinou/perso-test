package net.sinou.tutorials.basics.qande.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * BasicListTests class.
 * </p>
 */
public class BasicListTests {

	private void testListRemoval() {
		// This creates a copy of the array as list
		List<String> list = new ArrayList<>(Arrays.asList("un", "un", "un", "deux"));
		System.out.println("Initial list: " + list.toString());
		// Removes the first found
		list.remove("un");
		System.out.println("After removal of first found \"un\": " + list.toString());

		// Remove all instances of "un"
		list = new ArrayList<>(Arrays.asList("un", "un", "un", "deux"));
		list.removeAll(Collections.singleton("un"));
		System.out.println("After removal of all occurences of \"un\": " + list.toString());

		try {
			// this does not create an ArrayList but creates a wrapper that is
			// backed by the initial array
			List<String> list2 = Arrays.asList("un", "un", "un", "deux");
			// So trying to remove an element will throw an Unsupported
			// operation exception, the above
			// See for more information
			// https://stackoverflow.com/questions/16748030/difference-between-arrays-aslistarray-vs-new-arraylistintegerarrays-aslist
			list2.remove("un");
		} catch (UnsupportedOperationException e) {
			System.out.println("Expected error happened: " + e.getClass().getName());
		}
	}

	/**
	 * Launches tests
	 * 
	 * @param args
	 *            launcher parameters
	 */
	public static void main(String[] args) {
		BasicListTests btl = new BasicListTests();
		btl.testListRemoval();
		btl.testCollect();
	}

	private void testCollect() {
		List<Person> roster = getRoster();
		// puts the names of the male members in a collection
		List<String> names = roster.stream().filter(p -> p.getSex() == Person.Sex.MALE).map(p -> p.getName())
				.collect(Collectors.toList());
		System.out.println("List of all men: " + names.toString());

		// groups members of the collection roster by gender:
		Map<Person.Sex, List<Person>> personByGender = roster.stream().collect(Collectors.groupingBy(Person::getSex));
		for (Person.Sex gender : personByGender.keySet())
			System.out.println("Person with gender: " + gender.name() + ": " + personByGender.get(gender).toString());

		// groups member names by gender:
		Map<Person.Sex, List<String>> nameByGender = roster.stream().collect(
				Collectors.groupingBy(Person::getSex, Collectors.mapping(Person::getName, Collectors.toList())));
		for (Person.Sex gender : nameByGender.keySet())
			System.out.println("Person with gender: " + gender.name() + ": " + nameByGender.get(gender).toString());

		// retrieves the total age of members of each gender:
		Map<Person.Sex, Integer> result = roster.stream()
				.collect(Collectors.groupingBy(Person::getSex, Collectors.summingInt(Person::getAge)));
		for (Person.Sex gender : result.keySet())
			System.out.println("Total age for all " + gender.name() + ": " + result.get(gender));

	}

	/** Returns a *READ-ONLY* list of persons */
	private List<Person> getRoster() {
		return Arrays.asList(new Person("John", 21, Person.Sex.MALE), new Person("John", 13, Person.Sex.MALE),
				new Person("Jenny", 28, Person.Sex.FEMALE), new Person("Peter", 41, Person.Sex.MALE));
	}

	static class Person {
		public static enum Sex {
			MALE, FEMALE;
		}

		Sex sex;
		String name;
		int age;

		public Person(String name, int age, Sex sex) {
			this.name = name;
			this.age = age;
			this.sex = sex;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public Sex getSex() {
			return sex;
		}

		public String toString() {
			return name + ":" + age + ":" + sex.name();
		}
	}

	class Album {
		List<Track> tracks;
		String name;
	}

	class Track {
		int rating;
	}

	void dummy(List<Album> albums) {
		// More elegant solution
		// List<Album> sortedFavs =
		albums.stream().filter(a -> a.tracks.stream().anyMatch(t -> t.rating >= 4))
				.sorted(Comparator.comparing(a -> a.name)).collect(Collectors.toList());

		List<Album> favs = albums.stream()
				.filter(a -> a.tracks.stream().filter(t -> t.rating >= 4).findFirst().isPresent())
				.collect(Collectors.toList());
		favs.sort(new Comparator<Album>() {
			public int compare(Album a1, Album a2) {
				return a1.name.compareTo(a2.name);
			}
		});
	}
}
