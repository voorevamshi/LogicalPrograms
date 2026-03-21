package com.vmc.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.vmc.java8.dto.Employee;

public class PlayGroud {

	public static void main(String[] args) {
		List<Employee> employees = Utility.getDepartmentEmployees();
		Utility.getMessageWithJsonString("employees", employees);
		// 1. getDepartment Wise Sort the employees
		Map<String, List<Employee>> deptwiseEmployees = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getDeptName(),
						Collectors.collectingAndThen(Collectors.toList(), list -> list.stream()
								.sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList()))));
		Utility.getMessageWithJsonString("deptwiseEmployees", deptwiseEmployees);

		// 2. getDepartment Wise ThirdHigestSalary
		Map<String, Employee> deptWiseThirdHigestSalaryEmployee = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getDeptName(),
						Collectors.collectingAndThen(Collectors.toList(),
								list -> list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
										.skip(2).findFirst().orElse(new Employee(null, null, null, null, null)))));
		Utility.getMessageWithJsonString("deptWiseThirdHigestSalaryEmployee", deptWiseThirdHigestSalaryEmployee);

		// 3. getDepartment Wise Top Two HigestSalary Employees
		Map<String, List<Employee>> deptWiseTopTwoHigestSalaryEmployees = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getDeptName(),
						Collectors.collectingAndThen(Collectors.toList(),
								list -> list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
										.limit(2).collect(Collectors.toList()))));
		Utility.getMessageWithJsonString("deptWiseTopTwoHigestSalaryEmployees", deptWiseTopTwoHigestSalaryEmployees);

		// 3.Which department wise count of employees
		Map<String, Integer> departmentWiseCountOfExmploeesMap = employees.stream()
				.collect(Collectors.groupingBy(emp -> emp.getDepartment().getDeptName(),
						Collectors.collectingAndThen(Collectors.toList(), List::size)));
		Utility.getMessageWithJsonString("departmentWiseCountOfExmploeesMap", departmentWiseCountOfExmploeesMap);

		// 4.Which department has highest count of employees

		Entry<String, Integer> maxEntry = departmentWiseCountOfExmploeesMap.entrySet().stream()
				.max(Entry.comparingByValue()).get();
		System.out.println("Department with highest count: ");
		Integer maxEntryValue = maxEntry.getValue();
		departmentWiseCountOfExmploeesMap.entrySet().stream().filter(e -> e.getValue() == maxEntryValue)
				.forEach(System.out::println);
		// 5. City wise count of employees → Get count of employees grouped by city.
		// List<Employee> detailedEmployees = Utility.getDetailedEmployeeList();
		// employees.stream().collect(Collectors.groupingBy(Employee::ci))

	}

}
