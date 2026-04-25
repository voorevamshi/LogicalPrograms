package com.vmc.interview.altimetric;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingharacters {

    public static void main(String[] args) {
            String s = "pwwkew";
            int left = 0;
            int maxLength = 0;
            int startIndex = 0;
            Set<Character> set = new HashSet<>();

            for (int right = 0; right < s.length(); right++) {
                // While the set contains the character,
                // shrink the window from the leftd
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }

                set.add(s.charAt(right));

                // Update max length and start position
                if (maxLength < right - left + 1) {
                    maxLength = right - left + 1;
                    startIndex = left;
                }
            }

            // substring(start, end) -> end is startIndex + maxLength
            System.out.println("maxLength:"+maxLength+",startIndex:"+startIndex+",LongestSubstring: " + s.substring(startIndex, startIndex + maxLength));
            System.out.println("Length: " + maxLength);
        }
}
