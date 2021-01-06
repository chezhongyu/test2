package com.foreknow.test;

public class CImpl implements C {

    @Override
    public void method_C() {
        System.out.println("ccccccc");
    }

    @Override
    public void method_A() {
        System.out.println("aaaaaa");

    }

    @Override
    public void method_B() {
        System.out.println("bbbbbbb");

    }

    public static void main(String[] args) {
        C c = new CImpl();
        c.method_C();
        c.method_A();
        c.method_B();

    }
}
