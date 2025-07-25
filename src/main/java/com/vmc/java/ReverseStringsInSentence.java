package com.vmc.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseStringsInSentence implements Logic {

	String given = "Hi How are you";

	@Override
	public void execute() {

		String[] givenArray = given.split(" ");
		String[] outputArray = new String[givenArray.length];
		List<String> list = new ArrayList<>();
		String output = "";
		int index = 0;
		for (String input : givenArray) {
			output = output + new StringBuffer(input).reverse().toString() + " ";
			list.add(new StringBuffer(input).reverse().toString());
			outputArray[index++] = new StringBuffer(input).reverse().toString();
		}
		output = output.substring(0, output.length() - 1);
		System.out.println("executeWithSoultion1:"+output + "<---");
		System.out.println("executeWithSoultion1:"+String.join(" ", list) + "<---");
		System.out.println("executeWithSoultion1:"+String.join(" ", outputArray) + "<---");
	}

	@Override
	public void executeWithSoultion2() {

	}

	@Override
	public void executeWithSoultion3() {

	}

	@Override
	public void executeUsingJava8() {
		String outputString = Arrays.stream(given.split(" ")).map(str -> new StringBuffer(str).reverse().toString())
				.collect(Collectors.joining(" "));
		System.out.println("executeUsingJava8:" + outputString + "<---");

	}

	public static void main(String[] args) {

	}

}
