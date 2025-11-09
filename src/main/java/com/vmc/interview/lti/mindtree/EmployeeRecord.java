package com.vmc.interview.lti.mindtree;

import java.util.List;

public record EmployeeRecord(int empId, String empName, double salary, String designation, int deptId,
		List<Skill> skills, AddressRecoard add) {

	public EmployeeRecord {
		// Defensive copy to ensure immutability
		skills = List.copyOf(skills);
	}
}