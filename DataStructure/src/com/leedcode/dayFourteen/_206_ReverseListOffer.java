package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/7-4:17 下午
 */
public class _206_ReverseListOffer {


    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;
        ListNode temp=null;
        while(cur!=null){
            temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;

    }


    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {

        if (head==null||head.next==null) return head;


        ListNode p=reverseList(head.next);

        head.next.next=p;

        head.next=null;

        return p;


    }




}
