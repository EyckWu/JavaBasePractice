package com.eyckwu.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
    private Object object;

    public DynamicProxy(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeInvoke();
        Object result = method.invoke(object, args);
        afterInvoke();
        return result;
    }

    private void afterInvoke() {
        System.out.println("Proxy subject after invoke");
    }

    private void beforeInvoke() {
        System.out.println("Proxy subject before invoke");
    }
}
