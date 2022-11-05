package com.studentTest.bean;

public class Major {
    private String a;
    private String b;

    public Major(){}
    public Major(String a, String b) {
        this.a = a;
        this.b = b;

    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Major{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }
}
