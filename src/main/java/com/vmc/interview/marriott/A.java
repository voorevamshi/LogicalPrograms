package com.vmc.interview.marriott;

public interface A {
    default int add(int a, int b){
     int c=   a+b;
     return c;
    }
}
