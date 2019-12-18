package com.controller;

import com.service.impl.StuA;
import other.Student;

public class Stutest2 implements Student {
    public static void main(String[] args) {
        StuA stuA=new StuA();
        stuA.a=12;
        StuA stuA1=new StuA();
        stuA1.a=12;
        stuA.method1();
        Stutest2 stutest2=new Stutest2();
        stutest2.method3();
        System.out.println(stuA.equals(stuA1));
        System.out.println(stutest2.show(-4));
    }
    int show(int num){
        int x=0;
        try {
            if (num < 0) {
                throw new RuntimeException("参数错误！！");
            }
            x=4;
            return x;
        }
        catch(RuntimeException Ex) {
            System.out.println(Ex.toString());
            x=400;
            return x;
        }
        finally{
            x=100;
            return x;
        }
    }

    @Override
    public void method1() {

    }
}
