package com.algorithm.sort.insert;

/**
 * Created by feipeixuan on 2017/2/16.
 */
public class SubjectInsert {

    public static void main(String args[]) {
        int[] arrays = {-8, 99, 1, 100, 22};
        sort(arrays);
        for (int item : arrays) {
            System.out.println(item);
        }
    }

    public static void sort(int[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            int num = arrays[i + 1];
            int j = i;
            //循环条件需要注意不是for 是 while j也要保存

            while (j >= 0 && num < arrays[j]) {
                arrays[j + 1] = arrays[j];
                j--;
            }

            arrays[j + 1] = num;
        }
    }
}
