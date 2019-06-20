package com.eyckwu.pattern.proxy;

public class StaticProxyClient {

    public static void main(String[] args){
        AbsSubject realSubject = new RealSubject();
        ProxySubject proxySubject = new ProxySubject();
        proxySubject.deploy(realSubject);
        proxySubject.visit();
    }

}
