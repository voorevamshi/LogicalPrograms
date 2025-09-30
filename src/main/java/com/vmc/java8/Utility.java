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
		List<Employee> employees = Arrays.asList(new Employee(1, "Avanthi", 50000.0, 'F', new Date()),
				new Employee(2, "Barath", 60000.0, 'M', new Date()),
				new Employee(3, "Hanvik", 40000.0, 'M', new Date()), new Employee(4, null, 70000.0, 'F', new Date()));
		return employees;
	}

	public static List<Employee> getDepartmentEmployees() {
		Department hr = new Department(1, "HR");
		Department it = new Department(2, "IT");
		Department finance = new Department(3, "Finance");

		List<Employee> employees = new ArrayList<>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			employees.add(new Employee(101, "Ajay", 50000.0, 'M', sdf.parse("2020-01-10"), it));
			employees.add(new Employee(102, "Vamshi", 60000.0, 'M', sdf.parse("2019-03-25"), it));
			employees.add(new Employee(103, "Hanvik", 20000.0, 'M', sdf.parse("2025-02-25"), hr));
			employees.add(new Employee(104, "Deepika", 70000.0, 'F', sdf.parse("2018-11-05"), finance));
			employees.add(new Employee(105, "Sreeja", 65000.0, 'F', sdf.parse("2022-02-15"), finance));
			employees.add(new Employee(106, "Shreshta", 15000.0, 'F', sdf.parse("2025-06-26"), hr));
			employees.add(new Employee(107, "Ramesh", 95000.0, 'M', sdf.parse("1995-01-01"), finance));
			employees.add(new Employee(108, "VijayaLaxmi", 85000.0, 'F', sdf.parse("1999-01-01"), hr));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	public static List<Employee> getDetailedEmployeeList() {
		Department hr = new Department(1, "HR");
		Department it = new Department(2, "IT");
		Department finance = new Department(3, "Finance");

		List<Employee> employees = new ArrayList<>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			employees.add(new Employee(101, "Ajay", 50000.0, 'M', sdf.parse("2020-01-10"), it, Arrays.asList(
					new Address("1st Main Street", "Hyderabad"), new Address("2nd Cross Road", "Secunderabad"))));

			employees.add(new Employee(102, "Vamshi", 60000.0, 'M', sdf.parse("2019-03-25"), it,
					Arrays.asList(new Address("5th Avenue", "Bangalore"), new Address("MG Road", "Bangalore"))));

			employees.add(new Employee(103, "Hanvik", 20000.0, 'M', sdf.parse("2025-02-25"), hr,
					Arrays.asList(new Address("Lake View Street", "Chennai"))));

			employees.add(new Employee(104, "Deepika", 70000.0, 'F', sdf.parse("2018-11-05"), finance,
					Arrays.asList(new Address("Park Lane", "Mumbai"))));

			employees.add(new Employee(105, "Sreeja", 65000.0, 'F', sdf.parse("2022-02-15"), finance,
					Arrays.asList(new Address("Hill Road", "Pune"), new Address("FC Road", "Pune"))));

			employees.add(new Employee(105, "Shreshta", 15000.0, 'F', sdf.parse("2025-06-26"), hr,
					Arrays.asList(new Address("Hill Road", "Pune"), new Address("2nd Main Street", "Hyderabad"))));
			
			employees.add(new Employee(107, "Ramesh", 95000.0, 'M', sdf.parse("1995-01-01"), finance,
					Arrays.asList(new Address("Hill Road", "Delhi"), new Address("3rd Main Street", "Hyderabad"))));
			
			employees.add(new Employee(108, "VijayaLaxmi", 85000.0, 'F', sdf.parse("1999-01-01"), hr,
					Arrays.asList(new Address("Hill Road", "Delhi"), new Address("3rd Main Street", "Hyderabad"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	public static List<Department> getDetailedDepartmentList() {
		Department hr = new Department(1, "HR");
		Department it = new Department(2, "IT");
		Department finance = new Department(3, "Finance");

		List<Department> departments = new ArrayList<>();
		try {
			List<Employee> financeEmployees = new ArrayList<>();
			List<Employee> itEmployees = new ArrayList<>();
			List<Employee> hrEmployees = new ArrayList<>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			itEmployees.add(new Employee(101, "Ajay", 50000.0, 'M', sdf.parse("2020-01-10"), it, Arrays.asList(
					new Address("1st Main Street", "Hyderabad"), new Address("2nd Cross Road", "Secunderabad"))));

			itEmployees.add(new Employee(102, "Vamshi", 60000.0, 'M', sdf.parse("2019-03-25"), it,
					Arrays.asList(new Address("5th Avenue", "Bangalore"), new Address("MG Road", "Bangalore"))));

			hrEmployees.add(new Employee(103, "Hanvik", 20000.0, 'M', sdf.parse("2025-02-25"), hr,
					Arrays.asList(new Address("Lake View Street", "Chennai"))));

			financeEmployees.add(new Employee(104, "Deepika", 70000.0, 'F', sdf.parse("2018-11-05"), finance,
					Arrays.asList(new Address("Park Lane", "Mumbai"))));

			financeEmployees.add(new Employee(105, "Sreeja", 65000.0, 'F', sdf.parse("2022-02-15"), finance,
					Arrays.asList(new Address("Hill Road", "Pune"), new Address("FC Road", "Pune"))));
			
			hrEmployees.add(new Employee(105, "Shreshta", 15000.0, 'F', sdf.parse("2025-06-26"), hr,
					Arrays.asList(new Address("Hill Road", "Pune"), new Address("2nd Main Street", "Hyderabad"))));
			
			
			financeEmployees.add(new Employee(107, "Ramesh", 95000.0, 'M', sdf.parse("1995-01-01"), finance,
					Arrays.asList(new Address("Hill Road", "Delhi"), new Address("3rd Main Street", "Hyderabad"))));
			
			hrEmployees.add(new Employee(108, "VijayaLaxmi", 85000.0, 'F', sdf.parse("1999-01-01"), hr,
					Arrays.asList(new Address("Hill Road", "Delhi"), new Address("3rd Main Street", "Hyderabad"))));
			
			finance.setEmployees(financeEmployees);
			it.setEmployees(itEmployees);
			hr.setEmployees(hrEmployees);
			
			departments.add(finance);
			departments.add(it);
			departments.add(hr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departments;
	}

	public static List<Employee> getEmployeeAddresses() {
		List<Employee> employees = null;
		try {
			Address add1 = new Address("1st St", "New York");
			employees = List.of(
					new Employee(101, "Avanthi", 50000.0, 'F', new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-10"),
							List.of(add1, new Address("2nd St", "Boston"))),

					new Employee(102, "Barath", 60000.0, 'M', new SimpleDateFormat("yyyy-MM-dd").parse("2019-03-25"),
							List.of(new Address("Tech Park", "San Francisco"), add1)),

					new Employee(103, "Hanvik", 40000.0, 'M', new SimpleDateFormat("yyyy-MM-dd").parse("2025-02-25"),
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
		employees.add(new EmpDept(103, "Hanvik", 40000.0, 'M', "2025-02-25", "hr"));
		employees.add(new EmpDept(104, "Deepika", 70000.0, 'F', "2018-11-05", "finance"));
		employees.add(new EmpDept(105, "Eve", 65000.0, 'F', "2022-02-15", "it"));
		/*
		 * employees.add(new EmpDept(101, "Avanthi", 50000.0, 'F', "2020-01-10", "hr"));
		 * employees.add(new EmpDept(102, "Arun", 60000.0, 'M', "2019-03-25", "it"));
		 * employees.add(new EmpDept(103, "Anand", 40000.0, 'M', "2021-07-19", "hr"));
		 * employees.add(new EmpDept(104, "Avanthi", 70000.0, 'F', "2018-11-05",
		 * "finance")); employees.add(new EmpDept(105, "Ajay", 65000.0, 'F',
		 * "2022-02-15", "it"));
		 */
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
		System.out.println(jsonString);
		return jsonString;
	}

}
