package com.vmc.interview.mphsis;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UniqueNumbers {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 3, 2, 5, 6, 7, 4, 7, 4, 8);
		Map<Integer, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.entrySet().stream().filter(entry -> entry.getValue() == 1l)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue)).forEach((k, v) -> System.out.println(k));

		// Approach 1 Zeros move to right side
		List<Integer> inputList = Arrays.asList(1, 2, 0, 3, 0, 4, 0, 5);

		int zeroCount = inputList.stream().filter(value -> value == 0).toList().size();

		List<Integer> finalList = inputList.stream().filter(value -> value != 0).collect(Collectors.toList());

		//IntStream.range(0, zeroCount).forEach(value -> finalList.add(0));
		// System.out.println(finalList);
		
		// Approach 2 Zeros move to right side
		finalList=inputList.stream().sorted(Comparator.comparing(input->input==0?1:0)).collect(Collectors.toList());
		System.out.println(finalList);
	}

}
