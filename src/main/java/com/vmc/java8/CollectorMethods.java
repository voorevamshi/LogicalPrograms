package com.vmc.java8;

import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vmc.java8.dto.EmpDept;

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
        Map<Integer, String> map1 = Stream.of("A", "BB", "CCC").collect(Collectors.toMap(String::length, s->s));
        System.out.println("Map with Two arguments: " + map1);
        
        Map<Integer, String> map2 = Stream.of("A", "BB", "CC").collect(Collectors.toMap(String::length, s->s,(v1, v2) -> v1 + ", " + v2));
        System.out.println("Map with Three arguments: " + map2);
        
        //TreeMap, sorted by key (v1, v2) -> v1  first value, and (v1, v2) -> v2 returns last value
        Map<Integer, String> map3 = Stream.of("A", "DD", "FF","CC","EEE").collect(Collectors.toMap(String::length, Function.identity(),(v1, v2) -> v1 , TreeMap::new));
        System.out.println("Map with Four arguments: " + map3);
        
        Map<String,Double> map4 = Utility.getEmpDepts().stream().collect(Collectors.toMap(EmpDept::getName,EmpDept::getSalary));
        System.out.println("Map with Employee data: " + map4);
        // 4. Join elements into a single string
        // This joins the stream elements into a single string separated by ", " and prints the result.
        String joinStr1 = Stream.of("A", "B", "C").collect(Collectors.joining());
        System.out.println("joining String"+joinStr1); // "ABC"

        String joinStr2 = Stream.of("A", "B", "C").collect(Collectors.joining(", "));
        System.out.println("joining String with delimiter: " + joinStr2);
        
        String joinStr3 = Stream.of("A", "B", "C").collect(Collectors.joining(", ", "[", "]"));
        System.out.println("joining String with delimiter,prefix,suffix: " + joinStr3);
        
        // 5. Group elements by their length
        // This groups the stream elements by their length into a Map and prints the result.
        //groupingByClassifier, Downstream Collector
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
        
        //groupingBy Classifier, Supplier<Map>, Downstream Collector
        Map<Integer, List<String>> groupMapWithSupplier = Stream.of("a", "bb", "cc").collect(Collectors.groupingBy(String::length,TreeMap::new,Collectors.toList()));
        System.out.println("Group Count Map: " + groupMapWithSupplier);
        
        
        // 8. Partition elements into two groups
        // This partitions the stream elements into two groups (even and odd numbers) and prints the result.
        Map<Boolean, List<Integer>> partitionMap = Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("partitioning  Map: " + partitionMap);
        
        Map<Boolean, Long> result = Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(n -> n % 2 == 0,Collectors.counting()));
        System.out.println("partitioning  Predicate, Downstream Collector: " + result);

        // 9. Count the number of elements in the stream
        // This counts the number of elements in the stream and prints the result.
        long count = Stream.of("A", "B", "C").collect(Collectors.counting());
        System.out.println("Count: " + count);

        // 10. Reduce the stream to a single value
        
        Optional<Integer> max = Stream.of(3, 5, 7, 2).collect(Collectors.reducing(Integer::max));
        System.out.println("Reduced Value BinaryOperator: "+max.get());  // 7
        // This reduces the stream to a single value by summing the integers and prints the result.
        int reducedValue = Stream.of(1, 2, 3, 4).collect(Collectors.reducing(0, Integer::sum));
        System.out.println("Reduced Value identity,BinaryOperator : " + reducedValue);
        double totalSalary = Utility.getEmployees().stream().collect(Collectors.reducing(0.0,e -> e.getSalary(),Double::sum));
        System.out.println("Reduced Value identity,mapper,BinaryOperator : " + totalSalary);
        
        // 11. Map each element to its double and collect into a List
        // This maps each element to its double and collects the results into a List, then prints the result.
        List<Integer> mappingList = Stream.of(1, 2, 3, 4).collect(Collectors.mapping(i -> i * 2, Collectors.toList()));
        System.out.println("Mapping List: " + mappingList);
        
        List<String> mappingNames = Utility.getEmpDepts().stream().collect(Collectors.mapping(EmpDept::getName,Collectors.toList()));
        System.out.println("Mapping Employee: " + mappingNames);

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
        Optional<Double> maxValue = Stream.of(1.0, 2.0, 3.0, 4.0).collect(Collectors.maxBy(Comparator.comparing(i -> i)));
        System.out.println("Double maxValue: " + maxValue);

        // 19. Find the minimum value in a stream of longs
        // This finds the minimum value in a stream of longs and prints the result.
        Optional<Long> minValue = Stream.of(1L, 2L, 3L, 4L).collect(Collectors.minBy(Comparator.naturalOrder()));
        System.out.println("Long minValue:" + minValue);


    }
}
