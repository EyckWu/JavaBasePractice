package com.eyckwu.pattern.chainofresponsibility;

public class ConcreteHandler2 extends Handler {
    @Override
    protected Level getHandlerLevel() {
        return new Level(ConcreteHandler2.class.getSimpleName());
    }

    @Override
    protected Response echo(Request request) {
        Response response = new Response(ConcreteHandler2.class.getSimpleName());
        return response;
    }
}
