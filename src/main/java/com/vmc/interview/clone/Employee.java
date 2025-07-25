package com.vmc.interview.clone;

public class Employee implements Cloneable {
    private String name;
    private Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

	public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    // Setter methods to modify name and address
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Override clone method to support deep cloning
    @Override
    public Object clone() {
        try {
            Employee cloned = (Employee) super.clone();
            // Perform deep cloning for the Address object
            cloned.address = (Address) address.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

	@Override
	public String toString() {
		return "Employee [name=" + name + ", address=" + address + "]";
	}
    
}
