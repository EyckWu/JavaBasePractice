package com.eyckwu.exception;

import com.eyckwu.utils.Log;

/**
 * @author : EyckWu
 * @date : 2019/8/11
 * desc    :
 */
public class TryCatchFinallyReturn {
    private static final String TAG = "TryCatchFinallyReturn";

    public static void main(String[] args){
        Log.d(TAG, "main: the value in noException is " + noException());
        Log.d(TAG, "main: the value in noException2 is " + noException2());
        Log.d(TAG, "main: the value in withException is " + withException());
        Log.d(TAG, "main: the value in withException2 is " + withException2());
        Log.d(TAG, "main: the value in withException3 is " + withException3());
        Log.d(TAG, "main: the value in withException4 is " + withException4());
    }

    /**
     * 1. try 块中没有抛出异常, try和finally块中都有return 语句
     *
     * 执行结果：
     * TryCatchFinallyReturn : noException: i in try block is 10
     * TryCatchFinallyReturn : noException: i in finally - from try or catch block is 9
     * TryCatchFinallyReturn : main: the value in noException is 8
     *
     * 执行顺序：
     * 执行try块，执行到return语句时，先执行return语句的--i,但是不返回到main方法，执行finally块，
     * 遇到finally块中的return语句，执行--i;并将值返回到main方法，这里就不会再回去try块中计算得到的值
     *
     * @return i
     */
    public static int noException(){
        int i = 10;
        try {
            Log.d(TAG, "noException: i in try block is " + i);
            return --i;
        } catch (Exception e){
            Log.d(TAG, "noException: i in catch - from try block is " + i);
            --i;
            Log.d(TAG, "noException: i in catch block is " + i);
            return --i;
        } finally {
            Log.d(TAG, "noException: i in finally - from try or catch block is " + i);
            return --i;
        }
    }

    /**
     * 2. try 块中没有抛出异常, try块中有return 语句
     *
     * 执行结果：
     * TryCatchFinallyReturn : noException2: i in try block is 10
     * TryCatchFinallyReturn : noException2: i in finally - from try or catch block is 9
     * TryCatchFinallyReturn : noException2: i in finally block is 8
     * TryCatchFinallyReturn : main: the value in noException2 is 9
     *
     * 执行顺序：
     * 执行try块，执行到return语句时，先执行return语句的--i,但是不返回到main方法，执行finally块，
     * finally块执行结束后，返回try块中，返回i在try块中最后的值。
     *
     * @return i
     */
    public static int noException2(){
        int i = 10;
        try {
            Log.d(TAG, "noException2: i in try block is " + i);
            return --i;
        } catch (Exception e){
            Log.d(TAG, "noException2: i in catch - from try block is " + i);
            --i;
            Log.d(TAG, "noException2: i in catch block is " + i);
            return --i;
        } finally {
            Log.d(TAG, "noException2: i in finally - from try or catch block is " + i);
            --i;
            Log.d(TAG, "noException2: i in finally block is " + i);
        }
    }

    /**
     * 3. try 块中抛出异常, try\catch\finally块中都有return 语句
     *
     * 执行结果：
     * TryCatchFinallyReturn : withException: i in try block is 10
     * TryCatchFinallyReturn : withException: i in catch - from try block is 10
     * TryCatchFinallyReturn : withException: i in catch block is 9
     * TryCatchFinallyReturn : withException: i in finally - from try or catch block is 8
     * TryCatchFinallyReturn : withException: i in finally block is 7
     * TryCatchFinallyReturn : main: the value in withException is 6
     *
     * 执行顺序：
     * 执行try块，抛出异常后，执行catch块，在catch块的return的--i;执行后，并不直接返回而是执行finally,
     * 因finally中有return语句，所以执行结果返回6
     *
     * @return i
     */
    public static int withException(){
        int i = 10;
        try {
            Log.d(TAG, "withException: i in try block is " + i);
            i = i/0;
            return --i;
        } catch (Exception e){
            Log.d(TAG, "withException: i in catch - from try block is " + i);
            --i;
            Log.d(TAG, "withException: i in catch block is " + i);
            return --i;
        } finally {
            Log.d(TAG, "withException: i in finally - from try or catch block is " + i);
            --i;
            Log.d(TAG, "withException: i in finally block is " + i);
            return --i;
        }
    }

    /**
     * 4. try 块中抛出异常, try\catch块中都有return 语句
     *
     * 执行结果：
     * TryCatchFinallyReturn : withException2: i in try block is 10
     * TryCatchFinallyReturn : withException2: i in catch - from try block is 10
     * TryCatchFinallyReturn : withException2: i in catch block is 9
     * TryCatchFinallyReturn : withException2: i in finally - from try or catch block is 8
     * TryCatchFinallyReturn : withException2: i in finally block is 7
     * TryCatchFinallyReturn : main: the value in withException2 is 8
     *
     * 执行顺序：
     * 执行try块，抛出异常后，执行catch块，在catch块的return的--i;执行后，并不直接返回而是执行finally,
     * 执行完finally语句后，依旧返回catch中执行return语句后的值，而不是finally中执行的值。
     *
     * @return i
     */
    public static int withException2(){
        int i = 10;
        try {
            Log.d(TAG, "withException2: i in try block is " + i);
            i = i/0;
            return --i;
        } catch (Exception e){
            Log.d(TAG, "withException2: i in catch - from try block is " + i);
            --i;
            Log.d(TAG, "withException2: i in catch block is " + i);
            return --i;
        } finally {
            Log.d(TAG, "withException2: i in finally - from try or catch block is " + i);
            --i;
            Log.d(TAG, "withException2: i in finally block is " + i);
        }
    }

    /**
     * 5. try\catch块中抛出异常, try\catch\finally块中都有return 语句
     *
     * 执行结果：
     * TryCatchFinallyReturn : withException3: i in try block is 10
     * TryCatchFinallyReturn : withException3: i in catch - from try block is 10
     * TryCatchFinallyReturn : withException3: i in finally - from try or catch block is 9
     * TryCatchFinallyReturn : withException3: i in finally block is 8
     * TryCatchFinallyReturn : main: the value in withException3 is 7
     *
     * 执行顺序：
     * 执行try块，抛出异常后，执行catch块，在catch块中出现异常执行finally,
     * finally中执行到return语句返回，不检查异常。
     *
     * @return i
     */
    public static int withException3(){
        int i = 10;
        try {
            Log.d(TAG, "withException3: i in try block is " + i);
            i = i/0;
            return --i;
        } catch (Exception e){
            Log.d(TAG, "withException3: i in catch - from try block is " + i);
            --i;
            i = i/0;
            Log.d(TAG, "withException3: i in catch block is " + i);
            return --i;
        } finally {
            Log.d(TAG, "withException3: i in finally - from try or catch block is " + i);
            --i;
            Log.d(TAG, "withException3: i in finally block is " + i);
            return --i;
        }
    }

    /**
     * 6. try\catch块中抛出异常, try\catch块中有return 语句
     *
     * 执行结果：
     * TryCatchFinallyReturn : withException4: i in try block is 10
     * TryCatchFinallyReturn : withException4: i in catch - from try block is 10
     * TryCatchFinallyReturn : withException4: i in finally - from try or catch block is 9
     * TryCatchFinallyReturn : withException4: i in finally block is 8
     * Exception in thread "main" java.lang.ArithmeticException: / by zero
     *
     * 执行顺序：
     * 执行try块，抛出异常后，执行catch块，在catch块中出现异常执行finally,
     * finally执行结束后判断发现异常，抛出。
     *
     * @return i
     */
    public static int withException4(){
        int i = 10;
        try {
            Log.d(TAG, "withException4: i in try block is " + i);
            i = i/0;
            return --i;
        } catch (Exception e){
            Log.d(TAG, "withException4: i in catch - from try block is " + i);
            --i;
            i = i/0;
            Log.d(TAG, "withException4: i in catch block is " + i);
            return --i;
        } finally {
            Log.d(TAG, "withException4: i in finally - from try or catch block is " + i);
            --i;
            Log.d(TAG, "withException4: i in finally block is " + i);
        }
    }


}
