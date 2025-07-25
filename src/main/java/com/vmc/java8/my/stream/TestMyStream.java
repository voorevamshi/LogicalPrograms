package com.vmc.java8.my.stream;

import java.util.List;

public class TestMyStream {
    public static void main(String[] args) {
        List<String> names = List.of("john", "jane", "max");

        MyStream.of(names)
            .filter(name -> name.startsWith("j"))
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}
