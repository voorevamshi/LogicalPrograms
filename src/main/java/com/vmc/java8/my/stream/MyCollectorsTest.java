package com.vmc.java8.my.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MyCollectorsTest {
	 public static void main(String[] args) {
	        List<String> names = List.of("john", "jane", "max", "julia");

	        System.out.println("--- MyStream map + filter ---");
	        MyStream.of(names)
	            .filter(n -> n.startsWith("j"))
	            .map(String::toUpperCase)
	            .forEach(System.out::println);

	        System.out.println("\n--- MyCollectors groupingBy ---");
	        Map<Integer, List<String>> grouped = MyCollectors.groupingBy(names, String::length);
	        grouped.forEach((k, v) -> System.out.println(k + " -> " + v));

	        System.out.println("\n--- MyCollectors averaging ---");
	        List<Integer> numbers = List.of(10, 20, 30, 40);
	        double avg = MyCollectors.averaging(numbers, Integer::doubleValue);
	        System.out.println("Average: " + avg);

	        System.out.println("\n--- MyCollectors maxBy ---");
	        Optional<String> longest = MyCollectors.maxBy(names, Comparator.comparingInt(String::length));
	        longest.ifPresent(name -> System.out.println("Longest: " + name));	
	        
	        System.out.println("\n--- MyCollectors countingBy (Department-wise Employee Count) ---");
	        List<Employee> employees = List.of(
	            new Employee("Alice", "HR"),
	            new Employee("Bob", "IT"),
	            new Employee("Charlie", "HR"),
	            new Employee("David", "Finance"),
	            new Employee("Eva", "IT")
	        );

	        Map<String, Long> deptWiseCount = MyCollectors.countingBy(employees, Employee::getDepartment);
	        deptWiseCount.forEach((dept, count) -> System.out.println(dept + " -> " + count));
	    }
}
