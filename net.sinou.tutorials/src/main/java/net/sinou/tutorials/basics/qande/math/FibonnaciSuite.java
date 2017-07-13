package net.sinou.tutorials.basics.qande.math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Various examples of algorithms implementing the Fibonacci Number Suite
 */
public class FibonnaciSuite {

	private static long number = 1000;

	/**
	 * <p>main.</p>
	 *
	 * @param args an array of {@link java.lang.String} objects.
	 */
	public static void main(String[] args) {
		FibonnaciSuite fs = new FibonnaciSuite();

		// TODO compare performance of the various methods using aspect.
		
		// with recursion and list cache
		fs.useListRecursion();

		// with recursion and map cache
		fs.useMapRecursion();

		// An elegant solution using Java8 streams
		fs.useJava8Streams();
	}

	/* LIST CACHE SOLUTION */
	// the cache, created with double curly brace initialisation
	private List<BigInteger> lcache = new ArrayList<BigInteger>() {
		private static final long serialVersionUID = 1L;
		{
			add(BigInteger.ZERO);
			add(BigInteger.ONE);
		}
	};

	private void useListRecursion() {
		// We rely on the index, so we we want to compute for number -1
		computeLRecursive((int) number - 1);
		for (BigInteger bi : lcache)
			System.out.print(bi + " ");
		System.out.println();
	}

	private BigInteger computeLRecursive(int rank) {
		if (lcache.size() > rank)
			return lcache.get(rank);
		else {
			BigInteger tmp = computeLRecursive(rank - 2).add(computeLRecursive(rank - 1));
			lcache.add(tmp);
			return tmp;
		}
	}

	/* MAP CACHE SOLUTION */
	// the cache, created with double curly brace initialisation
	private Map<Long, BigInteger> cache = new TreeMap<Long, BigInteger>() {
		private static final long serialVersionUID = 1L;
		{
			put(1L, BigInteger.ZERO);
			put(2L, BigInteger.ONE);
		}
	};

	private void useMapRecursion() {
		computeRecursive(number);
		for (Long l : cache.keySet())
			System.out.print(cache.get(l) + " ");
		System.out.println();
	}

	private BigInteger computeRecursive(long rank) {
		if (cache.containsKey(rank))
			return cache.get(rank);
		else {
			BigInteger tmp = computeRecursive(rank - 2).add(computeRecursive(rank - 1));
			cache.put(rank, tmp);
			return tmp;
		}
	}

	/* JAVA 8 STREAM SOLUTION */
	private void useJava8Streams() {
		Stream<BigInteger> fiboStream = Stream
				.iterate(new Tuple<>(BigInteger.ZERO, BigInteger.ONE), x -> new Tuple<>(x.u, x.t.add(x.u)))
				.limit(number).map(x -> x.t);
		String result = fiboStream.map(BigInteger::toString).collect(Collectors.joining(" "));
		System.out.println(result);
	}

	private static class Tuple<T, U> {
		public final T t;
		public final U u;

		public Tuple(T t, U u) {
			this.t = t;
			this.u = u;
		}
	}
}
