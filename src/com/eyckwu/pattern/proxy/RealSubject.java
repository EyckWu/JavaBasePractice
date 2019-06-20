package com.eyckwu.pattern.proxy;

public class RealSubject implements AbsSubject {
    @Override
    public void visit() {
        System.out.println("Real subject!");
    }
}
