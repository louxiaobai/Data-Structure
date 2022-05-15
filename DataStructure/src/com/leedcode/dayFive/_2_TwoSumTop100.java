package com.leedcode.dayFive;



import java.util.List;

/**
 * @author lqw
 * @date 2022/3/7-10:56 上午
 */
public class _2_TwoSumTop100 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //创建一个链表进行存储数数据

        ListNode dummy=new ListNode(-1);

        ListNode curr=dummy;

        int carry=0;//用于判断是否进位



        while (l1!=null||l2!=null){

            int num1= l1==null? 0:l1.val;

            int num2= l2==null? 0:l2.val;


            int res=num1+num2+carry;

            curr.next=new ListNode(res%10);

            carry=res/10;

            curr=curr.next;

            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
        }

        if (carry!=0) curr.next=new ListNode(1);
        return dummy.next;
    }

}