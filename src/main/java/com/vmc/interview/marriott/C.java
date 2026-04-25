package com.vmc.interview.marriott;

public class C implements A,B{
    public static void main(String[] args) {
        C c=new C();
        System.out.println(c.add(10,20));
    }

    @Override
    public int add(int a, int b) {
        return B.super.add(a, b);
    }
}
