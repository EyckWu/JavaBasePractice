package com.eyckwu.lambda;

import java.util.Arrays;
import java.util.List;

public class MapReduceLambda {
    public static void main(String[] args){
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost: costBeforeTax){
            double price = cost + .12*cost;
            System.out.println(price);
        }

        // 使用lambda表达式
        costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);

        double total = 0;
        for (Integer cost: costBeforeTax){
            double price = cost + .12*cost;
            total += price;
        }
        System.out.println("Total:" + total);

        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total:" + bill);
    }
}
