package com.eyckwu.pattern.proxy;

public class ProxySubject implements AbsSubject {
    private AbsSubject mSubject;

    public void deploy(AbsSubject subject){
        this.mSubject = subject;
    }
    @Override
    public void visit() {
        beforeVisit();
        if (this.mSubject != null){
            this.mSubject.visit();
        }
        afterVisit();
    }

    private void afterVisit() {
        System.out.println("Proxy subject after visit");
    }

    private void beforeVisit() {
        System.out.println("Proxy subject before visit");
    }
}
