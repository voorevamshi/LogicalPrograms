package com.vmc.interview.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors; 

public final class EmployeeListOfAddress {
	private final int empId;
	private final String empName;
	private final List<Address> addresses;
	

	public EmployeeListOfAddress(int empId, String empName, List<Address> addresses) {
		
		this.empId = empId;
		this.empName = empName;
/*
		List<Address> addressesList = new ArrayList<>();
		for (Address address : addresses) {
			addressesList.add(address);
		}
		this.addresses = addressesList; 
		*/
		//this.addresses = addresses; // Make a defensive copy
		List<Address> deepCopy = addresses.stream()
			    .map(addr -> new Address(addr.getStreet(), addr.getCity(), addr.getPostalCode()))
			    .collect(Collectors.toList());
		this.addresses = deepCopy;

	}
	
	
	public int getEmpId() {
		return empId;
	}


	public String getEmpName() {
		return empName;
	}


	public List<Address> getAddresses() {
		  return Collections.unmodifiableList(addresses);
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", address=" + addresses + "]";
	}
	

}