package com.vmc.interview.deloitte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.vmc.interview.Employee;
import com.vmc.interview.EmployeeUtility;
import com.vmc.interview.Logic;

public class ListOfListToList implements Logic {

	@Override
	public void execute() {
		List<List<Employee>> listOfList = new ArrayList<List<Employee>>();
		listOfList.add(EmployeeUtility.getEmployees());
		listOfList.add(EmployeeUtility.getEmployees1());
		System.out.println(listOfList);
		//convert listOfList to list
		List<Employee> updatedList = listOfList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		System.out.println(updatedList);
		//get employee names whose salary is grater than 10,000
		List<String> empNames=updatedList.stream().filter(emp->emp.getSalary()>10000).map(emp->emp.getName()).collect(Collectors.toList());
		System.out.println(empNames);
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
