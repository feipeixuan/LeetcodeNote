package com.algorithm.dp;

/**
 * Created by feipeixuan on 2016/11/14.
 */
public class Subject416 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int target = 0;

        for (int item : nums) {
            target += item;
        }
        //必须是偶数
        if ((target & 1) != 0) {
            return false;
        }
        target /= 2;
        boolean[] array = new boolean[nums.length + 1];
        array[0] = true;

        //转换成背包问题
        for (int item : nums) {
            for (int i = target; i >= item; i--) {
                if (array[i - item]) {
                    array[i] = true;
                }
            }
            if (array[target]) {
                return true;
            }
        }

        return false;
    }
}
