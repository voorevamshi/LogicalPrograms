package com.vmc.java;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Occurence implements Logic {

	String input = "123451225336";

	@Override
	public void execute() {
		System.out.println("====== execute() input:" + input);
		findOccurences(input);
	}

	private void findOccurences(String input) {
		for (int j = 0; j < input.length(); j++) {
			int count = 0;
			for (int j2 = 0; j2 < input.length(); j2++) {
				if (input.charAt(j) == input.charAt(j2)) {
					count++;
				}
			}
			System.out.println(input.charAt(j) + " Occurences count is " + count);
		}
	}

	@Override
	public void executeWithSoultion2() {
		System.out.println("====== executeWithSoultion2 input:" + input);
		findOccurencesSoultion2(input);
	}

	private void findOccurencesSoultion2(String input) {

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			if (null == map.get(input.charAt(i))) {
				map.put(input.charAt(i), 1);
			} else {
				map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
			}
		}
		Utility.printMap(map);
	}

	@Override
	public void executeWithSoultion3() {
		System.out.println("====== executeWithSoultion3 input:" + input);
		findOccurencesSoultion3(input);
	}

	private void findOccurencesSoultion3(String input) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : input.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		Utility.printMap(map);
	}

	@Override
	public void executeUsingJava8() {
		System.out.println("====== executeUsingJava8 input:" + input);
		findOccurencesUsingJava8(input);
	}

	private void findOccurencesUsingJava8(String input) {
		List<Character> charList = input.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		Map<Character, Integer> map = new HashMap<>();
		charList.forEach(c -> map.put(c, map.getOrDefault(c, 0) + 1));
		Utility.printMap(map);
	}

}
