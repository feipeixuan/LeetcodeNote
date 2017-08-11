package com.algorithm.list;

/**
 * @Author:    feipeixuan
 * @Version:   反转链表
 * @Link:      牛客网
 * @From:      剑指offer
 */
public class ReverseList {

    /* 双指针解决问题【直到后面指针为null】 */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        else {
            ListNode p1 = null, p2=head, tmp;

            while (p2 != null) {
                tmp = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = tmp;
            }

            return p1;
        }
    }
}
