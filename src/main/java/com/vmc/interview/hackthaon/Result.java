package com.interview.hackthaon;

class Result {

	/*
	 * Complete the 'fizzBuzz' function below.
	 *
	 * The function accepts INTEGER n as parameter.
	 */

	public static void fizzBuzz(int n) {
		// Write your code here
		
		for (int i = 1; i < n; i++) {
			boolean matchCondition = false;
			if (i % 3 == 0 && i % 5 == 0) {
				matchCondition = true;
				System.out.println("FizzBizz");
			}
			if (i % 3 == 0 && !matchCondition) {
				matchCondition = true;
				System.out.println("Fizz");
			}
			if (i % 5 == 0 && !matchCondition) {
				matchCondition = true;
				System.out.println("Bizz");
			}
			
			if (!matchCondition) {
				System.out.println(i);
			}

		}
	}

}
