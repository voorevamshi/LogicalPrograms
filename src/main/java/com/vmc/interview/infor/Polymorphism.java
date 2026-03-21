package com.vmc.interview.infor;

public class Polymorphism {

	public static void main(String[] args) {
		int a = 10;
		Polymorphism polymorphism = new Polymorphism();
		polymorphism.m1(10l);
		polymorphism.m1(10.5f);
		polymorphism.m1('a');
	}

	public void m1(int a) {
		System.out.println("int:" + a);
	}

	public void m1(float a) {
		System.out.println("float");
	}

}
