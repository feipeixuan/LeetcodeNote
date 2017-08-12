package com.algorithm.other;

/**
 * @Author: feipeixuan
 * @Version: 计算幂
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class Power {

    /* 利用除余计算 */
    public double Power(double base, int exponent) {
        if (exponent == 0)
            return 1;
        else if (exponent == 1)
            return base;
        else if (exponent < 0)
            return 1 / Power(base, 0 - exponent);
        else {
            int n = 1;
            double sum = 1, num = base;

            while (exponent != 0) {
                if (exponent % 2 != 0)
                    sum = sum * num;
                exponent /= 2;
                num = num * num;
            }

            return sum;
        }
    }
}
