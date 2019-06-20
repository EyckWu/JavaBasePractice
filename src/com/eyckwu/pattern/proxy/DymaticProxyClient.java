package com.eyckwu.pattern.proxy;

import java.lang.reflect.Proxy;

public class DymaticProxyClient {
    public static void main(String[] args){
        AbsSubject realSubject = new RealSubject();
        DynamicProxy dynamicProxy = new DynamicProxy(realSubject);
        AbsSubject proxySubject = (AbsSubject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), new Class[]{AbsSubject.class}, dynamicProxy);
        proxySubject.visit();
    }
}
