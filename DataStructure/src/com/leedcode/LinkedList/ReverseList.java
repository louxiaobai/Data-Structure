package com.leedcode.LinkedList;

import sun.util.resources.cldr.ebu.CurrencyNames_ebu;

import java.util.List;

/**反转链表 leedcode 206   简单
 * @author lqw
 * @date 2021/10/20-10:53 上午
 */
public class ReverseList {

    public static void main(String[] args) {

    }

    /**
     * 迭代法
     * @param head
     * @return
     */
    public  ListNode reverseList01 (ListNode head) {

        if (head==null) return null;
        ListNode prev=null;
        ListNode curr=head;
        ListNode temp=null;
        while (curr.next!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;

        }
        return prev;

    }
    /**
     * 递归解法
     * @param head
     * @return
     */
    public  ListNode reverseList02 (ListNode head) {
        if (head==null||head.next==null) return head;//递归结束条件
        ListNode p=reverseList02(head.next);//递的过程
        //进行反转操作
        head.next.next=head;
        head.next=null;
        return p;
    }
}