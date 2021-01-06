package com.foreknow.test;

public class test333 {
    public void method(String sql,Object...values){
        System.out.println(sql);
    }

    public static void main(String[] args) {
        test333 a = new test333();
        a.method("select * from ?","admin");

    }

}
