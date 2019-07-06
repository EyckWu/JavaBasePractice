package com.eyckwu.pattern.chainofresponsibility;

public class Request {
    private Level requestLevel;

    public Request(Level level) {
        this.requestLevel = level;
    }

    public Level getRequestLevel() {
        return requestLevel;
    }

    public void setRequestLevel(Level requestLevel) {
        this.requestLevel = requestLevel;
    }
}
