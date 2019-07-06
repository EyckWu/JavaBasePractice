package com.eyckwu.pattern.chainofresponsibility;

public class ConcreteHandler1 extends Handler {
    @Override
    protected Level getHandlerLevel() {
        return new Level(ConcreteHandler1.class.getSimpleName());
    }

    @Override
    protected Response echo(Request request) {
        Response response = new Response(ConcreteHandler1.class.getSimpleName());
        return response;
    }
}
