package com.vmc.chatgpt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 26;
		int array[]=  new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					System.out.println(nums[i] + "," + nums[j]);
					
					array[0]=i;
					array[1]=j;
					return;
				}
			}
		}
		List<Integer> list=Arrays.stream(array).boxed().collect(Collectors.toList());
		System.out.println(list);
	}
}
