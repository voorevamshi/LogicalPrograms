package com.vmc.java;

import java.util.List;
import java.util.Optional;

public class ArmstrongNumberChecker implements Logic {

    private final String input = "153";

    @Override
    public void execute() {
        System.out.println("Solution1 input: " + input);
        printResult(isArmstrongSolution1(input));
    }

    private boolean isArmstrongSolution1(String input) {
        if (input == null || !input.matches("\\d+")) {
            System.out.println("Invalid input: " + input);
            return false;
        }
        int sum = 0;
        List<Integer> digits = input.chars().mapToObj(c -> c - '0').toList();
        for (int num : digits) {
            sum += Math.pow(num, digits.size());
        }
        return Integer.parseInt(input) == sum;
    }

    @Override
    public void executeWithSoultion2() {
        System.out.println("Solution2 input: " + input);
        printResult(isArmstrongSolution2(input));
    }

    public static boolean isArmstrongSolution2(String input) {
        try {
            int number = Integer.parseInt(input), sum = 0, length = input.length();
            while (number > 0) {
                int digit = number % 10;
                sum += (int) Math.pow(digit, length);
                number /= 10;
            }
            return sum == Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: " + input);
            return false;
        }
    }

    @Override
    public void executeWithSoultion3() {
        System.out.println("Solution3 input: " + input);
        printResult(isArmstrongSolution3(input));
    }

    private boolean isArmstrongSolution3(String input) {
        if (input == null || !input.matches("//d+")) {
            System.out.println("Invalid input: " + input);
            return false;
        }
        int sum = 0, power = input.length();
        for (char digit : input.toCharArray()) {
            sum += (int) Math.pow(digit - '0', power);
        }

        return Integer.parseInt(input) == sum;
    }

    @Override
    public void executeUsingJava8() {
        System.out.println("Using Java 8 input: " + input);
        printResult(isArmstrongUsingJava8(input));
    }

    private boolean isArmstrongUsingJava8(String input) {
        if (input == null || !input.chars().allMatch(Character::isDigit)) {
            System.out.println("Invalid input: " + input);
            return false;
        }
        int sum = input.chars()
                .map(c -> (int) Math.pow(c - '0', input.length()))
                .sum();
        return Integer.parseInt(input) == sum;
    }

    private void printResult(boolean isArmstrong) {
        System.out.println(input + (isArmstrong ? " is an Armstrong number." : " is not an Armstrong number."));
    }
}