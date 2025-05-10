package com.vmc.java8;

import java.util.Date;
import java.util.List;

public class Employee implements  Comparable {
	private Integer id;
	private String name;
	private Double salary;
	private Character gender;
	private Date joinDate;
	private Department department;
	private List<Skill> skills;
	
	public Employee(Integer id, String name, Double salary, Character gender, Date joinDate) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.joinDate = joinDate;
	}
/*	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", gender=" + gender + ", joinDate="
				+ joinDate + ", department=" + department + ", skills=" + skills + "]";
	}*/

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", salary=" + salary +
				", gender=" + gender +
				", joinDate=" + joinDate +
				'}';
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Character getGender() {
		return gender;
	}
	public void setGender(Character gender) {
		this.gender = gender;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public List<Skill> getSkills() {
		return skills;
	}
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}


	@Override
	public int compareTo(Object o) {
	    if (o == null || !(o instanceof Employee)) {
	        throw new IllegalArgumentException("Invalid object for comparison");
	    }
	    Employee other = (Employee) o;
	    if (this.name == null && other.name == null) {
	        return 0; // Both names are null, considered equal
	    }
	    if (this.name == null) {
	        return -1; // Null names are considered smaller
	    }
	    if (other.name == null) {
	        return 1; // Non-null names are considered larger
	    }
	    return this.name.compareTo(other.name); // Compare names lexicographically
	}
}
