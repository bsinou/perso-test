package net.sinou.tutorials.basics.qande.reflection;

import static java.lang.System.out;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * Some patterns about reflections
 */
public class ReflectionBasics {

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		ReflectionBasics rb = new ReflectionBasics();
		rb.testClassRetrieval();
		rb.spyClasses();
	}

	private void spyClasses() {
		Class<? extends Object> clazz;

		clazz = this.getClass();
		spy(clazz);

		clazz = ConcurrentNavigableMap.class;
		spy(clazz);

		clazz = SecurityException.class;
		spy(clazz);
	}

	// @SuppressWarnings({"unchecked", "rawtypes"})
	private void testClassRetrieval() {

		Class<? extends Object> clazz;

		// Best way to retrieve a primitive class
		clazz = boolean.class;
		debugClass(clazz);
		// Alternative
		clazz = Integer.TYPE;
		debugClass(clazz);

		// Arrays of primitive
		clazz = int[][][].class;
		debugClass(clazz);
		clazz = String[][].class;
		debugClass(clazz);
		// With the forName method: check the syntax
		try {
			clazz = Class.forName("[[[I");
			debugClass(clazz);
			clazz = Class.forName("[[Ljava.lang.String;");
			debugClass(clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Best method to retrieve an object class. Note that the returned class
		// is the effectively instantiated class, not the declared type
		Set<String> s = new HashSet<>();
		clazz = s.getClass();
		debugClass(clazz);
		// Alternative methods
		clazz = HashSet.class;
		debugClass(clazz);
		try {
			clazz = Class.forName("java.util.HashSet");
			debugClass(clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Anonymous classes
		Object anonymousObject = new Object() {
			@SuppressWarnings("unused")
			public void m() {
			}
		};
		clazz = anonymousObject.getClass();
		debugClass(clazz);

		clazz = anonymousObject.getClass().getEnclosingClass();
		debugClass(clazz);
		// Declaring class
		clazz = anonymousObject.getClass().getDeclaringClass();
		debugClass(clazz);
		// will be null, declared in its own class file
		clazz = this.getClass().getDeclaringClass();
		debugClass(clazz);
	}

	private <T> void debugClass(Class<T> clazz) {
		System.out.println("Retrieved class: " + (clazz == null ? "null" : clazz.getName()));
	}

	@SuppressWarnings("rawtypes")
	private static void printAncestor(Class<?> c, List<Class> l) {
		Class<?> ancestor = c.getSuperclass();
		if (ancestor != null) {
			l.add(ancestor);
			printAncestor(ancestor, l);
		}
	}

	@SuppressWarnings("rawtypes")
	private void spy(Class<?> c) {
		out.format("Class:%n  %s%n%n", c.getCanonicalName());
		out.format("Modifiers:%n  %s%n%n", Modifier.toString(c.getModifiers()));

		out.format("Type Parameters:%n");
		TypeVariable[] tv = c.getTypeParameters();
		if (tv.length != 0) {
			out.format("  ");
			for (TypeVariable t : tv)
				out.format("%s ", t.getName());
			out.format("%n%n");
		} else {
			out.format("  -- No Type Parameters --%n%n");
		}

		out.format("Implemented Interfaces:%n");
		Type[] intfs = c.getGenericInterfaces();
		if (intfs.length != 0) {
			for (Type intf : intfs)
				out.format("  %s%n", intf.toString());
			out.format("%n");
		} else {
			out.format("  -- No Implemented Interfaces --%n%n");
		}

		out.format("Inheritance Path:%n");
		List<Class> l = new ArrayList<Class>();
		printAncestor(c, l);
		if (l.size() != 0) {
			for (Class<?> cl : l)
				out.format("  %s%n", cl.getCanonicalName());
			out.format("%n");
		} else {
			out.format("  -- No Super Classes --%n%n");
		}

		out.format("Annotations:%n");
		Annotation[] ann = c.getAnnotations();
		if (ann.length != 0) {
			for (Annotation a : ann)
				out.format("  %s%n", a.toString());
			out.format("%n");
		} else {
			out.format("  -- No Annotations --%n%n");
		}
	}

}
