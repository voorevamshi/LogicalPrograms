package com.vmc.oom;

public class OutOfMemoryErrorExample {

	public static void main(String[] args) {
		// Try to allocate a very large array that won't fit in the heap
        int[] bigArray = new int[Integer.MAX_VALUE]; 

        // Just printing so that compiler doesn't optimize it away
        System.out.println("Array length: " + bigArray.length);
	}

}
