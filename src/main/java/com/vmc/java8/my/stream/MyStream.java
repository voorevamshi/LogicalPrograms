package com.vmc.java8.my.stream;

import java.util.function.*;
import java.util.*;

public interface MyStream<T> {

	static <T> MyStream<T> of(List<T> data) {
        return new MyStreamImpl<>(data);
    }
	
    <R> MyStream<R> map(Function<T, R> mapper);

    MyStream<T> filter(Predicate<T> predicate);

    void forEach(Consumer<T> action);

    List<T> toList(); // to access the result
}
