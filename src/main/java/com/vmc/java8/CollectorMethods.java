package com.vmc.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorMethods {
    public static void main(String[] args) {
      // 1. Collect elements into a List
        // This collects the stream elements into a List and prints the result.
        List<String> list = Stream.of("A", "B", "C").collect(Collectors.toList());
        System.out.println("List: " + list);

        // 2. Collect elements into a Set
        // This collects the stream elements into a Set, removing duplicates, and prints the result.
        Set<String> set = Stream.of("A", "B", "A").collect(Collectors.toSet());
        System.out.println("Set: " + set);

        // 3. Collect elements into a Map
        // This collects the stream elements into a Map where the key is the length of the string
        // and the value is the string itself, then prints the result.
        Map<Integer, String> map = Stream.of("A", "BB", "CCC").collect(Collectors.toMap(String::length, s -> s));
        System.out.println("Map: " + map);

        // 4. Join elements into a single string
        // This joins the stream elements into a single string separated by ", " and prints the result.
        String str = Stream.of("A", "B", "C").collect(Collectors.joining(", "));
        System.out.println("String: " + str);

        // 5. Group elements by their length
        // This groups the stream elements by their length into a Map and prints the result.
        Map<Integer, List<String>> groupMap = Stream.of("A", "BB", "CCC").collect(Collectors.groupingBy(String::length, Collectors.toList()));
        System.out.println("Group Map: " + groupMap);

        // 6. Group elements by their length and collect into a Set
        // This groups the stream elements by their length into a Set and prints the result.
        Map<Integer, Set<String>> groupSetMap = Stream.of("A", "BB", "CCC").collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println("Group Set Map: " + groupSetMap);

        // 7. Group elements by their length and count occurrences
        // This groups the stream elements by their length and counts the occurrences, then prints the result.
        Map<Integer, Long> countMap = Stream.of("A", "BB", "CCC").collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("Group Count Map: " + countMap);

        // 8. Partition elements into two groups
        // This partitions the stream elements into two groups (even and odd numbers) and prints the result.
        Map<Boolean, List<Integer>> partitionMap = Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("partitioning  Map: " + partitionMap);

        // 9. Count the number of elements in the stream
        // This counts the number of elements in the stream and prints the result.
        long count = Stream.of("A", "B", "C").collect(Collectors.counting());
        System.out.println("Count: " + count);

        // 10. Reduce the stream to a single value
        // This reduces the stream to a single value by summing the integers and prints the result.
        int reducedValue = Stream.of(1, 2, 3, 4).collect(Collectors.reducing(0, Integer::sum));
        System.out.println("Reduced Value: " + reducedValue);

        // 11. Map each element to its double and collect into a List
        // This maps each element to its double and collects the results into a List, then prints the result.
        List<Integer> mappingList = Stream.of(1, 2, 3, 4).collect(Collectors.mapping(i -> i * 2, Collectors.toList()));
        System.out.println("Mapping List: " + mappingList);

        // 12. Map each string to its length and collect into a List
        // This maps each string to its length and collects the results into a List, then prints the result.
        List<Integer> mappingList2 = Stream.of("A", "BB", "CCC").collect(Collectors.mapping(String::length, Collectors.toList()));
        System.out.println("Mapping List 2: " + mappingList2);

        // 13. Collect statistics for integers
        // This collects statistics (sum, count, min, max, average) for integers and prints the result.
        IntSummaryStatistics intSummaryStatistics = Stream.of(1, 2, 3, 4).collect(Collectors.summarizingInt(i -> i));
        System.out.println("IntSummaryStatistics: " + intSummaryStatistics);

        // 14. Calculate the sum of integers using summarizingInt
        // This calculates the sum of integers using summarizingInt and prints the result.
        long sum = Stream.of(1, 2, 3, 4).collect(Collectors.summarizingInt(Integer::intValue)).getSum();
        System.out.println("Int sum: " + sum);

        // 15. Calculate the sum of integers using summingInt
        // This calculates the sum of integers using summingInt and prints the result.
        long suming = Stream.of(1, 2, 3, 4).collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Int suming: " + suming);

        // 16. Collect statistics for doubles
        // This collects statistics (sum, count, min, max, average) for doubles and prints the result.
        DoubleSummaryStatistics doubleSummaryStatistics = Stream.of(1.0, 2.0, 3.0, 4.0).collect(Collectors.summarizingDouble(i -> i));
        System.out.println("DoubleSummaryStatistics: " + doubleSummaryStatistics);

        // 17. Collect statistics for longs
        // This collects statistics (sum, count, min, max, average) for longs and prints the result.
        LongSummaryStatistics longSummaryStatistics = Stream.of(1L, 2L, 3L, 4L).collect(Collectors.summarizingLong(i -> i));
        System.out.println("LongSummaryStatistics: " + longSummaryStatistics);

        // 18. Find the maximum value in a stream of doubles
        // This finds the maximum value in a stream of doubles and prints the result.
        Optional<Double> maxValue = Stream.of(1.0, 2.0, 3.0, 4.0).collect(Collectors.maxBy(Comparator.comparingDouble(i -> i)));
        System.out.println("Double maxValue: " + maxValue);

        // 19. Find the minimum value in a stream of longs
        // This finds the minimum value in a stream of longs and prints the result.
        Optional<Long> minValue = Stream.of(1L, 2L, 3L, 4L).collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println("Long minValue:" + minValue);


    }
}
