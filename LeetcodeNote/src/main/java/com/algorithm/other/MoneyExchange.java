package com.algorithm.other;


/**
 * @Author: feipeixuan
 * @Version: 金币兑换:分为 1, 3, 5, 7 四种规格
 * @Link: http://blog.csdn.net/u010809185/article/details/51511512
 * @From: 猿辅导
 */

public class MoneyExchange {

    public static void main(String[] args) {
        System.out.println(new MoneyExchange().exchage(10));
    }

    public int exchage(int num) {
        int count = 0;
        for (int i = 0; i <= num; i++)
            for (int j = 0; j <= num / 3; j++)
                for (int k = 0; k <= num / 5; k++)
                    for (int l = 0; l <= num / 7; l++)
                        if (i + 3 * j + 5 * k + 7 * l == num) {
                            count++;
//                            System.out.println(""+i+j+k+l);
                        }
        return count;
    }
}
