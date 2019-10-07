package com.eyckwu.annotation;

import com.eyckwu.utils.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : EyckWu
 * @date : 2019/10/7
 * desc    :
 */
@TestAnnotation(msg = "Hello")
public class Test {
    private static final String TAG = "Test";

    @Check("hi")
    String a;

    @Perform
    public void testMethod(){}

    @SuppressWarnings("deprecation")
    public void test1(){
        Log.d(TAG, "test1: ");
    }

    public static void main(String[] args){
        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
        if (hasAnnotation){
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            Log.d(TAG, "id:" + testAnnotation.id());
            Log.d(TAG, "msg:" + testAnnotation.msg());
        }
        
        try {
            Field a = Test.class.getDeclaredField("a");
            a.setAccessible(true);
            Check check = a.getAnnotation(Check.class);
            if (check != null){
                Log.d(TAG, "main: check value:" + check.value());
            }

            Method testMethod = Test.class.getDeclaredMethod("testMethod");
            if (testMethod != null){
                Annotation[] ans = testMethod.getDeclaredAnnotations();
                for (int i = 0; i < ans.length; i++){
                    Log.d(TAG, "main: method testMethod annotation:" + ans[i].annotationType().getSimpleName());
                }
            }

        } catch (NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
            Log.d(TAG, "main: exp = " + e.getMessage());
        }
    }
}
