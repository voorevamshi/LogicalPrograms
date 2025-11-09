package com.vmc.interview.lti.mindtree;

public class SuperClass{
	private String superData;

	public SuperClass(String superData) {
		this.superData = superData;
	}

	public String getSuperData() {
		return superData;
	}

	
	public void setSuperData(String superData) {
		this.superData = superData;
	}

	// Default constructor (needed for deserialization)
	public SuperClass() {
		this.superData = "DefaultSuperData";
	}


}
