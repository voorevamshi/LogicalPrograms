package com.vmc.interview;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

	String name;
	String department;
	double salary;
	String gender;
	LocalDate joiningDate;

	public Employee(String name, String department, double salary, LocalDate joiningDate, String gender) {
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", salary=" + salary + ", gender=" + gender
				+ ", joiningDate=" + joiningDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, gender, joiningDate, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(department, other.department) && Objects.equals(gender, other.gender)
				&& Objects.equals(joiningDate, other.joiningDate) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	
	

}
