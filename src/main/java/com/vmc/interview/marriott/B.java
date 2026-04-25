package com.vmc.interview.marriott;

public interface B {
    default int add(int a, int b){
        int c=   a-b;
        return c;
    }
}
