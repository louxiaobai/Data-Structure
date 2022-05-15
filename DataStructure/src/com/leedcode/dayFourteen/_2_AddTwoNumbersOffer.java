package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/9-12:02 下午
 */
public class _2_AddTwoNumbersOffer {


    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode dummyNode=new ListNode(-999);

        ListNode curr=dummyNode;

        int temp=0;//进行保存余数的

        while (l1!=null||l2!=null){

            int a=l1==null?0:l1.val;

            int b=l2==null?0:l2.val;

            int res=a+b+temp;

            curr.next=new ListNode(res%10);

            curr=curr.next;

            temp=res/10;

            if (l1!=null) l1=l1.next;

            if (l2!=null) l2=l2.next;


        }


        if (temp!=0) curr.next=new ListNode(1);


        return dummyNode.next;






    }
}