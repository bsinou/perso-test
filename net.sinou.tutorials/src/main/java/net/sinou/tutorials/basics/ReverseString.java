package net.sinou.tutorials.basics;

import java.util.Scanner;

public class ReverseString {
	public static String FirstReverse(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--)
			sb.append(str.charAt(i));
		return sb.toString();
	}

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			System.out.print("Please enter a String to be reversed:\n (Type 'q' to quit)\n$ ");
			loop: while (true) {
				String line = s.nextLine();
				if ("q".equals(line)){
					System.out.print("Goodbye!");
					break loop;
				}
				else
					System.out.print(FirstReverse(line)+"\n$ ");
			}
		}
	}
}
