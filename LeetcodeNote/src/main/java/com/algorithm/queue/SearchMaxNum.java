package com.algorithm.queue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author: feipeixuan
 * @Version: 滑动窗口中找最大值
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class SearchMaxNum {

    /*
         使用双端队列来实现【双向链表】
         1.判断元素是否大于或等于队尾元素，是删除，直到小于为止
         2.插入到尾巴
         以上保证了队列是降序排列
         小技巧：队列中存放的是下标而不是元素的值
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList();
        if (num == null || size <= 0)
            return list;
        else if (num.length < size)
            return list;
        else {
            LinkedList<Integer> queue = new LinkedList();

            for (int i = 0; i < num.length; i++) {
                while (!queue.isEmpty() && num[i] >= num[queue.getLast()])
                    queue.pollLast();

                queue.offer(i);

                if (i >= size - 1)
                    list.add(num[queue.getFirst()]);
                if (i - queue.getFirst() == size - 1)
                    queue.pollFirst();
            }

            return list;
        }
    }
}
