package com.leedcode.dayFourteen;

import org.w3c.dom.html.HTMLIsIndexElement;

/**
 * @author lqw
 * @date 2022/5/12-11:46 上午
 */
public class _148_SortListTop {


    /**
     * 归并排序的应用
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        //进行特殊判断

        if (head==null||head.next==null) return head;

        //找到该链表的中点:如果链表的长度为偶数个 则需要将slow 指针指向偏左的位置,不然 死循环，超时间
        ListNode slow=head;

        ListNode fast=head.next;

        while (fast!=null&&fast.next==null){

            slow=slow.next;

            fast=fast.next.next;
        }


        ListNode rightHead=slow.next;

        slow.next=null;

        ListNode left=sortList(head);

        ListNode right=sortList(rightHead);



        return mergeTwoLists(left,right);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null) curr.next = l2;
        if (l2 == null) curr.next = l1;

        return dummyNode.next;
    }

}