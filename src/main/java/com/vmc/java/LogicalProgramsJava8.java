package com.vmc.java;

import java.util.Arrays;

public class LogicalProgramsJava8 {
	public static void main(String[] args) {
		int[] input = { 2, 9, 99, 88, 233, 12, 0 };
		printInput(input);
		//1)second highest element of array
		int value = returnSecondHighest(input);
		printOutput(input);
		System.out.println("\nSecondHighest Number:\t" + value);
	}

	private static void printInput(int[] input) {
		System.out.print("Input:\t");
		Arrays.stream(input).forEach(i->System.out.print(i + "\t"));
	}

	private static void printOutput(int[] input) {
		System.out.println();
		System.out.print("Output:\t");
		Arrays.stream(input).forEach(i->System.out.print(i + "\t"));
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
