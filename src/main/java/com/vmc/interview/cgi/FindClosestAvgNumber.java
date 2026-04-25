package com.vmc.interview.cgi;

import java.util.Arrays;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindClosestAvgNumber {
    public static void main(String[] args) {
        int[] arr={10,20,50,7,3};
        double answer=myAnswer(arr);
        int geminicAnswer=geminicAnswer(arr);
        System.out.println("answer:"+geminicAnswer);
    }

    private static int geminicAnswer(int[] arr) {
        double avg = Arrays.stream(arr).average().getAsDouble();

        return Arrays.stream(arr).boxed().min((a,b)-> Double.compare(Math.abs(a-avg),Math.abs(b-avg))).orElse(arr[0]);
    }

    private static double myAnswer(int[] arr) {
        double avg = (Double) Arrays.stream(arr).boxed().collect(Collectors.averagingInt((a)->a));
        double closest=Math.abs(arr[0]-avg);
        System.out.println(avg);
        for (int i=0;i<arr.length;i++){
            double absValue=Math.abs(arr[i]-avg);
            if(closest>absValue){
                closest=absValue;
            }
        }
        System.out.println("closest:"+closest);
        return closest;
    }
}
