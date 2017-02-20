package com.algorithm.sort.bubble;

/**
 * Created by feipeixuan on 2017/2/20.
 */
public class SubjectBubble {

    public static void main(String args[]) {
        int[] arrays = {-8, 99, 1, 100, 22,101,102};
        sort(arrays);
        for (int item : arrays) {
            System.out.println(item);
        }
    }

    public static void sort(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                count++;
                if (array[j] > array[j + 1])
                    swap(array, j, j + 1);
            }
        }
        System.out.println("排序次数 " + count);
    }

    public static void sort1(int[] array) {
        int count = 0;
        int pos = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            pos = Math.min(pos, array.length - i - 1);
            int k = pos;
            for (int j = 0; j < k; j++) {
                count++;
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    pos = j;
                }
            }
        }
        System.out.println("排序次数 " + count);
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
