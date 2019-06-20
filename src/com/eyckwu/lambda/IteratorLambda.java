package com.eyckwu.lambda;

import java.util.Arrays;
import java.util.List;

public class IteratorLambda {
    public static void main(String[] args){
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature: features){
            System.out.println(feature);
        }

        features.forEach(n -> System.out.println(n));

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);
    }
}
