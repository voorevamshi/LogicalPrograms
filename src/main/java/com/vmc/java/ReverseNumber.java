package com.vmc.java;

public class ReverseNumber implements Logic {

	@Override
	public void execute() {
		int input = 4549;
		System.out.println("Input:" + input);
		int reverseNbr = reverse(input);
		System.out.println("reverseNbr:" + reverseNbr);
	}

	private int reverse(int input) {
		int reverseNbr = 0;
		while (input > 0) {
			int remainder = input % 10;
			reverseNbr = reverseNbr * 10 + remainder; //9 94 945 9454
			input = input / 10; //454  45 4 0
		}

		return reverseNbr;
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
