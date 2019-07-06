package com.eyckwu.pattern.chainofresponsibility;

public class ConcreteHandler3 extends Handler {
    @Override
    protected Level getHandlerLevel() {
        return new Level(ConcreteHandler3.class.getSimpleName());
    }

    @Override
    protected Response echo(Request request) {
        Response response = new Response(ConcreteHandler3.class.getSimpleName());
        return response;
    }
}
