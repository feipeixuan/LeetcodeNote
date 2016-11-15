package com.algorithm.dp;

/**
 * Created by feipeixuan on 2016/11/15.
 */
public class Subject376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else {
            int[] positiveArray = new int[nums.length];
            int[] negativeArray = new int[nums.length];
            positiveArray[0] = 1;
            negativeArray[0] = 1;
            int max = 1;

            for (int i = 1; i < nums.length; i++) {
                positiveArray[i] = 1;
                negativeArray[i] = 1;
                for (int j = i - 1; i >= 0; j--) {
                    if (nums[i] > nums[j]) {
                        positiveArray[i] = Math.max(positiveArray[i], negativeArray[j] + 1);
                    } else if (nums[i] < nums[j]) {
                        negativeArray[i] = Math.max(negativeArray[i], positiveArray[j] + 1);
                    }
                    max = Math.max(Math.max(negativeArray[i], positiveArray[i]), max);
                }
            }
            return max;
        }
    }
}
