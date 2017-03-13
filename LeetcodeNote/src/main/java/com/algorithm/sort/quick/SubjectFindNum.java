package com.algorithm.sort.quick;

/**
 * Created by feipeixuan on 2017/2/22.
 */
public class SubjectFindNum {

    public static void main(String args[]) {
        int[] arrays = {15,-8, 99, 1, 100, 22};
        FindNum(arrays,4,0,5);
    }

    public static void FindNum(int[] array, int index, int left, int right) {
        if(left==right)
            System.out.println(array[left]);
        else if (left < right) {
            int key = array[left];
            int low = left;
            int high = right;

            while (low < high) {
                while (low < high && array[high] > key) {
                    high--;
                }
                array[low] = array[high];

                while (low < high && array[low] < key) {
                    low++;
                }
                array[high] = array[low];
            }
            array[low] = key;

            if(low-left+1==index){
                System.out.println(key);
                return;
            }
            else if(low-left+1>index){
                FindNum(array,index,left,low-1);
            }
            else{
                FindNum(array,index-low+left-1,low+1,right);
            }

        }
    }
}
