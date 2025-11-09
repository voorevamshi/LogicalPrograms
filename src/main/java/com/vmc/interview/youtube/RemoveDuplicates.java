package com.interview.youtube;

import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {

		int[] array1 = { 1, 2, 3, 4, 5, 1, 4 };
		int index = 0;
		for (int i : array1) {

			int count = 0;
			for (int j : array1) {
				if (i == j) {
					count++;

				}
			}
			if (count > 1 && i != 0) {
				array1[index] = 0;
				System.out.println("Duplicates:" + i);
			}
			index++;
		}
		System.out.println(Arrays.toString(array1));

	}

}
