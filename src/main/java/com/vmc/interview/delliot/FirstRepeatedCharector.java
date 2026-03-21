package com.vmc.interview.delliot;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstRepeatedCharector {

	public static void main(String[] args) {
		String str = "vamshiamsh";
		findFirstRepeated(str);
/*
		Map<Character, Integer> map2 = new LinkedHashMap<>();
		for (char ch : str.toCharArray()) {
			map2.compute(Character.valueOf(ch), (k, v) -> v == null ? 1 : v + 1);
		}
		for (Entry<Character, Integer> entry : map2.entrySet()) {
			if (entry.getValue() != 1) {
				System.out.print("key:" + entry.getKey() + "and value:" + entry.getValue());
				break;
			}
		}
	
	*/
	}
		public static void findFirstRepeated(String str) {
		    int[] count = new int[256]; // Or 65536 for full Unicode

		    // First pass: Count everything
		    for (char ch : str.toCharArray()) {
		        count[ch]++;
		    }
		    List<Integer> list = Arrays.stream(count)
                    .boxed() 
                    .collect(Collectors.toList());
		    System.out.println(list);
		    // Second pass: Find first repeated based on original string order
		    for (char ch : str.toCharArray()) {
		        if (count[ch] > 1) {
		            System.out.println("Key: " + ch + " Value: " + count[ch]);
		            return; 
		        }
		    }
		
	}
}
