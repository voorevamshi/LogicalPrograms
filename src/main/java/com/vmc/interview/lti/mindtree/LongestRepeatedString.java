package com.vmc.interview.lti.mindtree;

public class LongestRepeatedString {

	public static void main(String[] args) {
		String string = "aabbbbddc";
		char[] ch = string.toCharArray();
		int topHighest = 0;
		String longestRepetedString = "";
		for (int i = 0; i < ch.length; i++) {
			int count = 0;
			int highest = 0;

			String indexString = "";
			for (int j = 0; j < ch.length; j++) {
				if (ch[i] == ch[j]) {
					count++;
					indexString = indexString + "" + ch[i];
				}
			}

			System.out.println("count:" + count);
			if (count > 1 && highest != count) {
				highest = count;
				System.out.println("inside highest:" + highest);
			}
			if (highest > topHighest) {
				topHighest = highest;
				longestRepetedString = indexString;
			}
			count = 0;
		}
		System.out.println(longestRepetedString);

	}

}
