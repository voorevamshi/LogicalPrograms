package com.vmc.java8;

import java.util.*;
import java.util.stream.Collectors;

public class ComparatorMethods {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 50000.0, 'F', new Date()),
                new Employee(2, "Bob", 60000.0, 'M', new Date()),
                new Employee(3, "Charlie", 40000.0, 'M', new Date()),
                new Employee(4, null, 70000.0, 'F', new Date())
        );

        // 1. Comparator.comparing
      List<Employee> sortedByNameWithoutNull = employees.stream()
          .filter(e -> e != null && e.getName() != null) // Exclude null employees and employees with null names
          .sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
      System.out.println("Sorted by Name (ignoring null employees): " + sortedByNameWithoutNull);

        // Fixed: Handle null values in the name field by placing them first
        List<Employee> sortedByName = employees.stream() .sorted(Comparator.comparing(Employee::getName, Comparator.nullsFirst(Comparator.naturalOrder())))
                .collect(Collectors.toList());
        System.out.println("Sorted by Name with Nulls First: " + sortedByName);

        // 2. Comparator.comparingInt
        List<Employee> sortedById = employees.stream().sorted(Comparator.comparingInt(Employee::getId)).collect(Collectors.toList());
        System.out.println("Sorted by ID: " + sortedById);

        // 3. Comparator.comparingDouble
        List<Employee> sortedBySalaryDouble = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).collect(Collectors.toList());
        System.out.println("Sorted by Salary (Double): " + sortedBySalaryDouble);

        // 4. Comparator.comparingLong
        List<Employee> sortedByJoinDate = employees.stream().sorted(Comparator.comparingLong(e -> e.getJoinDate().getTime())).collect(Collectors.toList());
        System.out.println("Sorted by Join Date: " + sortedByJoinDate);

        // 5. Comparator.naturalOrder (requires Comparable implementation)
        // 5. Comparator.naturalOrder (with null handling)
        employees.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println("Sorted by Name (Natural Order with Nulls First): " + employees);


        // 6. Comparator.reverseOrder
        employees.sort( Comparator.nullsFirst(Comparator.reverseOrder()));
        System.out.println("Sorted by Name (Reverse Order with Nulls First): " + employees);

        // 7. Comparator.nullsFirst
        employees.sort(Comparator.comparing(Employee::getName, Comparator.nullsFirst(Comparator.naturalOrder())));
        System.out.println("Sorted by Name (Nulls First): " + employees);

        // 8. Comparator.nullsLast
        employees.sort(Comparator.comparing(Employee::getName, Comparator.nullsLast(Comparator.naturalOrder())));
        System.out.println("Sorted by Name (Nulls Last): " + employees);

        // 9. Comparator.thenComparing
        List<Employee> sortedBySalaryThenName = employees.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName))
                .collect(Collectors.toList());
        System.out.println("Sorted by Salary, then Name: " + sortedBySalaryThenName);

      //10. Sort employees by salary in descending order
      List<Employee> sortedBySalaryDescending = employees.stream()
              .sorted(Comparator.comparing(Employee::getSalary).reversed())
              .collect(Collectors.toList());
    }
}


