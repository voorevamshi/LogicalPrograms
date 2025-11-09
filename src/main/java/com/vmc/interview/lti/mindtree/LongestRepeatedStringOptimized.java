package com.interview.lti.mindtree;

public class LongestRepeatedStringOptimized {

	public static void main(String[] args) {
		String str = "aabbbbddc";

		int maxLen = 1, currLen = 1;
		char maxChar = str.charAt(0);

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				currLen++;
			} else {
				currLen = 1;
			}

			if (currLen > maxLen) {
				maxLen = currLen;
				maxChar = str.charAt(i);
			}
		}

		String longestRepeated = String.valueOf(maxChar).repeat(maxLen);
		System.out.println("Longest repeated string: " + longestRepeated);
	}
}
