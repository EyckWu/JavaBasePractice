package com.eyckwu.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterLambda {
    public static void main(String[] args){
        List<String> strList = Arrays.asList("abc", " ", "bcd", "", "defg", "jk");
        List<String> filtered = strList.stream().filter(x -> x.length()> 2).filter(x -> x.startsWith("a")).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }
}
