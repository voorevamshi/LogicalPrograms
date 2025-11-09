package com.vmc.interview.jpmorgan;

import java.util.*;


public class MethodNameConverter {
    public static void main(String[] args) {
        String[] methods = {"getCurrency", "getAccountName", "getLongAccountName", "getSWIFTCode", "getTraceID"};
        List<String> friendlyNames = new ArrayList<>();

        for (String method : methods) {
            friendlyNames.add(convertToUserFriendly(method));
        }

        System.out.println("Input: " + Arrays.toString(methods));
        System.out.println("Output: " + friendlyNames);
    }

    private static String convertToUserFriendly(String methodName) {
        // Remove "get", "set", or "is" prefix if present
        if (methodName.startsWith("get") && methodName.length() > 3) {
            methodName = methodName.substring(3);
        } else if (methodName.startsWith("set") && methodName.length() > 3) {
            methodName = methodName.substring(3);
        } else if (methodName.startsWith("is") && methodName.length() > 2) {
            methodName = methodName.substring(2);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < methodName.length(); i++) {
            char current = methodName.charAt(i);

            // Add underscore before uppercase letter only if:
            // 1. It's not the first character
            // 2. The previous character is lowercase
            // 3. The next character is lowercase (handles acronyms)
            if (i > 0 && Character.isUpperCase(current)) {
                char prev = methodName.charAt(i - 1);
                char next = (i + 1 < methodName.length()) ? methodName.charAt(i + 1) : 0;

                if (Character.isLowerCase(prev) || (next != 0 && Character.isLowerCase(next))) {
                	System.out.println(methodName+"  -->"+prev+" -->"+result+" -->"+next);
                    result.append('_');
                }
            }
            result.append(current);
        }

        return result.toString();
    }
}
