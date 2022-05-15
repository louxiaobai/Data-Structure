package com.leedcode.LinkedList;

import com.line.quequ.LinkedQueue;
import sun.util.resources.cldr.ebu.CurrencyNames_ebu;
import sun.util.resources.cldr.sn.LocaleNames_sn;

/**链表的中间结点-leedcode 876 简单
 * @author lqw
 * @date 2021/10/21-8:58 上午
 */
public class MiddleNode {

    public static void main(String[] args) {

    }

    /**
     * 两次循环发
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {

        if (head==null) return null;

        int length=0;

        //得到链表的长度
        ListNode tmp=head;
        while (tmp!=null){
            length++;
            tmp=tmp.next;
        }

        //计算中间节点

        for (int i = 0; i <length/2 ; i++) {

              head=head.next;


        }

        return  head;



    }


    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static ListNode middleNode2(ListNode head){


        ListNode slow=head;//定义慢指针

        ListNode fast=head;//定义快指针

        while (fast!=null&&fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;


        }

        return slow;



    }




}