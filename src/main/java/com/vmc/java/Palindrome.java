package com.vmc.java;

import java.util.function.Consumer;

public class Palindrome implements Logic {

	Integer input = 121;

	void init(boolean condition) {
		// Define the ifElse consumer in a single line
		Consumer<Integer> ifElse = (input) -> {
			System.out.println(condition ? input + " is an Palindrome number." : input + " is not an Palindrome number.");
		};
		// Use the ifElse consumer
		ifElse.accept(input);
	}

	@Override
	public void execute() {
		
		System.out.println("isPalindromeNumber Soluton1 input:" + input);
		boolean isPalindrome = isPalindromeNumberSoluton1(input);
		init(isPalindrome);
	}

	private static boolean isPalindromeNumberSoluton1(int num) {
		int originalNum = num;
		int reversedNum = 0;
		while (num > 0) {
			int remainder = num % 10;
			reversedNum = reversedNum * 10 + remainder;
			num = num / 10;
		}
		return reversedNum == originalNum;
	}

	@Override
	public void executeWithSoultion2() {
		System.out.println("isPalindromeNumber Soluton2 input:" + input);
		boolean isPalindrome = isPalindromeNumberSoluton2(input);
		init(isPalindrome);

	}

	private boolean isPalindromeNumberSoluton2(Integer input) {
		StringBuffer inputStr = new StringBuffer(input.toString());
		return inputStr.equals(inputStr.reverse());
	}

	@Override
	public void executeWithSoultion3() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeUsingJava8() {
		// TODO Auto-generated method stub

	}

}
