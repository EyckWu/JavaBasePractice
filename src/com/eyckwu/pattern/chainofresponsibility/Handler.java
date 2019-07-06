package com.eyckwu.pattern.chainofresponsibility;

public abstract class Handler {
    private Handler nextHandler;
    public final Response handleMessage(Request request){
        Response response = null;
        System.out.println("handler level = " + this.getHandlerLevel().getHandlerLevel() + "; request level = " + request.getRequestLevel().getHandlerLevel());
        if (this.getHandlerLevel().getHandlerLevel().equals(request.getRequestLevel().getHandlerLevel())){
            System.out.println("handler=" + this.getClass().getSimpleName());
            response = this.echo(request);
        } else if (this.nextHandler != null){
            System.out.println("next handler");
            response = this.nextHandler.handleMessage(request);
        } else {
            System.out.println("no handler");
        }
        return response;
    }

    public void setNext(Handler handler){
        this.nextHandler = handler;
    }

    protected abstract Level getHandlerLevel();

    protected abstract Response echo(Request request);
}
