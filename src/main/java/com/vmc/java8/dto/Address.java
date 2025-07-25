package com.vmc.java8.dto;

public class Address {
	
	private String street;
	private String cityName;

	public Address(String street, String cityName) {
		this.street = street;
		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStreet() {
		return street;
	}
}
