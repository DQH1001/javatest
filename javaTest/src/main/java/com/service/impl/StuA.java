package com.service.impl;

import com.service.Student;

public class StuA implements Student {
    public int a;
    public void method1() {
        System.out.println("m1");
    }
    protected void method2() {
        System.out.println("protected-m2");
    }

    public static void main(String[] args) {
        StuA stuA=new StuA();
        stuA.method3();
    }

    @Override
    public boolean equals(Object obj) {
        return this==(StuA)obj;
    }
}
