package com.vmc.interview.lti.mindtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestRepeatedString {

	public static void main(String[] args) {
		String string = "aabbbbddaaaccdd";

		Map<String, String> map2=new HashMap<>();
		String retrunValue1=map2.put("Ajay","1");
		String retrunValue2=map2.computeIfAbsent("vamshi",k->k.length()+"");
		map2.putIfAbsent("vamshi","2");
		System.out.println(map2+",retrunValue1:"+retrunValue1+",retrunValue2:"+retrunValue2);
		        
		        String longest = "";      // To store the best streak we've found
		        String current = "";      // To build the streak we are currently looking at
		        Map<String, List<String>> map=new HashMap<>();
		        for (int i = 0; i < string.length(); i++) {
		            char currentChar = string.charAt(i);
		            map.computeIfAbsent(currentChar+"", k -> new ArrayList<>()).add(""+currentChar);

		            // If it's the first character OR the same as the previous one
		            if (current.length() == 0 || currentChar == current.charAt(0)) {
		                current += currentChar; // Add it to our current streak
		            } else {
		                // The character changed! Let's check if the streak we just finished 
		                // is the longest one so far.
		                if (current.length() > longest.length()) {
		                    longest = current;
		                }
		                // Start a new streak with the new character
		                System.out.println("current:"+current+",currentChar:"+currentChar+",longest:"+longest);
		                current = String.valueOf(currentChar);
		                
		            }
		        }
System.err.println(map);
		        // One last check after the loop ends (to catch the final streak)
		        if (current.length() > longest.length()) {
		            longest = current;
		        }

		        System.out.println("Longest repeated string: " + longest);
		    
		// Approach 1
	/*	char[] ch = string.toCharArray();
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
		System.out.println(longestRepetedString);*/

	}
/*	
	Feature                                     Normal For-Loop                                      Java 8 Streams (Regex)
	===========                                 ===============                                      =======================
	Complexity                                  O(n) (One pass)                                      O(n) (Regex engine overhead)
	Memory                                      Very Low                                             Higher (creates multiple String objects)
	Readability                                 High (Standard Logic)                                Medium (Requires Regex knowledge)
	Best For                                    Coding Interviews / Performance                      Quick scripting / One-liners
*/
}
