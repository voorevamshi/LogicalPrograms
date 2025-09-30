package com.vmc.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vmc.java8.dto.Address;
import com.vmc.java8.dto.Department;
import com.vmc.java8.dto.Employee;

public class OptionalMethods {

	public static void main(String[] args) {


		List<String> list1 = Arrays.asList("1", "3", "4");
		List<String> list2 = Arrays.asList("11", "33", "44");
		List<String> list3 = null;
		List<List<String>> listOfLists= new ArrayList<List<String>>();
		listOfLists.add(list1);
		listOfLists.add(list2);
		listOfLists.add(list3);
		
		// Using ofNullable map,flatMap and orElse methods
		List<Integer> intList2 = Optional
				.ofNullable(listOfLists).map(listOfList -> listOfList.stream().filter(Objects::nonNull)
						.flatMap(list -> list.stream()).map(str -> Integer.parseInt(str)).collect(Collectors.toList()))
				.orElse(new ArrayList<>());
		

		System.out.println(intList2);
		
		// Using ofNullable, map and orElseGet methods
		List<Integer> intList = Optional.ofNullable(list1)
				.map(list -> list.stream().filter(str -> OptionalMethods.isNumeric(str))
						.map(str -> Integer.parseInt(str)).collect(Collectors.toList()))
				.orElseGet(()->new ArrayList<>());
		System.out.println(intList);
		
		// Using flatMap and empty methods
		Optional<String> optional = Optional.of("123a");

		Optional<Integer> result = optional.flatMap(str -> {
		    try {
		        return Optional.of(Integer.parseInt(str));
		    } catch (NumberFormatException e) {
		        return Optional.empty();
		    }
		});
		System.out.println(optional+"------------"+result);
		
		List<Department> listOfDepartments = Utility.getDetailedDepartmentList();
		 // I want Hyderabad employee and salary grater than 50,000
		
		List<Address> deptEmpAddresses=Optional.ofNullable(listOfDepartments).map(optDepts -> optDepts.stream()
				.flatMap(dept -> Optional.ofNullable(dept.getEmployees())
						.map(optEmployees -> optEmployees.stream().flatMap(empList -> empList.getAddress().stream())
								.collect(Collectors.toList()))
						.orElse(new ArrayList<>()).stream())
				.collect(Collectors.toList())).orElse(new ArrayList<>());
		System.out.println(deptEmpAddresses.size()+":"+deptEmpAddresses);
		 
		List<Employee> employees=Utility.getEmployeeAddresses();
		List<Address> empAddList = Optional
				.ofNullable(employees).map(optEmployees -> optEmployees.stream()
						.flatMap(empList -> empList.getAddress().stream()).collect(Collectors.toList()))
				.orElse(new ArrayList<>());
		System.out.println(empAddList.size()+":"+empAddList);
	}

	public static boolean isNumeric(String str) {
		if (str == null || str.isEmpty())
			return false;
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
