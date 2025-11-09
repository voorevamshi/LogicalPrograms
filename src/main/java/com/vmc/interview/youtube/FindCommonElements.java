package com.vmc.interview.youtube;

import java.util.Arrays;

public class FindCommonElements {

	public static void main(String[] args) {

		int[] array1 = { 0, 2, 3, 0, 5, 1, 4 };
		int[] array2 = { 4, 5, 6, 7, 8 };
		
		for (int i : array1) {
			for (int j : array2) {
				if (i == j) {
					System.out.println("Duplcates:" + i);
				}
			}
		}

		Arrays.stream(array1).forEach(ar1 -> {
			Arrays.stream(array2).forEach(ar2 -> {
				if (ar1 == ar2) {
					System.out.println("Duplcates using java 8:" + ar1);
				}

			});

		});
	}

}
