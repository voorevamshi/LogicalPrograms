package com.vmc.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.vmc.java8.dto.Address;
import com.vmc.java8.dto.EmpDept;
import com.vmc.java8.dto.Employee;

import static com.vmc.java8.Utility.getDetailedEmployeeList;

public class InterviewOnOneToMany {
	public static void main(String[] args) {

		List<Employee> employees = Utility.getDetailedEmployeeList();
		//1. getDepartment Wise ListOfEmployee
		Map<String,List<Employee>> deptWiseEmployees=employees.stream().filter(Objects::nonNull)
				.filter(emp->(null!=emp.getDepartment()&& null!=emp.getDepartment().getDeptName()))
				.collect(Collectors.groupingBy(emp->emp.getDepartment().getDeptName()));
		System.out.println("1.DepartmentWiseEmployees:"+Utility.getJsonString(deptWiseEmployees));

		//2. getDepartment Wise CountOfEmployees
		Map<String,Long> deptWiseEmployeesCount= employees.stream().filter(Objects::nonNull)
				.filter(emp->(null!=emp.getDepartment()&& null!=emp.getDepartment().getDeptName()))
				.collect(Collectors.groupingBy(emp->emp.getDepartment().getDeptName(),Collectors.counting()));

		System.out.println("2.departmentWiseEmployeeCount:"+Utility.getJsonString(deptWiseEmployeesCount));

		Map<String, Set<String>> empCityMap = employees.stream().filter(Objects::nonNull)
	            .collect(Collectors.groupingBy(
	                Employee::getName,
	                Collectors.flatMapping(
	                    emp -> {return emp.getAddress()!=null?emp.getAddress().stream().filter(Objects::nonNull).map(Address::getCityName): Stream.of("") ;},
	                    Collectors.toSet()
	                )
	            ));

		empCityMap.forEach((empName, cities) -> System.out.println("Employee Name: " + empName + " → Cities: " + cities));
	}
}
