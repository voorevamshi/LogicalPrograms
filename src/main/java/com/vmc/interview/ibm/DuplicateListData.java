package com.vmc.interview.ibm;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateListData {

	public static void main(String[] args) {
		Integer[] array = { 1, 3, 4, 5, 6, 1, 2, 1, 5 };
		List<Integer> list = Arrays.asList(array);

	/*	HashMap<Integer, Integer> hm = new HashMap<>();
		list.stream().forEach(value -> {
			int count = 1;
			if (null != hm.get(value)) {
				hm.put(value, hm.get(value) + 1);
			} else {
				hm.put(value, count);
			}
		});*/
		Map<Integer, Long> hm =list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(hm);
		List<Integer> duplicateNbrs = hm.entrySet().stream().filter(key -> hm.get(key.getKey()) > 1)
				.map(key -> key.getKey()).collect(Collectors.toList());
		System.out.println("Duplicate numbers are: "+duplicateNbrs);
		List<Integer> uniqueNbrs = hm.entrySet().stream().filter(key -> hm.get(key.getKey()) == 1)
				.map(key -> key.getKey()).collect(Collectors.toList());
		System.out.println("Unique numbers are: "+uniqueNbrs);
	}

}
