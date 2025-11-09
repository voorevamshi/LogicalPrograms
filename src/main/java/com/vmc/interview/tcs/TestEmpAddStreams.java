package com.vmc.interview.tcs;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vmc.interview.EmployeeReal;
import com.vmc.interview.EmployeeUtility;

public class TestEmpAddStreams {

	public static void main(String[] args) {
		List<EmployeeReal> employeeList = EmployeeUtility.getRealEmployees();
		List<EmployeeReal> tempEmployeeList = employeeList;
		//Use the allMatch method to check if any of the employee's addresses have a state is "Telangana".
		employeeList = employeeList.stream()
				.filter(emp -> emp.getAddress().stream().allMatch(add -> add.getState().equals("Telangana")))
				.collect(Collectors.toList());
		System.out.println(employeeList);
		//Use the method to check if any of the employee's addresses have a city is "Hyderabad".
		Map<Object, List<String>> employeeMap= employeeList.stream()
		.filter(emp -> emp.getAddress().stream().allMatch(add -> add.getState().equals("Telangana")))
		.collect(Collectors.groupingBy(emp->emp.getDepartment(),Collectors.mapping(emp->emp.getName(), Collectors.toList())));
		
		System.out.println(employeeMap);
		//getDepartment Wise Employee Highest Salary
		Map<String, Optional<EmployeeReal>> map = tempEmployeeList.stream().collect(Collectors.groupingBy(
				emp -> emp.getDepartment(), Collectors.maxBy(Comparator.comparing(emp -> emp.getSalary()))));
		System.out.println(map);
		//Which department has more count of employees
		System.out.println(map);
		//Which department has more count of employees
		Map<String, Long> map1 = tempEmployeeList.stream().collect(Collectors.groupingBy(EmployeeReal::getDepartment,
				Collectors.mapping(EmployeeReal::getDepartment, Collectors.counting())));
		System.out.println(map1);
		
	}

}
