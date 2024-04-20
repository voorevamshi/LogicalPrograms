package com.vmc.java;

import java.util.Map;
import java.util.Set;

public class Utility {

	public static void printInput(int[] input) {
		System.out.print("Input:\t");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + "\t");
		}
		System.out.println();
	}

	public static void printOutput(int[] input) {

		System.out.print("Output:\t");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + "\t");
		}
		System.out.println();
	}

	public static void printMap(Map<Character, Integer> map) {
		Set<Character> set = map.keySet();
		for (Character character : set) {
			System.out.println(character + " Occurences count is " + map.get(character));
		}
	}

}
