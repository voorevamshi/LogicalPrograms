package com.vmc.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.vmc.java8.dto.EmpDept;


public class InterviewOnOneToOne {

	public static void main(String[] args) {
        List<EmpDept> employees = Utility.getEmpDepts();
        System.out.println("Employees:"+Utility.getJsonString(employees));
        //1. getDepartment Wise ListOfEmployee
        Map<String,List<EmpDept>> deptWiseEmployees=employees.stream().collect(Collectors.groupingBy(EmpDept::getDepartment));
        System.out.println("1.DepartmentWiseEmployees:"+Utility.getJsonString(deptWiseEmployees));
       
        //2. getDepartment Wise CountOfEmployees
        Map<String,Long> deptWiseEmployeesCount= employees.stream().collect(Collectors.groupingBy(EmpDept::getDepartment,Collectors.counting()));
        System.out.println("2.departmentWiseEmployeeCount:"+Utility.getJsonString(deptWiseEmployeesCount));
        
        //3. getDepartment Wise Employee Highest Salary
        Map<String,Optional<EmpDept>> deptWiseHighestSal= employees.stream().collect(Collectors.groupingBy(EmpDept::getDepartment,Collectors.maxBy(Comparator.comparingDouble(EmpDept::getSalary))));
        System.out.print("3.departmentWiseHighestSalary");
        deptWiseHighestSal.forEach((dept,employee)->System.out.print(" dept:"+dept+","+Utility.getJsonString(employee.get())));
        
        
        //4. getDepartment Wise Employee Second Highest Salary
        Map<String,Optional<EmpDept>> deptWiseSecondHighestSal= employees.stream().collect(Collectors.groupingBy(EmpDept::getDepartment,
        		Collectors.collectingAndThen(Collectors.toList(),
						emplist->emplist.stream().sorted(Comparator.comparingDouble(EmpDept::getSalary).reversed()).skip(1).findFirst()))); 
        System.out.print("4.deptWiseSecondHighestSalary:");
        deptWiseSecondHighestSal.forEach((dept,employee)->{System.out.print(" dept:"+dept);
        employee.ifPresentOrElse(emp->System.out.print(","+emp),()->System.out.print("No second highest salary"));
        });
        
        //5. Which department has more count of employees
        Optional<Entry<String, Long>> departmentWiseHighesEmpCount = deptWiseEmployeesCount.entrySet().stream()
				.max(Map.Entry.comparingByValue());
		System.out.println("5.departmentWiseHighestEmpCount:" + departmentWiseHighesEmpCount.get());
        
        //6.Which department has more employees gender based average salary whose stay India and and above 10,000 salary
		Map<Character, Double> genderByEmployeesSalary=employees.stream().collect(Collectors.groupingBy(EmpDept::getGender, Collectors.averagingDouble(EmpDept::getSalary)));
		Map<Character, Double> genderByEmployeesSalaryAbove50K=genderByEmployeesSalary.entrySet().stream().filter(entry->(entry.getValue()>50000d))
				.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
		System.out.println("6.genderByEmployeesSalaryAbove50K:"+Utility.getJsonString(genderByEmployeesSalaryAbove50K));
		
		//7. list sort by employee name & id 
		List<EmpDept>  sortByEmpNameAndId=employees.stream().sorted(Comparator.comparing(EmpDept::getName).thenComparing(EmpDept::getId)).collect(Collectors.toList());
		System.out.println("7.sortByEmpNameAndId:"+Utility.getJsonString(sortByEmpNameAndId));
		
		//8. print list even & odd id's separately
		Map<Boolean,List<EmpDept>> evenOddIdsMap=employees.stream().collect(Collectors.partitioningBy(emp->emp.getId()%2==0));
		System.out.println("8.evenOddIdsMap:"+Utility.getJsonString(evenOddIdsMap));
	
		//9. even list & odd list common gender and salary grater then 50K
		List<EmpDept> evenList = evenOddIdsMap.get(true);
		List<EmpDept> oddList = evenOddIdsMap.get(false);
		List<Character> evenGender= evenList.stream().filter(emp->(emp.getSalary()>50000d)).map(emp->emp.getGender()).collect(Collectors.toList());
		List<Character> oddGender= oddList.stream().filter(emp->(emp.getSalary()>50000d)).map(emp->emp.getGender()).collect(Collectors.toList());
		List<EmpDept> finalEvenList=evenList.stream().filter(emp->(evenGender.contains(emp.getGender()) && emp.getSalary()>50000d)).collect(Collectors.toList());
		List<EmpDept> finalOddList=oddList.stream().filter(emp->oddGender.contains(emp.getGender()) && emp.getSalary()>50000d).collect(Collectors.toList());
		System.out.println("9.finalEvenList:"+Utility.getJsonString(finalEvenList)+",finalOddList:"+Utility.getJsonString(finalOddList));
		
		//10. find the first non-repeated number
		Integer firstNonRepeated = Arrays.asList(4, 10, 3, 4, 1).stream().filter(i -> Collections.frequency(Arrays.asList(4, 10, 3, 4, 1), i) == 1).findFirst().orElse(null);
		System.out.println("10.firstNonRepeated:"+firstNonRepeated); // Output: 10



	}

}
