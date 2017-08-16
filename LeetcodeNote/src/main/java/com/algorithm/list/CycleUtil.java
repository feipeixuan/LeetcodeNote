package com.algorithm.list;

/**
 * @Author: feipeixuan
 * @Version: 获取环的起始点和判断是否有环
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class CycleUtil {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode p1 = pHead, p2 = isCycle(pHead);
        if (p2 == null)
            return null;

        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }


    public ListNode isCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode p1 = head.next;
        ListNode p2 = head.next.next;

        while (p2 != null && p2.next != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        if (p1 == p2)
            return p1;
        else
            return null;
    }
}
