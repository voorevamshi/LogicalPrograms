package com.vmc.java;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ArmstrongNumberChecker implements Logic {

	String input = "153";

	void init(boolean condition) {
		// Define the ifElse consumer in a single line
		Consumer<String> ifElse = input -> System.out
				.println(condition ? input + " is an Armstrong number." : input + " is not an Armstrong number.");
		// Use the ifElse consumer
		ifElse.accept(input);
	}

	@Override
	public void execute() {
		System.out.println("ArmstrongNumberChecker Soluton1 input:" + input);
		init(isArmstrongSoultion1(input));
	}

	private boolean isArmstrongSoultion1(String input) {
		int result = 0;
		List<Integer> intList = input.chars().mapToObj(c -> ((int) c) - 48).collect(Collectors.toList());
		for (int i = 0; i < intList.size(); i++) {
			result += Math.pow(intList.get(i), intList.size());
		}
		return (Integer.parseInt(input) == result);
	}

	@Override
	public void executeWithSoultion2() {
		System.out.println("ArmstrongNumberChecker Soluton2 input:" + input);
		init(isArmstrongSoultion2(input));
	}

	public static boolean isArmstrongSoultion2(String input) {
		int originalNumber = Integer.parseInt(input);
		int result = 0;
		int length = input.length();

		while (originalNumber != 0) {
			int remainder = originalNumber % 10;
			result += Math.pow(remainder, length);
			originalNumber /= 10;
		}

		return (Integer.parseInt(input) == result);
	}

	@Override
	public void executeWithSoultion3() {
		System.out.println("ArmstrongNumberChecker Soluton3 input:" + input);
		init(isArmstrongSoultion3(input));
	}

	private boolean isArmstrongSoultion3(String number) {
		char[] intList = number.toCharArray();
		int result = 0;
		for (int i = 0; i < intList.length; i++) {
			result += Math.pow(intList[i] - 48, intList.length);
		}
		return (Integer.parseInt(number) == result);
	}

	@Override
	public void executeUsingJava8() {

	}

}
