package com.algorithm.list;

/**
 * @Author: feipeixuan
 * @Version:
 * @Link: 牛客网
 * @From: 剑指offer
 */
public class DeleteDuplicate {

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(4);
        ListNode p7 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        p7.next = null;
        new DeleteDuplicate().deleteDuplication(p1);
    }

    /*
       删除重复的节点
       三指针解决 根据p1==p2来判断后续的操作
       1.不等于 指针全部后移
       2.等于   直到找到一个不等于的为止
                》可能为null
                》可能p3.next为null
                》其他
    */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode head = new ListNode(0);
        head.next = pHead;

        ListNode p1 = head, p2 = pHead, p3 = pHead.next;

        while (p3 != null) {
            if (p2.val != p3.val) {
                p1.next = p2;
                p1 = p2;
                p2 = p3;
                p3 = p3.next;
            } else {
                while (p3 != null && p2.val == p3.val) {
                    p3 = p3.next;
                }

                if (p3 == null)
                    p1.next = null;
                else {
                    p1.next = p3;
                    p2 = p3;
                    p3 = p3.next;
                }
            }
        }

        return head.next;
    }
}
