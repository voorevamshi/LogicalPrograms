package com.vmc.java;

public class CyclicArray4C7R implements Logic {

	@Override
	public void execute() {
		// output
		// 1,2,3,4
		// 5,6,7,8
		// 9,10,1,2
		// 3,4,5,6
		// 7,8,9,10
		// 1,2,3,4
		// 5,6,7,8

		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int counter=0;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(array[(counter) % array.length] + " ");
				counter++;
			}
			System.out.println();
		}
	}


	@Override
	public void executeWithSoultion2() {

	}

	@Override
	public void executeWithSoultion3() {

	}

	@Override
	public void executeUsingJava8() {

	}

}
