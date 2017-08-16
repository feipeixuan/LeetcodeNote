package com.algorithm.search;

/**
 * @Author: feipeixuan
 * @Version: 有序数组中出现位置
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class FindNumCount {

    /* 利用二分查找,找到第一次出现的位置，然后往后遍历即可 */
    public int GetNumberOfK(int[] array, int k) {
        int l = 0, r = array.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (array[mid] == k)
                r = mid;
            else if (array[mid] > k)
                r = mid - 1;
            else
                l = mid + 1;
        }

        r = l;
        int count = 0;

        while (r < array.length && array[r] == k) {
            count++;
            r++;
        }

        return count;
    }
}
