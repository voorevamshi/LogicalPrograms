package com.vmc.java;

public class NonRepeatedNumbers implements Logic {

	@Override
	public void execute() {
		int[] array= {1,2,3,4,2,1,4,5,5,6};
		for (int i = 0; i < array.length; i++) {
			int count =0;
			for (int j = 0; j < array.length; j++) {
				if(array[i]==array[j]) {
					count++;
				}
			}
			if(count==1) {
				System.out.println(array[i]);
			}
		}
	}

	@Override
	public void executeWithSoultion2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeWithSoultion3() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeUsingJava8() {
		// TODO Auto-generated method stub

	}

}
