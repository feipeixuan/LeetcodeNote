package com.algorithm.math;

/**
 * @Author: feipeixuan
 * @Version:
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class NumberOf1 {

    public static void main(String [] args){
        System.out.println(new NumberOf1().NumberOf1Between1AndN_Solution(1304));
    }

    /* 补偿法 重点是判断 %==1 */
    public int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0, i = 1, num = n;

        if (n <= 0)
            return 0;

        while (true) {
            int tmp = num / 10;
            if (num % 10 > 1)
                tmp++;
            sum += tmp * (int) Math.pow(10, i - 1);//后面是权值
            if (num % 10 == 1)
                sum += n % (int) Math.pow(10, i - 1)+1;//得到当前位置右面的所有数
            if (tmp == 0)
                break;
            num = num/10;//减一位
            i++;
        }

        return sum;
    }
}
