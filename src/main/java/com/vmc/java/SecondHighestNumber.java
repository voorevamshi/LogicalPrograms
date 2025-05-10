package com.vmc.java;

public class SecondHighestNumber implements Logic {

    int[] input = {2, 9, 99, 88, 233, 12, 0};

    @Override
    public void execute() {
        Utility.printArray(input);
        int value = returnSecondHighest(input);
        Utility.printArray(input);
        System.out.println("SecondHighestNumber :" + ((value == Integer.MIN_VALUE) ? "No Second Highest Number" : value));
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
        int value = returnSecondHighestSolution2(input);

    }

    private int returnSecondHighestSolution2(int[] input) {
        int firstHighest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        for (Integer number : input) {
            if (firstHighest < number) {
                firstHighest = number;
            } else if (secondHighest < number && number != firstHighest) {
                secondHighest = firstHighest;
            }
        }
        return secondHighest;
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
