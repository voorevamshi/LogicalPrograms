package com.vmc.interview.epam.slidingwindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestSubarrayWithoutRepeating {

	public static void main(String[] args) {

		int[] nums = { 5, 2, 5, 1, 2, 3, 4, 1 };
		String nameString="vvamshi1ok";
		char ch[] =nameString.toCharArray();
		//List<Character> characters=	longestSubarray(ch);
		//String subString=characters.stream().map(String::valueOf).collect(Collectors.joining(""));
		//System.out.println(subString);
		System.out.println(longestSubarray(nums));
		//System.out.println(longestSubarrayLength(nums));
	}

	private static List<Character> longestSubarray(char[] nums) {

		Set<Character> set = new HashSet<>();

		int left = 0;
		int maxLength = 0;
		int startIndex = 0;

		for (int right = 0; right < nums.length; right++) {

			while (set.contains(nums[right])) {
				set.remove(nums[left]);
				left++;
			}

			set.add(nums[right]);

			if (right - left + 1 > maxLength) {
				maxLength = right - left + 1;
				startIndex = left;
			}
		}

		List<Character> result = new ArrayList<>();
		System.out.println("startIndex:"+startIndex+",maxLength:"+maxLength);
		for (int i = startIndex; i < startIndex + maxLength; i++) {
			result.add(nums[i]);
		}

		return result;
	}

	private static List<Integer> longestSubarray(int[] nums) {

		Set<Integer> set = new HashSet<>();

		int left = 0;
		int maxLength = 0;
		int startIndex = 0;

		for (int right = 0; right < nums.length; right++) {

			while (set.contains(nums[right])) {
				set.remove(nums[left]);
				left++;
			}

			set.add(nums[right]);

			if (right - left + 1 > maxLength) {
				maxLength = right - left + 1;
				startIndex = left;
			}
		}

		List<Integer> result = new ArrayList<>();
		System.out.println("startIndex:"+startIndex+",maxLength:"+maxLength);
		for (int i = startIndex; i < startIndex + maxLength; i++) {
			result.add(nums[i]);
		}

		return result;
	}

	private static int longestSubarrayLength(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int left = 0;
		int maxLength = 0;
		for (int right = 0; right < nums.length; right++) {

			while (set.contains(nums[right])) {
				set.remove(nums[left]);
				left++;
			}
			set.add(nums[right]);
			maxLength = Math.max(maxLength, right - left + 1);
		}
		System.out.println("set:" + set);
		return maxLength;
	}

}
