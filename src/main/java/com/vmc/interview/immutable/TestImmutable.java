package com.vmc.interview.immutable;

import java.util.ArrayList;
import java.util.List;

public class TestImmutable {

	public static void main(String[] args) {
		Address add=new Address("street","city","pinCode");
		Employee emp=new Employee(10,"vamshi",add);
		add=new Address("street1","city1","pinCode1");
		//System.out.println(emp);
		Address add2=new Address("street2","city2","pinCode2");
		List<Address> list=new ArrayList<>();
		list.add(add);
		list.add(add2);
		EmployeeListOfAddress eloa=new EmployeeListOfAddress(10,"name",list);
		System.out.println(eloa.getAddresses());
		Address add3=new Address("street3","city3","pinCode3");
		list.add(add3);
		System.out.println(eloa.getAddresses());
		Address add4=new Address("street4","city4","pinCode4");
		eloa.getAddresses().add(add4);
		System.out.println(eloa.getAddresses());
	}

}
