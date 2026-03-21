package com.vmc.interview.epam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SlidingWindowSum {

	public static void main(String[] args) {
		String[] words = { "apple", "ball", "cat", "bubbly", "chinni" };
		Map<Character, List<String>> firstCharMap = getFirstCharMap(words);
		System.out.println("firstCharMap:"+firstCharMap);
		// -------------------------
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int k = 3;
		List<Integer> inputList = Arrays.stream(arr).mapToObj(i -> (Integer) i).collect(Collectors.toList());
		System.out.println("inputList:"+inputList+",k:"+k);
		slidingWindowSum_On2(arr, k);
		/*  The O(n) Solution (The "Moving Window" way)To get the best performance, you don't need a helper method or a nested loop.
		   You simply "slide" the window by adding the new number and dropping the one that is now too far back.
		   Ex: It uses a single variable (currentRunningSum) to "remember" the sum. It just adds one number and subtracts one number at each step.
		    If you have 1,000 numbers, it only does 1,000 operations.
		 */
		slidingWindowSum_On(arr, k);
	}

	private static void slidingWindowSum_On(int[] arr, int k) {
		int[] output = new int[arr.length];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			if (i >= k) {
				sum-=arr[i-k];
			}
			output[i]=sum;
		}
		List<Integer> outputList = Arrays.stream(output).mapToObj(i -> (Integer) i).collect(Collectors.toList());
		System.out.println(outputList);
	}

	private static void slidingWindowSum_On2(int[] arr, int k) {
		/*
		 Analysis of your findSum method In code, for every element after index k, you are calling findSum. 
		 Inside findSum, you are looping through the entire array again:
		 Since you call this inside your main loop (n times), the total complexity becomes n times n.
		  Even if you optimized the inner loop to only run k times, 
		  it would still be O(n * k).
		  Exp: For every number in the array, it launched a separate loop that searched through the whole array. 
		  If you had 1,000 numbers, it might do 1,000,000 operations.
		 */
		int[] output = new int[arr.length];
		int sum = 0;// output {1,3,6,9,12,15} => 1, 1+2, 1+2+3, 2+3+4, 3+4+5, 4+5+6
		// [1, 3, 6, 10, 15]
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				sum = sum + arr[i];
				output[i] = sum;
			} else {
				sum = findSum(arr, i, k);
				output[i] = sum;
			}
		}
		List<Integer> outputList = Arrays.stream(output).mapToObj(i -> (Integer) i).collect(Collectors.toList());
		System.out.println(outputList);
	}

	private static int findSum(int[] arr, int i, int k) {
		int sum = 0;
		for (int j = 0; j < arr.length; j++) {
			if (j > i - k && j <= k + (i - k)) {
				sum = sum + arr[j];
			}
		}
		return sum;
	}

	private static Map<Character, List<String>> getFirstCharMap(String[] words) {
		return Arrays.stream(words).filter(y -> null != y && !"".equals(y) && (null != (Character) y.charAt(0)))
				.collect(Collectors.groupingBy(x -> x.charAt(0)));
	}

}
