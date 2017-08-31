package com.algorithm.sort.bubble;

/**
 * @Author: feipeixuan
 * @Version:
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class InversePairs {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
        int sum = new InversePairs().InversePairs(array);
        System.out.println(sum);
    }

    /* 虽然可以利用交换排序，达到目的，但是时间复杂度过高n-2 */
    public int InversePairs(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j] > array[j + 1])
                    swap(j, j + 1, array);
        sum++;

        return sum;
    }

    public void swap(int i, int j, int[] array) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
