package com.algorithm.list;

/**
 * @Author:  feipeixuan
 * @Version: 获得倒数第N个节点
 * @Link:    牛客网
 * @From:    剑指向offer
 */
public class DisplayTopNode {

    public ListNode FindKthToTail(ListNode head, int k) {
        int length = getLength(head);
        /* 必要的异常情况判断 */
        if (k <= 0 || k > length)
            return null;

        int nodeLocation = length - k;
        int num = 0;
        ListNode p = head;

        while (num < nodeLocation) {
            p = p.next;
            num++;
        }

        return p;
    }

    public int getLength(ListNode head) {
        ListNode p = head;
        int length = 0;

        while (p != null) {
            p = p.next;
            length++;
        }

        return length;
    }
}
