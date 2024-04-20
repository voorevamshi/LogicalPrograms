package com.vmc.java;

public class CyclicArrayRowColumn implements Logic {

	@Override
	public void execute() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int rows = 7;
        int columns = 4;
        int counter = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[counter % arr.length] + " ");
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
