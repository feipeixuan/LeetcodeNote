package com.algorithm.recursion;

import java.util.ArrayList;

/**
 * @Author:   feipeixuan
 * @Version:  从尾到头遍历链表 【递归的思想】
 * @Link:     牛客网
 * @From:     剑指offer
 */
public class DisplayList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList();
        visitList(listNode, list);
        return list;
    }

    /* 递归函数 */
    public void visitList(ListNode listNode, ArrayList<Integer> list) {
        if (listNode == null) {
            return;
        } else if (listNode.next != null)
            visitList(listNode.next, list);

        list.add(listNode.val);
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
