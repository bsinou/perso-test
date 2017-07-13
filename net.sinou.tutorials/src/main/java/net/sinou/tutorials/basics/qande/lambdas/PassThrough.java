package net.sinou.tutorials.basics.qande.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Patterns and tests for Lambdas and method references:
 *
 * Quote from:
 * https://www.ibm.com/developerworks/library/j-java8idioms5/index.html
 * "Whenever you see a lambda expression whose sole purpose is to pass
 * parameters to one or more other functions, consider whether that lambda would
 * be better replaced by a method reference.
 *
 * The deciding factor is that no real work is being done inside the lambda
 * expression. In that case, the lambda expression is a pass-through, and the
 * syntax is probably too complex for the task at hand."
 */
public class PassThrough {

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {

		PassThrough pt = new PassThrough();
		pt.passThroughLambdas();
	}

	private void passThroughLambdas() {
		List<String> names = Arrays.asList("John", "Nicole", null, "foo");

		// The lambda expression of the target behaviour
		List<String> nonNullNamesInUpperCase = names.stream().filter(name -> Objects.nonNull(name))
				.map(name -> name.toUpperCase())
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> Collections.unmodifiableList(list)));
		System.out.println(nonNullNamesInUpperCase);

		// Same thing with method references
		List<String> nonNullNamesInUpperCase2 = names.stream().filter(Objects::nonNull).map(String::toUpperCase)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
		System.out.println(nonNullNamesInUpperCase2);

		// Same thing but resulting list is mutable
		List<String> nonNullNamesInUpperCase3 = names.stream().filter(Objects::nonNull).map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println(nonNullNamesInUpperCase3);

		try {
			nonNullNamesInUpperCase2.remove(0);
			throw new RuntimeException("Bug: no element can be removed from an immutable list");
		} catch (Exception e) {
			// expected
		}
		nonNullNamesInUpperCase3.remove(0);
		System.out.println("Mutable tests");
		System.out.println(nonNullNamesInUpperCase2);
		System.out.println(nonNullNamesInUpperCase3);
	}
}
