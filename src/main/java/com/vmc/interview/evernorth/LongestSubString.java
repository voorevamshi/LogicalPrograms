package com.vmc.interview.evernorth;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubString {

	public static void main(String[] args) {
		String str = "abcdefgcad";
		Map<Character, String> map = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			int start = i;
			for (int j = i + 1; j < str.length(); j++) {
				if (ch.equals(str.charAt(j))) {
					int end = j;
					map.put(ch, str.substring(start, end));
				}
			}
		}
		System.out.println(map);
	}

}
