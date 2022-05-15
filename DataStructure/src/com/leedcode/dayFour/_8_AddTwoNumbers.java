package com.leedcode.dayFour;

/**
 * @author lqw
 * @date 2022/3/3-5:15 下午
 */
public class _8_AddTwoNumbers {


    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1.val==l2.val&&l1.val==0) return new ListNode(0);//特殊情况两个链表的头节点都是0

        //创建一个链表用于存储计算的数据]

        ListNode listNode = new ListNode(0);

        ListNode curr=listNode;

        int target=0;//用于记录进位的

        while (l1!=null||l2!=null) {

            int num1=0;
            int num2=0;

            if (l1!=null){

                num1=l1.val;

                l1=l1.next;

            }
            if (l2!=null){

                num2=l2.val;

                l2=l2.next;
            }

            int res=(num1+num2+target)%10;

            target=(num1+num2+target)/10;

            curr.next=new ListNode(res);

            curr=curr.next;

        }

        if (target != 0) curr.next = new ListNode(target);
        return listNode;


    }


}