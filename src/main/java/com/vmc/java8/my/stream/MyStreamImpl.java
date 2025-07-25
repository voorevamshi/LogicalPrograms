package com.vmc.java8.my.stream;

import java.util.*;
import java.util.function.*;

public class MyStreamImpl<T> implements MyStream<T> {
    private final List<T> data;

    public MyStreamImpl(List<T> data) {
        this.data = data;
    }

    public static <T> MyStream<T> of(List<T> data) {
        return new MyStreamImpl<>(data);
    }

    @Override
    public <R> MyStream<R> map(Function<T, R> mapper) {
        List<R> mapped = new ArrayList<>();
        for (T item : data) {
            mapped.add(mapper.apply(item));
        }
        return new MyStreamImpl<>(mapped);
    }

    @Override
    public MyStream<T> filter(Predicate<T> predicate) {
        List<T> filtered = new ArrayList<>();
        for (T item : data) {
            if (predicate.test(item)) {
                filtered.add(item);
            }
        }
        return new MyStreamImpl<>(filtered);
    }

    @Override
    public void forEach(Consumer<T> action) {
        for (T item : data) {
            action.accept(item);
        }
    }

    @Override
    public List<T> toList() {
        return data;
    }
}

