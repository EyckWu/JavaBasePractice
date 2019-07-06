package com.eyckwu.pattern.chainofresponsibility;

public class Response {
    private String handlerResponse;

    public Response() {
    }

    public Response(String handlerResponse) {
        this.handlerResponse = handlerResponse;
    }

    public String getHandlerResponse() {
        return handlerResponse;
    }

    public void setHandlerResponse(String handlerResponse) {
        this.handlerResponse = handlerResponse;
    }

    public void appendHandlerResponse(String handlerResponse){
        this.handlerResponse = this.handlerResponse + handlerResponse;
    }
}
