package com.vmc.interview.lti.mindtree;

import java.util.function.BinaryOperator;

public class SumMain {

	public static void main(String[] args) {
		SumInterface<Integer> value = (a, b) -> a + b;
		System.out.println("The result of merging 10 and 20 is: "+value.sum(10, 20));

		SumInterface<Double> doubleValue = (a, b) -> a + b;
		System.out.println("The result of merging 10.5 and 20.5 is: "+doubleValue.sum(10.5d, 20.5d));

		// Define a BinaryOperator to add two integers
		BinaryOperator<Integer> add = (a, b) -> a + b;

		// Apply the operator to two integers
		int result = add.apply(10, 20);

		// Print the result
		System.out.println("The result of merging 10 and 20 is: " + result); // Output: 30

	}

}
