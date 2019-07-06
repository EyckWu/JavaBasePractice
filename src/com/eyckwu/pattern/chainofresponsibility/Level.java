package com.eyckwu.pattern.chainofresponsibility;

public class Level {
    // 定义一个请求和处理等级
    String handlerLevel;

    public Level(String handlerLevel) {
        this.handlerLevel = handlerLevel;
    }

    public String getHandlerLevel() {
        return handlerLevel;
    }

    public void setHandlerLevel(String handlerLevel) {
        this.handlerLevel = handlerLevel;
    }
}
