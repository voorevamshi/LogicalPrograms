package com.vmc.interview.mphasis;

import java.util.function.Function;
import java.util.stream.Collectors;

public class SpecialCharacterCount {
		
	public static void main(String[] args) {
		String str="Mphasis@Limited";
		System.out.println( str.chars().filter(ele->!Character.isAlphabetic(ele)).mapToObj(ele->(char)ele).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

	}
}
