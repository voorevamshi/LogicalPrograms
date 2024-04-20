package com.vmc.java;

public class CyclicArray implements Logic {

	@Override
	public void execute() {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		int[] result = new int[array.length * 2];
		for (int i = 0; i < array.length * 2; i++) {
			if (i <= 5) {
				result[i] = array[i];
			} else if (i > 5 && i <= 11) {
				result[i] = array[i - 6];
			}

		}
		printCyclic(result, 0);
		printCyclic(result, 1);
		printCyclic(result, 2);
		printCyclic(result, 3);
		printCyclic(result, 4);
		printCyclic(result, 5);
		for (int i = 0; i < result.length; i++) {
			// System.out.print(result[i] + ",\t");
		}
	}

	private void printCyclic(int[] result, int i) {
		String endResult = "";
		for (int j = i; j < (i + 6); j++) {
			endResult += result[j] + ", ";
		}
		System.out.println(endResult.substring(0, endResult.length() - 2));
	}

	@Override
	public void executeWithSoultion2() {

    int[] arr = {1, 2, 3, 4, 5};
        
        for (int i = 0; i < arr.length; i++) {
            printCyclically(arr, i);
            System.out.println();
        }
    }

    public static void printCyclically(int[] arr, int start) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[(start + i) % arr.length] + " ");
        }
    }

	@Override
	public void executeWithSoultion3() {

	}

	@Override
	public void executeUsingJava8() {

	}

}
