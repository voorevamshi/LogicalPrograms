package com.vmc.java;

public class Palindrome implements Logic{

	@Override
	public void execute() {
		boolean isPalindrome= isPalindromeNumber(123);
		System.out.println(123+" is Palindrome number");
	}
	
	private static boolean isPalindromeNumber(int num) {
		int originalNum = num;
        int reversedNum = 0;
		while (num > 0) {
			int remainder = num % 10;
            reversedNum = reversedNum * 10 + remainder;
            num = num / 10;
		}
		return reversedNum==originalNum;
	}

	@Override
	public void executeWithSoultion2() {
		// TODO Auto-generated method stub
		
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
