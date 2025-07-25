package com.vmc.java;
import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateNumbers {

	public static void main(String[] args) {
		 BigInteger number = new BigInteger("9173324252313957200");
		 Set<Integer> uniqueDigits = new LinkedHashSet<>();

	        // Loop until the number becomes 0
	        while (number.compareTo(BigInteger.ZERO) > 0) {
	            // Get last digit
	            BigInteger[] divAndRem = number.divideAndRemainder(BigInteger.TEN);
	            int digit = divAndRem[1].intValue();

	            // Add digit to set (automatically removes duplicates)
	            uniqueDigits.add(digit);

	            // Move to next digit
	            number = divAndRem[0];
	            System.out.println(number);
	        }

	        // Print digits in the order they appeared (LinkedHashSet maintains order)
	        for (int digit : uniqueDigits) {
	            System.out.print(digit);
	        }
		

		

	}

}
