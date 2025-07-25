package com.vmc.java8.my.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

public class MyCollectors {

	public static <T, K> Map<K, List<T>> groupingBy(List<T> list, Function<T, K> classifier) {
		Map<K, List<T>> result = new HashMap<>();
		for (T item : list) {
			K key = classifier.apply(item);
			result.computeIfAbsent(key, k -> new ArrayList<>()).add(item);
		}
		return result;
	}

	public static <T> double averaging(List<T> list, ToDoubleFunction<T> mapper) {
		return list.stream().mapToDouble(mapper).average().orElse(0.0);
	}

	public static <T> Optional<T> maxBy(List<T> list, Comparator<T> comparator) {
		return list.stream().max(comparator);
	}
	
	public static <T, K> Map<K, Long> countingBy(List<T> list, Function<T, K> classifier) {
        Map<K, Long> result = new HashMap<>();
        for (T item : list) {
            K key = classifier.apply(item);
            result.put(key, result.getOrDefault(key, 0L) + 1);
        }
        return result;
    }
}
