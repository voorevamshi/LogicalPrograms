package com.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

class DepartmentWiseEmployeeList implements Logic {

	@Override
	public void execute() {

		List<Employee> employeesList = EmployeeUtility.getEmployees();
		// Group employees by department
		Map<Object, List<Employee>> departmentWiseEmployeeList = employeesList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		
		departmentWiseEmployeeList.forEach((department, empList) -> {
			System.out.println("Department: " + department);
			empList.forEach(System.out::println);
		});
		// Group employees count by department
		Map<String, Long> departmentWiseEmployeeCount = employeesList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("departmentWiseEmployeeCount:" + departmentWiseEmployeeCount);
		
		// Group employees highest count by department
		Map<String, Long> departmentWiseEmpCount = employeesList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		Optional<Entry<String, Long>> departmentWiseHighesEmpCount = departmentWiseEmpCount.entrySet().stream()
				.max(Map.Entry.comparingByValue());
		System.out.println("departmentWiseHighesEmpCount:" + departmentWiseHighesEmpCount);
						
        // Group employees by department and get the employee with the highest salary in each department
		Map<String, Optional<Employee>> highestSalaryByDept = employeesList.stream().collect(Collectors.groupingBy(
				Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		System.out.println("departmentWiseEmployeeCount:" + departmentWiseEmployeeCount);
		highestSalaryByDept.forEach((department, emp) -> {
			System.out.println("Department: " + department);
			emp.ifPresent(System.out::println);
		});
		// Group employees by gender and get the employee with the average salary in each department
		Map<String, Double> averageSalaryByGender = employeesList.stream().collect(Collectors.groupingBy(
				Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		averageSalaryByGender.forEach((gender, averageSalary) -> {
			System.out.println("Gender: " + gender+",averageSalary:"+averageSalary);
		});
        // Group employees by department and get the employee with the second highest salary in each department
		Map<String,  Optional<Employee>> secondHighestSalaryByDept = employeesList.stream().collect(Collectors.groupingBy(
				Employee::getDepartment, Collectors.collectingAndThen(Collectors.toList(),
						emplist->emplist.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst())));
		secondHighestSalaryByDept.forEach((department, emp) -> {
			System.out.println("secondHighestSalaryByDepartment: " + department);
			emp.ifPresentOrElse(System.out::println,() -> System.out.println("No second highest salary employee"));
		});
		// Even odd employee salary
		Map<Boolean, List<Employee>> evenOddSalary = employeesList.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getSalary() % 2 == 0));
		evenOddSalary.forEach((i,j)->System.out.println("partitioningBy Salary:"+i+"-"+j));
		// Even odd employee salary
		Map<Boolean, List<Integer>> evenOddNbrs = Arrays.asList(1, 3, 5, 6, 7).stream()
				.collect(Collectors.partitioningBy(i -> i % 2 == 0));
		evenOddNbrs.forEach((i,j)->System.out.println("partitioningBy:"+i+"-"+j));
		//list1 ,list2 common elements
		List<Integer> list1=Arrays.asList(1, 3, 5, 6, 7);
		List<Integer> list2=Arrays.asList(2, 6, 7, 9, 10);
		List<Integer> commonList=list1.stream().filter(i->list2.contains(i)).collect(Collectors.toList());
		System.out.println("commonList:"+commonList);
		List<Integer> nonCommonList=list1.stream().filter(i->!list2.contains(i)).collect(Collectors.toList());
		System.out.println("nonCommonList:"+nonCommonList);//Not working
		//list1 with  emp1,emp2,emp3… 100 employees and list2 with  emp1,emp2,emp3… 100 employees common elements who is department is IT and salary grater 60000
		List<Employee> employeesList1 = EmployeeUtility.getEmployees1();
		List<Employee> commonEmpList = employeesList.stream().filter(emp -> employeesList1.contains(emp)).filter(emp->"IT".equals(emp.getDepartment()))
				.filter(emp-> emp.getSalary()>60000)
				.collect(Collectors.toList());
		System.out.println("commonEmpList:" + commonEmpList);
		
	}

	@Override
	public void executeWithSoultion2() {
	}

	@Override
	public void executeWithSoultion3() {
	}

	@Override
	public void executeUsingJava8() {
	}

}
