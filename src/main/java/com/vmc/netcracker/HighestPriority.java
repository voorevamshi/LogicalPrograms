package com.vmc.netcracker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HighestPriority {

	public static void main(String[] args) {
		List<Error> errorsConfiguration  = Arrays.asList(
                new Error("E-1334", 4),
                new Error("E-7264", 2),
                new Error("E-7264", 2),
                new Error("E-2234", 1),
                new Error("E-9134", 3),
                new Error("E-7834", 5));
		List<String> errorsFromServer = Arrays.asList("E-7834", "E-7264", "S-3364");  
		getHighestPriority(errorsConfiguration,errorsFromServer);
	}

	private static void getHighestPriority(List<Error> errorsConfiguration, List<String> errorsFromServer) {
		List<Error> sordedListByPrority= errorsConfiguration.stream().sorted(Comparator.comparing(Error::getPriority)).collect(Collectors.toList());
		System.out.println("sordedListByPrority:"+sordedListByPrority);
		Map<String, Integer> errorMap =errorsConfiguration.stream().collect(Collectors.toMap(Error::getCode,Error::getPriority,(key,value)->value));
		System.out.println("errorMap:"+errorMap);
		Map<Integer,Set<Error>> groupByPriority =errorsConfiguration.stream().collect(Collectors.groupingBy(Error::getPriority,Collectors.toSet()));
		System.out.println("groupByPriority:"+groupByPriority);
		
		Integer highestPriority=errorsFromServer.stream().map(errorCode->errorMap.get(errorCode)).filter(priorty->priorty!=null).sorted().findFirst().get();
		System.out.println("highestPriority:"+highestPriority);
		System.out.println(groupByPriority.get(highestPriority));
		
		
	}

}
