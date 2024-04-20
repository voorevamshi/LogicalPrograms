package com.vmc.java;

public class SecondHighestNumber implements Logic{

	int[] input = { 2, 9, 99, 88, 233, 12, 0 };
	
	@Override
	public void execute() {
		
		Utility.printInput(input);
		int value = returnSecondHighest(input);
		Utility.printOutput(input);
		System.out.println("SecondHighestNumber:"+value);
	}

	private int returnSecondHighest(int[] input) {
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
