package com.vmc.interview;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeUtility {

	public static List<Employee> getEmployees() {
		List<Employee> employees = Arrays.asList(new Employee("John", "HR", 65000.0, LocalDate.of(2009, 5, 15), "M"),
				new Employee("Alice", "IT", 70000.0, LocalDate.of(2012, 8, 22), "F"),
				new Employee("Bob", "HR", 60000.0, LocalDate.of(2008, 3, 10), "M"),
				new Employee("Charlie", "IT", 75000.0, LocalDate.of(2010, 12, 5), "F"),
				new Employee("David", "Finance", 58000.0, LocalDate.of(2007, 6, 30), "M"),
				new Employee("Vamshi", "IT", 75000.0, LocalDate.of(2010, 12, 5), "M"),
				new Employee("Eva", "Finance", 62000.0, LocalDate.of(2011, 9, 18), "F"));
		
		return employees;
	}

	public static List<Employee> getEmployees1() {
		List<Employee> employees = Arrays.asList(new Employee("Harika", "HR", 65000.0, LocalDate.of(2009, 5, 15), "F"),
				new Employee("Ajay", "IT", 70000.0, LocalDate.of(2012, 8, 22), "M"),
				new Employee("Deepika", "HR", 60000.0, LocalDate.of(2008, 3, 10), "F"),
				new Employee("Vamshi", "IT", 75000.0, LocalDate.of(2010, 12, 5), "M"),
				new Employee("Ramesh", "Finance", 58000.0, LocalDate.of(2007, 6, 30), "M"),
				new Employee("Susheela", "HR", 65000.0, LocalDate.of(2009, 5, 15), "F"),
				new Employee("Vijaya", "Finance", 62000.0, LocalDate.of(2011, 9, 18), "F"));
		return employees;
	}
	
	public static List<EmployeeReal> getRealEmployees() {
		List<Address> tgHydAdd = new ArrayList<>();
		tgHydAdd.add(new Address("Hyderabad", "Telangana", "India"));
		List<Address> tgNlgAdd = new ArrayList<>();
		tgNlgAdd.add(new Address("Nalgonda", "Telangana", "India"));
		List<Address> keralaAdd = new ArrayList<>();
		keralaAdd.add(new Address("Munnar", "Kerala", "India"));
		List<Address> karnatakaAdd = new ArrayList<>();
		karnatakaAdd.add(new Address("Bangalore", "Karnataka", "India"));
		List<Address> maharashtraAdd = new ArrayList<>();
		maharashtraAdd.add(new Address("Pune", "Maharashtra", "India"));
		List<EmployeeReal> employees = Arrays.asList(
				new EmployeeReal("Harika", "HR", 65000.0, LocalDate.of(2009, 5, 15), "F", tgHydAdd),
				new EmployeeReal("Ajay", "IT", 70000.0, LocalDate.of(2012, 8, 22), "M", keralaAdd),
				new EmployeeReal("Deepika", "HR", 60000.0, LocalDate.of(2008, 3, 10), "F", tgHydAdd),
				new EmployeeReal("Vamshi", "IT", 75000.0, LocalDate.of(2010, 12, 5), "M", karnatakaAdd),
				new EmployeeReal("Ramesh", "Finance", 58000.0, LocalDate.of(2007, 6, 30), "M", tgNlgAdd),
				new EmployeeReal("Susheela", "Finance", 5800.0, LocalDate.of(2007, 6, 30), "F", tgHydAdd),
				new EmployeeReal("Vijaya", "Finance", 62000.0, LocalDate.of(2011, 9, 18), "F", tgNlgAdd),
				new EmployeeReal("Harish", "IT", 92000.0, LocalDate.of(2011, 9, 18), "M", maharashtraAdd));
		return employees;
	}

}
