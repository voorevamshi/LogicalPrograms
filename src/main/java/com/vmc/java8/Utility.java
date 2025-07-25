package com.vmc.java8;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vmc.java8.dto.Address;
import com.vmc.java8.dto.Department;
import com.vmc.java8.dto.EmpDept;
import com.vmc.java8.dto.Employee;

public class Utility {

	public static void printArray(Object array) {
		if (array instanceof int[]) {
			System.out.println("Array: " + Arrays.toString((int[]) array));
		} else if (array instanceof float[]) {
			System.out.println("Array: " + Arrays.toString((float[]) array));
		} else if (array instanceof double[]) {
			System.out.println("Array: " + Arrays.toString((double[]) array));
		} else {
			throw new IllegalArgumentException(
					"Unsupported array type. Only int[], float[], and double[] are allowed.");
		}
	}

	public static <T> void printList(List<T> list) {
		System.out.println("List data: " + list);
	}

	public static <T> void printSet(List<T> set) {
		System.out.println("Set data: " + set);
	}

	public static <T, S> void printMap(Map<T, S> map) {
		System.out.println("Map data: " + map);
	}

	public static List<Employee> getEmployees() {
		List<Employee> employees = Arrays.asList(
				new Employee(1, "Avanthi", 50000.0, 'F', new Date()),
				new Employee(2, "Barath", 60000.0, 'M', new Date()),
				new Employee(3, "Chandu", 40000.0, 'M', new Date()), 
				new Employee(4, null, 70000.0, 'F', new Date()));
		return employees;
	}

	public static List<Employee> getDepartmentEmployees() {
		Department hr = new Department(1, "HR");
		Department it = new Department(2, "IT");
		Department finance = new Department(3, "Finance");

		List<Employee> employees = new ArrayList<>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			employees.add(new Employee(101, "Avanthi", 50000.0, 'F', sdf.parse("2020-01-10"), hr));
			employees.add(new Employee(102, "Barath", 60000.0, 'M', sdf.parse("2019-03-25"), it));
			employees.add(new Employee(103, "Chandu", 40000.0, 'M', sdf.parse("2021-07-19"), hr));
			employees.add(new Employee(104, "Deepika", 70000.0, 'F', sdf.parse("2018-11-05"), finance));
			employees.add(new Employee(105, "Eve", 65000.0, 'F', sdf.parse("2022-02-15"), it));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	public static List<Employee> getEmployeeAddresses() {
		List<Employee> employees = null;
		try {
			employees = List.of(
					new Employee(101, "Avanthi", 50000.0, 'F', new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-10"),
							List.of(new Address("1st St", "New York"), new Address("2nd St", "Boston"))),

					new Employee(102, "Barath", 60000.0, 'M', new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-25"),
							List.of(new Address("Tech Park", "San Francisco"))),

					new Employee(103, "Chandu", 40000.0, 'M', new SimpleDateFormat("yyyy-MM-dd").parse("2021-07-19"),
							List.of(new Address("Main St", "Boston"), new Address("5th Ave", "Chicago"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	public static List<EmpDept> getEmpDepts() {

		List<EmpDept> employees = new ArrayList<>();
		employees.add(new EmpDept(101, "Avanthi", 50000.0, 'F', "2020-01-10", "hr"));
		employees.add(new EmpDept(102, "Barath", 60000.0, 'M', "2019-03-25", "it"));
		employees.add(new EmpDept(103, "Chandu", 40000.0, 'M', "2021-07-19", "hr"));
		employees.add(new EmpDept(104, "Deepika", 70000.0, 'F', "2018-11-05", "finance"));
		employees.add(new EmpDept(105, "Eve", 65000.0, 'F', "2022-02-15", "it"));
		/*	employees.add(new EmpDept(101, "Avanthi", 50000.0, 'F', "2020-01-10", "hr"));
		employees.add(new EmpDept(102, "Arun", 60000.0, 'M', "2019-03-25", "it"));
		employees.add(new EmpDept(103, "Anand", 40000.0, 'M', "2021-07-19", "hr"));
		employees.add(new EmpDept(104, "Avanthi", 70000.0, 'F', "2018-11-05", "finance"));
		employees.add(new EmpDept(105, "Ajay", 65000.0, 'F', "2022-02-15", "it"));*/
		return employees;
	}

	public static String getJsonString(Object obj) {
		String jsonString = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			if (obj instanceof EmpDept) {
				EmpDept empDept = (EmpDept) obj;
				jsonString = objectMapper.writeValueAsString(empDept);
			} else if (obj instanceof Map) {
				Map map = (Map) obj;
				jsonString = objectMapper.writeValueAsString(map);
			} else if (obj instanceof List) {
				List list = (List) obj;
				jsonString = objectMapper.writeValueAsString(list);
			} else if (obj instanceof Employee) {
				Employee employee = (Employee) obj;
				jsonString = objectMapper.writeValueAsString(employee);
			} else if (obj instanceof Set) {
				Set set = (Set) obj;
				jsonString = objectMapper.writeValueAsString(set);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonString;
	}

}
