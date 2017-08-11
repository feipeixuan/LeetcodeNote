package com.algorithm.recursion;

/**
 * @Author:    feipeixuan
 * @Version:   反转链表
 * @Link:      牛客网
 * @From:      剑指offer
 */
public class ReverseList {

    public DisplayList.ListNode ReverseList(DisplayList.ListNode head) {
        return reverseNode(head);
    }

    /*
       保留下一个节点，反转后面的，修改下一个节点到当前结点的指向同时保留head
     */
    public DisplayList.ListNode reverseNode(DisplayList.ListNode listNode){
        if(listNode==null || listNode.next==null)
            return listNode;
        else
        {
            DisplayList.ListNode tmpNode=listNode.next;
            /* 必不可少 */
            listNode.next=null;
            DisplayList.ListNode head=reverseNode(tmpNode);
            tmpNode.next=listNode;
            return head;
        }
    }
}
