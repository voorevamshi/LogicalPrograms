package com.vmc.java8;

import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.vmc.java8.dto.Address;
import com.vmc.java8.dto.Employee;

public class CollectorGroupingMethodsV2 {
	public static void main(String[] args) {
		List<Employee> employees = Utility.getDepartmentEmployees();
		
		// 1. getDepartment Wise ListOfEmployees
		Map<String, List<Employee>> deptEmployees = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getDeptName()));
		//System.out.print("Dept wise employees:");
		//Utility.getJsonString(deptEmployees);
		
		// 2. getDepartment Wise ListOfEmployees count
		Map<String, Long> deptEmployeesCount = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getDeptName(), Collectors.counting()));
		//System.out.print("Dept wise employees count:");
		//Utility.getJsonString(deptEmployeesCount);
		
		// 3.getDepartment Wise Employee Highest 
		Map<String, Double> deptEmployeesHighestSal = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getDeptName(),
						Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
								.map(emp -> emp.getSalary()).sorted(Comparator.reverseOrder()).findFirst().get())));
		//System.out.print("Dept wise employees Higest Salary:");
		//Utility.getJsonString(deptEmployeesHighestSal);
		
		// 4.getDepartment Wise Employee Second Highest 
		Map<String, Double> deptEmployeesSecHighestSal = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getDeptName(),
						Collectors.collectingAndThen(Collectors.toList(),
								list -> list.stream().map(emp -> emp.getSalary()).sorted(Comparator.reverseOrder())
										.skip(1).findFirst()
										.orElseThrow(() -> new RuntimeException("No Second Highest Salary Found")))));
		//System.out.print("Dept wise employees Second Higest Salary:");
		//Utility.getJsonString(deptEmployeesSecHighestSal);
		
		// 5. Which department has Highest count of employees
		Map<String, Integer> deptCountEmployees = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getDeptName(),
						Collectors.collectingAndThen(Collectors.toList(), List::size)));
		int deptHighestEmpCount=deptCountEmployees.entrySet().stream().map(entry->entry.getValue()).max(Comparator.naturalOrder()).get();
		//System.out.print("Department has Highest count of employees:"+deptHighestEmpCount);
		//Utility.getJsonString(deptCountEmployees);
		
		// 6. Which department has more employees
		// gender based average salary whose stay hyd and and above 10,000 salary
		Map<Character, Double> genderAvgSalMap = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getGender(),
						Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
								.map(Employee::getSalary).collect(Collectors.summarizingDouble(i -> i)).getAverage())));
		
		Map<Character, Double> genderAvgSalMapGraterThan10K = genderAvgSalMap.entrySet().stream().filter(entry -> entry.getValue() > 10000.0D).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
		Utility.getJsonString(genderAvgSalMapGraterThan10K);
		
		// 7.Department wise top 3 employees salaries
		Map<String, List<Employee>> deptTop3SalEmps = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getDeptName(),
						Collectors.collectingAndThen(Collectors.toList(),
								list -> list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
										.limit(2).collect(Collectors.toList()))));

		 //System.out.print("Department wise top 3 employees salaries:");
		 //Utility.getJsonString(deptTop3SalEmps);
		
		// Department wise list of address.
		List<Employee> detailedemployees = Utility.getDetailedEmployeeList();
		Map<Object, Object> deptAddress = detailedemployees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getDeptName(),
						Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
								.flatMap(emp -> emp.getAddress().stream()).collect(Collectors.toList()))));
		//System.out.print("Department wise list of address:");
		//Utility.getJsonString(deptAddress);
			
	}
}
