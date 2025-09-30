package com.vmc.java.other.logic;

import java.util.ArrayList;
import java.util.List;

public class DuplicateNumbers {
	

	public static void main(String[] args) {
		List<Integer> result = new ArrayList<>();
		int nums[] = { 1, 2, 3, 4, 5, 6, 2, 4, 5, 9 };
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j] && !result.contains(nums[i])) {
					result.add(nums[i]);
				}
			}
		}

		System.out.println(result);
	}

}
