package com.vmc.interview.clone;

public class TestClone {

	public static void main(String[] args) {
		Employee original = new Employee("John Doe", new Address("123 Main St", "Springfield", "12345"));
		System.out.println("original"+original);
		Employee cloned = (Employee) original.clone();
		System.out.println("cloned"+cloned);
	}

}
