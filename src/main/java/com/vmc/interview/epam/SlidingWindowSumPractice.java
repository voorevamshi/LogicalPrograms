package com.vmc.interview.epam;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowSumPractice {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		List<Integer> output = new ArrayList<>();
		int sum = 0;
		int k = 3;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i]; //10,11
			if (i >= k) {
				sum-=arr[i-k]; //10=10-4
							  //11=11-
				
			}
			output.add(sum);
	
		}
		System.out.println(output);

	}
}
