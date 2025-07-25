package com.vmc.interview.immutable;

public final class Employee {
	private final int empId;
	private final String empName;
	// private final List<String> skills;
	private final Address address;

	public Employee(int empId, String empName, Address address) {
		
		this.empId = empId;
		this.empName = empName;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + address + "]";
	}
	

}