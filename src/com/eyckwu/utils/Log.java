package com.eyckwu.utils;

import java.util.Arrays;

/**
 * @author : EyckWu
 * @date : 2019/7/20
 * desc    : 打印工具类
 */
public class Log {
    public static void d(String tag, Object msg){
        System.out.println(tag + " : " + msg.toString());
    }

    public static void d(String tag, Object[] msgs){
        System.out.println(tag + " : " + Arrays.toString(msgs));
    }
}
