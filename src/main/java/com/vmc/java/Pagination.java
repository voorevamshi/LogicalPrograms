package com.vmc.java;

import java.util.ArrayList;
import java.util.List;

public class Pagination implements Logic {

	private List<String> itemList;

	@Override
	public void execute() {
		itemList = new ArrayList<>();
		for (int i = 1; i <= 1000; i++) {
			itemList.add("Item " + i);
		}

		int pageNo = 2;
		int pageSize = 50;

		List<String> currentPage = getPage(pageNo, pageSize);

		System.out.println("Page " + pageNo + ":");
		for (String item : currentPage) {
			System.out.print(item+",");
		}
		
		 pageNo = 3;
		 pageSize = 50;

		 currentPage = getPage(pageNo, pageSize);

		System.out.println("Page " + pageNo + ":");
		for (String item : currentPage) {
			System.out.print(item+",");
		}
	}

	public List<String> getPage(int pageNo, int pageSize) {
		int startIndex = (pageNo - 1) * pageSize;
		int endIndex = Math.min(startIndex + pageSize, itemList.size());

		if (startIndex < itemList.size()) {
			return itemList.subList(startIndex, endIndex);
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public void executeWithSoultion2() {

	}

	@Override
	public void executeWithSoultion3() {

	}

	@Override
	public void executeUsingJava8() {

	}

}
