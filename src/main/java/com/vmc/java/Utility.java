package com.vmc.java;

public class Utility {

	public static void printInput(int[] input) {
		System.out.print("Input:\t");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + "\t");
		}
	}

	public static void printOutput(int[] input) {
		System.out.println();
		System.out.print("Output:\t");
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + "\t");
		}
	}

}
