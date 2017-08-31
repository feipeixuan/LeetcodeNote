package com.algorithm.sort.quick;

import java.util.ArrayList;

/**
 * @Author: feipeixuan
 * @Version: 找到最小的n个数
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class FindTopN {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList();
        if (input == null || input.length == 0 || k == 0 || k > input.length)
            return list;
        else {
            int l = 0, r = input.length - 1;
            int index = parition(input, l, r);

            while ((index = parition(input, l, r)) != k - 1) {
                if (index > k - 1)
                    r = index - 1;
                else
                    l = index + 1;
            }

            sort(input, 0, k - 1);

            for (int i = 0; i < k; i++)
                list.add(input[i]);

            return list;
        }
    }

    public void sort(int[] array, int l, int r) {
        if (l < r) {
            int index = parition(array, l, r);
            sort(array, l, index - 1);
            sort(array, index + 1, r);
        }
    }


    public int parition(int[] array, int l, int r) {
        int key = array[l];

        while (l < r) {

            while (l < r && array[r] > key)
                r--;

            array[l] = array[r];

            while (l < r && array[l] <= key)
                l++;

            array[r] = array[l];
        }

        array[l] = key;
        return l;
    }

}
