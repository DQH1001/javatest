package com.service;

public interface Student {
    public void method1();
    default void method3() {
        System.out.println("default-m3");
    }
}
