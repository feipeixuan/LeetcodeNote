package com.algorithm.other;

/**
 * @Author: feipeixuan
 * @Version:
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class Multiply {


    /* 构建数组乘积  拆分成0,i-1 和 i+1,n */
    public int[] multiply(int[] A) {
        if (A == null)
            return null;
        int n = A.length;
        int[] array1 = new int[n];//0,i-1
        int[] array2 = new int[n];//i+1,n
        array1[0] = 1;
        array2[n - 1] = 1;


        for (int i = 1; i < n; i++) {
            array1[i] = A[i - 1] * array1[i - 1];
            array2[n - i - 1] = A[n - i] * array2[n - i];
        }

        for (int i = 0; i < n; i++)
            array1[i] *= array2[i];

        return array1;
    }
}
