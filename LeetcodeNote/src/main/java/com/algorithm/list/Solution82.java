package com.algorithm.list;

/**
 * Created by Mario on 2017/3/5.
 */
public class Solution82 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = null;
        ListNode newhead = deleteDuplicates(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead;
        ListNode previous = head, current = head.next;

        while (current != null) {
            if (previous.val == current.val) {
                int val = previous.val;
                ListNode tmp = current.next;

                while (tmp != null && tmp.val != val) {
                    tmp = tmp.next;
                }

                if (tmp == null) {
                    p.next = null;
                    break;
                } else {
                    p.next = tmp;
                    previous = tmp;
                    current = tmp.next;
                }
            } else {
                p.next = previous;
                p = previous;
                previous = current;
                current = current.next;
            }
        }

        return newHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

