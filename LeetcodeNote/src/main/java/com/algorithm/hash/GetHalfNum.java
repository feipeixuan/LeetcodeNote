package com.algorithm.hash;

import java.util.HashMap;

/**
 * @Author: feipeixuan
 * @Version: 找到出现超过一半的数字
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class GetHalfNum {

    public static void main(String[] args) {
        int[] array = {4, 2, 1, 4, 2, 4};
        System.out.println(new GetHalfNum().MoreThanHalfNum_Solution(array));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap();

        for (int num : array)
            if (hashMap.containsKey(num))
                hashMap.put(num, hashMap.get(num) + 1);
            else
                hashMap.put(num, 1);

        int length = array.length / 2;

        for (Integer num : hashMap.keySet())
            if (hashMap.get(num) > length)
                return num;

        return 0;
    }
}
