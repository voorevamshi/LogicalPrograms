package com.vmc.interview.mphasis;

import java.util.Comparator;

public class LongestStringInArray {
    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "cherry", "elderberry"};
        String longestString = findLongestString(arr);
        System.out.println("The longest string in the array is: " + longestString);
        longestString = findLongestStringUsingJava8(arr);
        System.out.println("The longest string in the array is: " + longestString);
    }

    private static String findLongestStringUsingJava8(String[] arr) {
        return java.util.Arrays.stream(arr)
                .min(Comparator.comparing(String::length))
                .orElse("");
    }

    public static String findLongestString(String[] arr) {
        String longest = "";
        for (String str : arr) {
            if (str.length() > longest.length()) {
                longest = str;
            }
        }
        return longest;
    }
}
