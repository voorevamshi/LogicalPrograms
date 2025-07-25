package com.vmc.java8.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmpDept {

	private Integer id;
	private String name;
	private Double salary;
	private Character gender;
	private String joinDate;
	private String department;

	public EmpDept(Integer id, String name, Double salary, Character gender, String joinDate, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.joinDate = joinDate;
		this.department = department;
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

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {

		String jsonString = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			jsonString = objectMapper.writeValueAsString(this);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonString;

	}

}
