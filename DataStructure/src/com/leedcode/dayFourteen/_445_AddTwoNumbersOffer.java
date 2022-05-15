package com.leedcode.dayFourteen;

import java.util.ArrayDeque;

/**
 * @author lqw
 * @date 2022/5/9-12:28 下午
 */
public class _445_AddTwoNumbersOffer {


    /**
     * 使用头插发 省去 链表反转的操作
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //进行特判

        if (l1==null&&l2==null) return new ListNode(0);

        //Priority--java内置小顶堆

        //初始化两个栈 用来存放 l1 和l2

        ArrayDeque<ListNode> stack1=new ArrayDeque();

        ArrayDeque<ListNode> stack2=new ArrayDeque();


        while (l1!=null){
            stack1.push(l1);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2);
            l2=l2.next;
        }


        //进行相加操作

        ListNode ans=null;



        int carry=0;

        while (!stack1.isEmpty()||!stack2.isEmpty()){

            int num1=stack1.isEmpty()?0:stack1.pop().val;

            int num2=stack2.isEmpty()?0:stack2.pop().val;

            int res=num1+num2+carry;

            ListNode curr=new ListNode(res%10);

            curr.next=ans;

            ans=curr;



            carry=res/10;

        }

        if (carry!=0){

            ListNode curr=new ListNode(1);

            curr.next=ans;

            ans=curr;
        }

        return ans;
    }




    /**
     * 使用栈的解决方法
     * 时间复杂度:O(m+n)
     * 空间复杂度:O(m+n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        //进行特判

        if (l1==null&&l2==null) return new ListNode(0);

        //Priority--java内置小顶堆

        //初始化两个栈 用来存放 l1 和l2

        ArrayDeque<ListNode> stack1=new ArrayDeque();

        ArrayDeque<ListNode> stack2=new ArrayDeque();


        while (l1!=null){
            stack1.push(l1);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2);
            l2=l2.next;
        }


        //进行相加操作

        ListNode dumyNode=new ListNode(-999);

        ListNode curr=dumyNode;

        int carry=0;

        while (!stack1.isEmpty()||!stack2.isEmpty()){

            int num1=stack1.isEmpty()?0:stack1.pop().val;

            int num2=stack2.isEmpty()?0:stack2.pop().val;

            int res=num1+num2+carry;

            curr.next=new ListNode(res%10);

            curr=curr.next;

            carry=res/10;

        }

        if (carry!=0) curr.next=new ListNode(1);
        //将链表进行反转返回
        return reverse(dumyNode.next);

    }



    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * 对原始链表进行修改了---不符合题意
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {


        if (l1==null&&l2==null) return new ListNode(0);

        //将链表进行反转

        ListNode A=reverse(l1);

        ListNode B=reverse(l2);

        //进行相加计算

        ListNode dummyNode=new ListNode(-999);

        ListNode curr=dummyNode;

        int carry=0;

        while (A!=null||B!=null){

            int num1=A==null?0:A.val;

            int num2=B==null?0:B.val;


            int res= num1+num2+carry;

            curr.next=new ListNode(res%10);

            curr=curr.next;

            carry=res/10;

            if (A!=null) A=A.next;

            if (B!=null) B=B.next;




        }

        if (carry!=0) curr.next=new ListNode(carry);


        //然后将链表再次反转

        return  reverse(dummyNode.next);
    }


    public ListNode reverse(ListNode head){

        ListNode pre=null;

        ListNode curr=head;

        ListNode temp=null;

        while (curr!=null){

            temp=curr.next;

            curr.next=pre;

            pre=curr;

            curr=temp;
        }


        return pre;



    }
}