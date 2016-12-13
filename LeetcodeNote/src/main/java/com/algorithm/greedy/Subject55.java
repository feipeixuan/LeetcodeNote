package com.algorithm.greedy;

/**
 * Created by feipeixuan on 2016/12/13.
 */
public class Subject55 {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        else if(nums.length==1){
            return true;
        }
        int reach = 0;

        for (int i = 0; reach < nums.length-1 && reach >= i; i++) {
            reach = Math.max(reach, i + nums[i]);
        }

        return reach >= nums.length-1;
    }
}
