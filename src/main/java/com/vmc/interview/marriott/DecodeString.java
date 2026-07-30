package com.vmc.interview.marriott;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String input = "2[a3[b]]";
        System.out.println("Input: " + input);
        System.out.println("Output: " + decodeString(input));
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Handle multi-digit numbers (e.g., 10[a])
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current multiplier and current string to stacks
                countStack.push(k);
                resStack.push(current);
                // Reset for the content inside the brackets
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                // Pop the multiplier and the previous string prefix
                StringBuilder decodedString = current;
                current = resStack.pop();
                int repeatTimes = countStack.pop();

                // Append the decoded part to the prefix
                while (repeatTimes-- > 0) {
                    current.append(decodedString);
                }
            } else {
                // It's a normal character, just append it
                current.append(ch);
            }
        }
        return current.toString();
    }
}