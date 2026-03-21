package com.vmc.interview.mphsis;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		String s = "babad";
        System.out.println(longestPalindrome(s));
	}

	private static String longestPalindrome(String s) {
		if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expand(s, i, i);      // odd length  -1,0,1
            int len2 = expand(s, i, i + 1);  // even length  0,1,0
            int len = Math.max(len1, len2); // 0,1
            if (len > end - start) {

                start = i - (len - 1) / 2; // *,1
                end = i + len / 2;         //1
            }
        }
		return s.substring(start, end + 1); 
	}

	private static int expand(String s, int left, int right) {  //babad  0 0 ,0 1,1,1,1,2,2,2,2,3
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) { 
			left--; // -1,0,1
			right++; // 1,2,3
		}
		return right - left - 1; //-1, 0,0,0,1,0
	}

}
