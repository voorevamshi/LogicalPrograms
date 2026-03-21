package com.vmc.interview.Tmobile;

public class ShortestPathArray {
	public static int findMinJumps(int[] nums) {
		// If array has 1 element, we are already at the end
		if (nums.length <= 1)
			return 0;

		// If the first element is 0, we can't move anywhere
		if (nums[0] == 0)
			return -1;

		int jumps = 0; // Total jumps taken
		int currentEnd = 0; // The farthest index we can reach with 'jumps'
		int farthest = 0; // The farthest index we can reach overall

		for (int i = 0; i < nums.length - 1; i++) {
			// Update the farthest we can reach from the current index
			farthest = Math.max(farthest, i + nums[i]);

			// If we have reached the end of our current jump range
			if (i == currentEnd) {
				jumps++;
				currentEnd = farthest;
				// If we can already reach or pass the last index
				if (currentEnd >= nums.length - 1) {
					break;
				}
			}
		}
		return (currentEnd >= nums.length - 1) ? jumps : -1;
	}

	public static void main(String[] args) {
		int[] array = { 2, 5, 3, 8, 2, 1, 10 };
		int result = findMinJumps(array);

		System.out.println("The minimum steps to reach the last digit: " + result);
	}
}
//https://gemini.google.com/share/d64e29e74d71

/*
Exp1:{ 2, 5, 3, 8, 2, 1, 10 }
Total Jumps: 3
Path: 2 -->5 -->10
 */
/*
Exp2:{ 3, 4, 2, 1, 1, 1, 10 }
Total Jumps: 3
Path: 3 --> 4 --> 1 --> 10
Index (i),Value,Reach (i+value),farthest
0,3,0+3=3,3
1,4,1+4=5,5 (The new winner!)
2,2,2+2=4,5 (Stays 5)
3,1,3+1=4,5 (Stays 5)

*/