package com.vmc.interview.netcracker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HighestPriority {

	public static void main(String[] args) {
		List<Error> errorsConfiguration  = Arrays.asList(
                new Error("E-1334", 4),
                new Error("E-7264", 2),
                new Error("E-7264", 2),
                new Error("E-2234", 1),
                new Error("E-9134", 2),
                new Error("E-7834", 5));
		List<String> errorsFromServer = Arrays.asList("E-7834", "E-7264", "E-9134");  
		getHighestPriority(errorsConfiguration,errorsFromServer);
	}

	private static void getHighestPriority(List<Error> errorsConfiguration, List<String> errorsFromServer) {	
		/*List<Error> sordedListByPrority= errorsConfiguration.stream().sorted(Comparator.comparing(Error::getPriority)).collect(Collectors.toList());
		System.out.println("sordedListByPrority:"+sordedListByPrority);
		Map<String, Integer> errorMap =errorsConfiguration.stream().collect(Collectors.toMap(Error::getCode,Error::getPriority,(key,value)->value));
		System.out.println("errorMap:"+errorMap);
		Map<Integer,Set<Error>> groupByPriority =errorsConfiguration.stream().collect(Collectors.groupingBy(Error::getPriority,Collectors.toSet()));
		System.out.println("groupByPriority:"+groupByPriority);
		
		Integer highestPriority=errorsFromServer.stream().map(errorCode->errorMap.get(errorCode)).filter(priorty->priorty!=null).sorted().findFirst().get();
		System.out.println("highestPriority:"+highestPriority);
		System.out.println(groupByPriority.get(highestPriority));
		*/	
		/* Worst approch
		Map<String, Integer> map = errorsConfiguration.stream().sorted(Comparator.comparing(Error::getPriority))
				.collect(Collectors.toMap(Error::getCode, Error::getPriority, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(map);

		Entry<String, Integer> entryData = map.entrySet().stream()
				.filter(entry -> errorsFromServer.contains(entry.getKey())).findFirst().get();
		
		Map<String, Integer> resultMap = map.entrySet().stream()
				.filter(entry -> errorsFromServer.contains(entry.getKey()) && entryData.getValue() == entry.getValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue));

		System.out.println(resultMap);*/
		/* Fine Approach  */
		Map<String, Error> errorLookup = errorsConfiguration.stream()
				.collect(Collectors.toMap(Error::getCode, e -> e, (e1, e2) -> e2));
		List<Error> filteredErrors = errorsFromServer.stream().map(errorLookup::get).filter(Objects::nonNull)
				.sorted(Comparator.comparing(Error::getPriority)).collect(Collectors.toList());
		filteredErrors.stream().filter(entry->filteredErrors.getFirst().getPriority().equals(entry.getPriority())).forEach(System.out::println);
	}

}
