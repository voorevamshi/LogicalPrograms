package com.vmc.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorGroupingMethods {
    public static void main(String[] args) {
        String[] frouits = {"apple", "banana", "cherry", "date"};
        // 1. Basic Grouping by a Property
        Map<Integer, List<String>> groupedByLength = Arrays.stream(frouits)
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length: " + groupedByLength);

        // 2. Grouping with a Downstream Collector
        Map<Integer, Set<String>> groupedByLengthSet = Stream.of("apple", "banana", "cherry", "date")
            .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println("Grouped by Length (Set): " + groupedByLengthSet);

        // 3. Grouping and Counting
        Map<Integer, Long> groupedByLengthCount = Stream.of("apple", "banana", "cherry", "date")
            .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("Grouped by Length (Count): " + groupedByLengthCount);

        // 4. Grouping with Mapping
        Map<Integer, List<String>> groupedByLengthUppercase = Stream.of("apple", "banana", "cherry", "date")
            .collect(Collectors.groupingBy(String::length, Collectors.mapping(String::toUpperCase, Collectors.toList())));
        System.out.println("Grouped by Length (Uppercase): " + groupedByLengthUppercase);

        // 5. Grouping with Summarizing
        Map<Integer, IntSummaryStatistics> groupedByLengthStats = Stream.of("apple", "banana", "cherry", "date")
            .collect(Collectors.groupingBy(String::length, Collectors.summarizingInt(String::length)));
        System.out.println("Grouped by Length (Stats): " + groupedByLengthStats);

        // 6. Grouping with Custom Key
        Map<String, List<Integer>> groupedByEvenOdd = Stream.of(1, 2, 3, 4, 5, 6)
            .collect(Collectors.groupingBy(n -> n % 2 == 0 ? "Even" : "Odd"));
        System.out.println("Grouped by Even/Odd: " + groupedByEvenOdd);

        // 7. Multi-Level Grouping
        Map<Integer, Map<Character, List<String>>> multiLevelGrouping = Stream.of("apple", "banana", "cherry", "date")
            .collect(Collectors.groupingBy(String::length, Collectors.groupingBy(s -> s.charAt(0))));
        System.out.println("Multi-Level Grouping: " + multiLevelGrouping);

        // 8. Grouping with Custom Collector
        Map<Integer, String> groupedByLengthJoined = Stream.of("apple", "banana", "cherry", "date")
            .collect(Collectors.groupingBy(String::length, Collectors.joining(", ")));
        System.out.println("Grouped by Length (Joined): " + groupedByLengthJoined);

        // 9. Grouping with Null Handling
        Map<Integer, List<String>> groupedByLengthWithNull = Stream.of("apple", null, "banana", "cherry", "date")
            .filter(Objects::nonNull)
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length (With Null Handling): " + groupedByLengthWithNull);
    }
}