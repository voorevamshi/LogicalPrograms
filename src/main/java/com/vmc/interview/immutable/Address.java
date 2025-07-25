package com.vmc.interview.immutable;

public final class Address {
	private final String street;
	private final String city;
	private final String postalCode;

	public Address(String street, String city, String postalCode) {
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
	}// getters only

	public String getStreet() {
		return street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", postalCode=" + postalCode + "]";
	}

}