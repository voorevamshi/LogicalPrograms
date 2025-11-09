package com.interview.deloitte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.interview.Logic;

public class RemoveAnElement implements Logic {

	@Override
	public void execute() {
		Integer[] arr = { 1, 2, 2, 3, 2, 3 };
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
		List<Integer> removeList =new ArrayList<>();
		removeList.add(2);
		list.removeAll(removeList);
		System.out.println(list);
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
		// TODO Auto-generated method stub

	}

}
