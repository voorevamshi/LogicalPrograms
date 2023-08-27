package com.vmc.java8;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SingleTableQueries {

	public static void main(String[] args) {
		// 1.Second highest salary
		List<Employee> employeeList = addEmployees();
		printInput(employeeList);
		// 1)second highest element of array
		employeeList = returnSecondHighestSalary(employeeList);
		printOutput(employeeList);
		System.out.println("\nSecondHighest Salary:\t" + employeeList.get(1));
	}

	private static List<Employee> returnSecondHighestSalary(List<Employee> employeeList) {
		employeeList = employeeList.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
				.collect(Collectors.toList());
		return employeeList;
	}

	private static void printInput(List<Employee> employeeList) {
		System.out.print("Input:\t");
		employeeList.stream().forEach(System.out::println);
	}

	private static void printOutput(List<Employee> employeeList) {
		System.out.println();
		System.out.print("Output:\t");
		employeeList.stream().forEach(System.out::println);
	}

	private static List<Employee> addEmployees() {
		// Adding Employee data id; name; salary; age; joinDate;
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(1, "vamshi", 10000.0, 'M',
				Date.from(LocalDate.of(1993, 2, 28).atStartOfDay(ZoneId.systemDefault()).toInstant())));
		employeeList.add(new Employee(2, "Ajay", 20000.0, 'M',
				Date.from(LocalDate.of(1995, 1, 26).atStartOfDay(ZoneId.systemDefault()).toInstant())));
		employeeList.add(new Employee(3, "Laxmi", 8000.0, 'F',
				Date.from(LocalDate.of(1973, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant())));
		employeeList.add(new Employee(4, "Ramesh", 12000.0, 'M',
				Date.from(LocalDate.of(1963, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant())));
		employeeList.add(new Employee(4, "Harika", 5000.0, 'F',
				Date.from(LocalDate.of(1996, 07, 13).atStartOfDay(ZoneId.systemDefault()).toInstant())));
		return employeeList;
	}

}
