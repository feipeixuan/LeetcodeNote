package com.algorithm.other;

import java.util.Scanner;

/**
 * @Author: feipeixuan
 * @Version:
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class lianjia1 {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++)
            array[i] = scanner.nextInt();
        int num = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < array.length; i++)
            if (array[i] <= num + 30)
                sum++;

        System.out.println(sum);
    }
}
