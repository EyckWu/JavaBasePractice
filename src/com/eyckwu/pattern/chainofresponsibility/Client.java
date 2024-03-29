package com.eyckwu.pattern.chainofresponsibility;

public class Client {
    public static void main(String[] args){
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        Response response = handler1.handleMessage(new Request(new Level(ConcreteHandler3.class.getSimpleName())));
        System.out.println("response = " + response);
    }
}
