package com.vmc.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
 
public class Sorting implements Logic {

	Integer[] input = { 3, 0, 1, 0, 9, 2 };

	@Override
	public void execute() {
		Integer[] array = Arrays.copyOf(input, input.length);
		int lastIndex = array.length;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[i] == 0 && lastIndex != 0) {
					int temp = array[lastIndex-1];
					array[lastIndex-1] = array[i];
					array[j] = temp;
					lastIndex = lastIndex - 1;
				} else if (array[i] != 0 && array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		Utility.printArray(array);
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

		List<Integer> sortedByAscNumbers = Arrays.asList(input).stream().sorted().collect(Collectors.toList());
		System.out.println("sortedByAscNumbers:" + sortedByAscNumbers);

		Map<Boolean, List<Integer>> sortedByAscNumbersZerosAtLastMap = Arrays.asList(input).stream().sorted()
				.collect(Collectors.partitioningBy(num -> num == 0));
		List<Integer> sortedByAscNumbersZerosAtLast = sortedByAscNumbersZerosAtLastMap.get(false);
		sortedByAscNumbersZerosAtLast.addAll(sortedByAscNumbersZerosAtLastMap.get(true));
		System.out.println("sortedByAscNumbers But zero should be last:" + sortedByAscNumbersZerosAtLast);

		List<Integer> sortedByDescNumbers = Arrays.asList(input).stream().sorted((o1, o2) -> o2.compareTo(o1))
				.collect(Collectors.toList());
		System.out.println("sortedByDescNumbers:" + sortedByDescNumbers);

	}

}
