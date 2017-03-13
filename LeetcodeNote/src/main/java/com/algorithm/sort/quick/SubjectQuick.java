package com.algorithm.sort.quick;

/**
 * Created by feipeixuan on 2017/2/22.
 */
public class SubjectQuick {

    public static void main(String args[]) {
        int[] arrays = {15,-8, 99, 1, 100, 22};
        sort(arrays,0,5);
        for (int item : arrays) {
            System.out.println(item);
        }
    }

    public static void sort(int[] array,int left,int right) {
        if(left<right){
            int key=array[left];
            int low=left;
            int high=right;

            while(low<high) {
                while (low < high && array[high] > key) {
                    high--;
                }
                array[low] = array[high];

                while (low < high && array[low] < key) {
                    low++;
                }
                array[high] = array[low];
            }

            array[low]=key;
            sort(array,left,low-1);
            sort(array,low+1,right);
        }
    }
}
