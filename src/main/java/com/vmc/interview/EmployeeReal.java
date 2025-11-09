package com.interview;

import java.time.LocalDate;
import java.util.List;

public class EmployeeReal {

	String name;
	String department;
	double salary;
	String gender;
	LocalDate joiningDate;
	List<Address> address;

	public EmployeeReal(String name, String department, double salary, LocalDate joiningDate, String gender,
			List<Address> address) {
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.gender = gender;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "EmployeeReal [name=" + name + ", department=" + department + ", salary=" + salary + ", gender=" + gender
				+ ", joiningDate=" + joiningDate + ", address=" + address + "]";
	}

}
