package com.interview.infosys;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.interview.Employee;
import com.interview.EmployeeUtility;
import com.interview.Logic;

public class AverageSalaryGroupByDepartment implements Logic {

	@Override
	public void execute() {

		List<Employee> employeesList = EmployeeUtility.getEmployees();

		List<Employee> employeesBefore2010 = employeesList.stream().filter(emp -> emp.getJoiningDate().getYear() < 2010)
				.collect(Collectors.toList());
		Map<String, Double> avgSalaryByDepartment = employeesBefore2010.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		Set<String> highestSalaryByDepartment = avgSalaryByDepartment.entrySet().stream()
				.filter(entry -> entry.getValue() > 60000).map(Map.Entry::getKey).collect(Collectors.toSet());
		highestSalaryByDepartment.forEach(highestSalDep -> System.out.println("highestSalDep:" + highestSalDep));
		List<Employee> resultEmployees = employeesBefore2010.stream()
				.filter(emp -> highestSalaryByDepartment.contains(emp.getDepartment())).collect(Collectors.toList());

		resultEmployees.forEach(emp -> System.out.println(emp.getName()));

	}

	@Override
	public void executeWithSoultion2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeWithSoultion3() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeUsingJava8() {
		// TODO Auto-generated method stub

	}
}
