package com.algorithm.sort;

/**
 * Created by feipeixuan on 2017/2/15.
 */
public class Subject148 {

    public static  void main(String args[])
    {
        ListNode head=new ListNode(3);
        head.next=new ListNode(1);
        head.next.next=new ListNode(2);
        head.next.next.next=null;
        Subject148 solution=new Subject148();
        solution.sortList(head);
    }

    public ListNode sortList(ListNode head) {
        return merge_sort(head);
    }


    public ListNode findMiddle(ListNode head) {
        ListNode p1 = head, p2 = head, pre = head;

        while (p2 != null) {
            pre = p1;
            p1 = p1.next;
            if (p2.next == null)
                break;
            p2 = p2.next.next;
        }
        return pre;
    }

    public ListNode merge_sort(ListNode p) {
        if (p.next == null)
            return p;
        ListNode temp = findMiddle(p), middle = temp.next;
        temp.next = null;
        ListNode head1=merge_sort(p);
        ListNode head2=merge_sort(middle);
        return merge(head1, head2);
    }

    public ListNode merge(ListNode p, ListNode q) {
        ListNode head = new ListNode(-1), tmp = head;

        while (p != null && q != null) {
            if (p.val <= q.val) {
                tmp.next = p;
                p = p.next;
            } else {
                tmp.next = q;
                q = q.next;
            }
            tmp = tmp.next;
        }
        if (p != null)
            tmp.next = p;
        if (q != null)
            tmp.next = q;
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
