package com.vmc.interview.mphsis;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlternateCharacterExtractor {

	public static void main(String[] args) {
		String name = "vamshi";
		String output = getAlternateCharacters(name);
		System.out.println(output); // vmh
	}

	public static String getAlternateCharacters(String name) {
		return IntStream.range(0, name.length()).filter(i -> i % 2 == 0).map(name::charAt)
				.mapToObj(ch -> String.valueOf((char) ch)).collect(Collectors.joining());
	}


}
