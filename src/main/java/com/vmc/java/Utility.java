package com.vmc.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utility {

    public static void printArray(Object array) {
        if (array instanceof int[]) {
            System.out.println("Array: " + Arrays.toString((int[]) array));
        } else if (array instanceof float[]) {
            System.out.println("Array: " + Arrays.toString((float[]) array));
        } else if (array instanceof double[]) {
            System.out.println("Array: " + Arrays.toString((double[]) array));
        } else {
            throw new IllegalArgumentException("Unsupported array type. Only int[], float[], and double[] are allowed.");
        }
    }

    public static <T> void printList(List<T> list) {
        System.out.println("List data: " + list);
    }

    public static <T> void printSet(List<T> set) {
        System.out.println("Set data: " + set);
    }

    public static <T,S> void printMap(Map<T, S> map) {
        System.out.println("Map data: " + map);
    }


}
