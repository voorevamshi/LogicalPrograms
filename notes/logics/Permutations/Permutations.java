package com.example.demo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static List<String> generatePermutations(String input) {
        List<String> result = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return result;
        }

        // Sort the array first to ensure permutations are generated in lexicographical
        // order
        char[] chars = input.toCharArray();
        Arrays.sort(chars);

        boolean[] used = new boolean[chars.length];
        backtrack(chars, new StringBuilder(), used, result);

        return result;
    }

    private static void backtrack(char[] chars, StringBuilder current, boolean[] used, List<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            // If the character is already used in the current permutation, skip it
            if (used[i]) {
                continue;
            }

            // Skip duplicates to prevent duplicate permutations
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            current.append(chars[i]);

            // Recursively generate the rest
            backtrack(chars, current, used, result);

            // Backtrack: remove the character and mark it as unused
            used[i] = false;
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        String input = "123";
        List<String> perms = generatePermutations(input);

        // Output format: 123,132,213,231,312,321
        System.out.println(String.join(",", perms));
    }
}
