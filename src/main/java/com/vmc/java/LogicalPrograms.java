package com.vmc.java;

public class LogicalPrograms {
	public static void main(String[] args) {
		int[] input = { 2, 9, 99, 88, 233, 12, 0 };
		printInput(input);
		int value = returnSecondHighest(input);
		System.out.println("\nSecondHighest Number:\t" + value);
	}

	private static void printInput(int[] input) {
		System.out.print("Input:\t");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + "\t");
		}
	}

	private static int returnSecondHighest(int[] input) {
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (input[i] < input[j]) {
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
		}
		return input[1];
	}
}
