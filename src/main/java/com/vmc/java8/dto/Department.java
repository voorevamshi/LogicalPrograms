package com.vmc.java8.dto;

public class Department {

	private Integer deptId;
	private String deptName;

	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}

	public Department(Integer deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return " [deptName=" + deptName + "]";
	}

}
