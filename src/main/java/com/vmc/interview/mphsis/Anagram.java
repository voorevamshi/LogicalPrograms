package com.vmc.interview.mphsis;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {

	public static void main(String[] args) {
		// streamApporach();

        
		System.out.println("isAnagram:" + arrayApproach());

	}

	private static boolean arrayApproach() {
		String s1 = "aaabbb", s2 = "aaabbc";
		// 1. Basic Cleanup: Remove spaces and convert to lowercase
		// This ensures "Listen" and "Silent" are treated as matches
		s1 = s1.replaceAll("\\s", "").toLowerCase();
		s2 = s2.replaceAll("\\s", "").toLowerCase();

		// 2. If lengths differ, they cannot be anagrams
		if (s1.length() != s2.length()) {
			return false;
		}

		// 3. Create a frequency map for all ASCII characters
		int[] charCounts = new int[256];

		for (int i = 0; i < s1.length(); i++) {
			// Increment for string 1, Decrement for string 2
			charCounts[s1.charAt(i)]++;
			charCounts[s2.charAt(i)]--;
		}
		int[] resultRange = Arrays.copyOfRange(charCounts, 97, 124);
		System.out.println(java.util.Arrays.toString(resultRange));

		// 4. If they are anagrams, every index must be back to 0
		for (int count : charCounts) {
			System.err.println("count:"+count);
			if (count != 0) {
				return false;
			}
		}

		return true;
	}

	private static void streamApporach() {
		String str1 = "eat";
		String str2 = "tea";

		Map<Character, Long> map1 = str1.chars().mapToObj(value -> Character.valueOf((char) value))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Map<Character, Long> map2 = str2.chars().mapToObj(value -> Character.valueOf((char) value))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("map1:" + map1 + ",map2:" + map2);
		boolean isAllMatched = (str1.length() == str2.length()) && map1.entrySet().stream()
				.allMatch(entry -> (null != entry.getKey() && null != map2.get(entry.getKey())
						&& map2.get(entry.getKey()).equals(entry.getValue())) ? true : false);

		System.out.println("isAllMatched:" + isAllMatched);
	}

}
