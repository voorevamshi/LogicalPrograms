package com.sreeja.java;

public class Calculator {

	public static void main(String[] args) {
		int a = 10, b = 20;
		int c = add(a, b);
		System.out.println("Output:" + c);
	}

	private static int add(int a, int b) {

		return a + b;
	}

}
