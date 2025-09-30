package com.vmc.oom;

import java.util.ArrayList;
import java.util.List;

public class OOMListExample {

	public static void main(String[] args) {
		List<int[]> list = new ArrayList<>();
        while (true) {
            // Allocate 1 MB chunks repeatedly
            list.add(new int[1]); // 1 MB
           System.out.println(list.size());
        }
	}

}
