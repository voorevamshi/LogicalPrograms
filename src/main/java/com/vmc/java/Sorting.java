package com.vmc.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting implements Logic {

	@Override
	public void execute() {
		// TODO Auto-generated method stub

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

		Integer[] array = { 3, 0, 1, 2 };
		List<Integer> sortedByAscNumbers = Arrays.asList(array).stream().sorted().collect(Collectors.toList());
		System.out.println("sortedByAscNumbers:"+sortedByAscNumbers);
		Integer[] arr = { 3, 0, 1, 2 };
		List<Integer> sortedByDescNumbers = Arrays.asList(arr).stream().sorted((o1, o2) -> o2.compareTo(o1))
				.collect(Collectors.toList());
		System.out.println("sortedByDescNumbers:"+sortedByDescNumbers);

	}

}
