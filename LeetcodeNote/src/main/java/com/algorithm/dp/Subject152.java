package com.algorithm.dp;

/**
 * Created by feipeixuan on 2016/11/10.
 */
public class Subject152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int[] positiveNums = new int[length + 1];
        int[] negativeNums = new int[length + 1];
        int max = nums[0];

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                positiveNums[i + 1] = Math.max(nums[i], positiveNums[i] * nums[i]);
                negativeNums[i + 1] = Math.min(nums[i], negativeNums[i] * nums[i]);
            } else if (nums[i] < 0) {
                positiveNums[i + 1] = Math.max(nums[i] * negativeNums[i], 0);
                negativeNums[i + 1] = Math.min(nums[i] * positiveNums[i], nums[i]);
            }

            if (nums[i] < 0 && positiveNums[i + 1] == 0) {
                max = Math.max(max, nums[i]);
            } else {
                max = Math.max(max, positiveNums[i + 1]);
            }
        }
        return max;
    }
}
