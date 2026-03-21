package com.vmc.interview.delliot;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeperateAlphbetsAndNumbers {


	public static void main(String[] args) {
		String str = "abc123d2e1f2j8k99";
	
		// Filter the string to only keep digits
        String digits = str.chars()                  // Convert to IntStream
                .filter(Character::isDigit)            // Use the method reference to filter
                .mapToObj(c -> (char) c)               // Convert back to Character (Here int type casted to char first)
                .map(String::valueOf)                  // Convert to String
                .collect(Collectors.joining());        // Join them together
        System.out.println("digits: " + digits);
		 
		 Map<Boolean, List<Character>> partitioned = str.chars() 
	                .mapToObj(c -> (char) c) 
	                .collect(Collectors.partitioningBy(Character::isDigit));

	        // true = digits, false = alphabets (and everything else)
	        List<Character> numbers = partitioned.get(true);
	        List<Character> alphabets = partitioned.get(false);

	        System.out.println("Numbers: " + numbers);
	        System.out.println("Alphabets: " + alphabets);
	        
	        
	        /*List<Integer> list = str.chars().boxed().collect(Collectors.toList());
			System.out.println(list);
			Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(c -> (c > 48 && c < 59)));
			System.out.println(map);
			map.forEach((key, value) -> {
				if (key == true) {
					System.out.println("numbers are" + value.stream().map(num -> num - 48).collect(Collectors.toList()));
				} else {
					System.out.println(
							"alhabets are" + value.stream().map(num -> (char) num.intValue()).collect(Collectors.toList()));
				}
			});
			*/
			// Partition by whether the character is a digit or not
			 
        
/*
         
Key Improvements
Character::isDigit: Instead of checking if the ASCII value is between 48 and 59, 
this built-in method is cleaner and less prone to errors.

mapToObj(c -> (char) c): By converting to a Character object early on,
 you don't have to deal with raw ASCII integers later in the code.

Clarity: Using partitioned.get(true) is generally easier to follow than a forEach loop with an if/else for simple extraction.

*/
		
	}


}
