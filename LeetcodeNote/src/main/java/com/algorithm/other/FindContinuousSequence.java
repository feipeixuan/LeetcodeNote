package com.algorithm.other;

import java.util.ArrayList;

/**
 * @Author: feipeixuan
 * @Version: 寻找连续的数字和为目标值
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class FindContinuousSequence {

    private ArrayList<ArrayList<Integer>> sumList = new ArrayList();

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 2)
            return sumList;
        else {
            for (int i = sum - 1; i > 1; i--) {
                if (i % 2 != 0 && sum % i != 0)      //如果个数为奇数
                    continue;
                else if (i % 2 == 0 && sum % i == 0) //如果个数为偶数
                    continue;
                else {
                    int num = sum / i;
                    int start = num - i / 2;

                    if (i % 2 == 0)
                        start++;

                    if (start <= 0)
                        continue;
                    else if ((start + start + i - 1) * i / 2 != sum)
                        continue;
                    else {
                        ArrayList<Integer> list = new ArrayList(i);

                        for (int j = start; j <= start + i - 1; j++)
                            list.add(j);

                        sumList.add(list);
                    }

                }


            }
            return sumList;
        }
    }
}
