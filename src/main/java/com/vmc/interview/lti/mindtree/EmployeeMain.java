package com.interview.lti.mindtree;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {

	public static void main(String[] args) {
		Skill skill1 = new Skill(1, "java");
		Skill skill2 = new Skill(2, "Phyton");
		Skill skill3 = new Skill(3, ".Net");
		List<Skill> skills = new ArrayList<>();
		skills.add(skill1);
		skills.add(skill2);
		skills.add(skill3);
		AddressRecoard address = new AddressRecoard("hyd", "TG", "India");
		EmployeeRecord eRecord = new EmployeeRecord(10, "vamshi", 5000, "Software", 10, skills, address);
		System.out.println(eRecord);
		Skill skill4 = new Skill(4, "React");
		skills.add(skill4);
		System.out.println(eRecord);

	}

}
