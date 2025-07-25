package com.vmc.java8;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.vmc.java8.dto.Address;
import com.vmc.java8.dto.Employee;

public class InterviewOnOneToMany {
	public static void main(String[] args) {
		List<Employee> employees = Utility.getEmployeeAddresses();
		Map<String, Set<String>> empCityMap = employees.stream()
	            .collect(Collectors.groupingBy(
	                Employee::getName,
	                Collectors.flatMapping(
	                    emp -> emp.getAddress().stream().map(Address::getCityName),
	                    Collectors.toSet()
	                )
	            ));

	        empCityMap.forEach((empName, cities) ->
	            System.out.println("Employee Name: " + empName + " → Cities: " + cities));
	}
}
