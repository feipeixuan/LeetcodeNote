package com.algorithm.other;

/**
 * @Author: feipeixuan
 * @Version: 寻找最后一个数，模拟约瑟夫环
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class LastRemain {

    public static void main(String args[]) {
        int rs = new LastRemain().LastRemaining_Solution(5, 3);
        System.out.println(rs);
    }

    public int LastRemaining_Solution(int n, int m) {
        if (m <= 0 || n <= 0)
            return -1;
        else if (n == 1)
            return 1;
        else {
            int[] array = new int[n];
            int count = n, start = 0, num = 0;

            while (count != 1) {
                if (start >= n)
                    start = 0;
                else if (array[start] < 0) {
                    start++;
                    continue;
                } else if (num == m - 1) {
                    array[start++] = -1;
                    count--;
                    num = 0;
                } else {
                    start++;
                    num++;
                }
            }

            for (int i = 0; i < array.length; i++)
                if (array[i] >= 0)
                    return i;

            return 0;
        }
    }
}
