package com.algorithm.hash;

import java.util.HashMap;

/**
 * @Author: feipeixuan
 * @Version: 复杂链表的复制
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class CopyRandomListNode {

    /* 构建hash表，使得查找一个节点的时间为O（1） */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        else {
            HashMap<Integer, RandomListNode> hashMap = new HashMap();
            RandomListNode p = pHead, head = new RandomListNode(-1), p1 = head;
            head.next = null;

            while (p != null) {
                RandomListNode tmp = new RandomListNode(p.label);
                tmp.next = null;
                p1.next = tmp;
                hashMap.put(p.label, tmp);
                p1 = tmp;
                p = p.next;
            }

            p = pHead;
            p1 = head.next;

            while (p != null) {
                if (p.random == null)
                    p1.random = null;
                else {
                    RandomListNode random = hashMap.get(p.random.label);
                    p1.random = random;
                }
                p = p.next;
                p1 = p1.next;
            }

            return head.next;
        }
    }

    class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
