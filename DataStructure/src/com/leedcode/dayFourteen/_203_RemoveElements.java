package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/4-8:31 下午
 */
public class _203_RemoveElements {


    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyNode=new ListNode(-1);

        dummyNode.next=head;
        ListNode cur=dummyNode;
        while (cur.next!=null){
            int num=cur.next.val;
            if (num==val){
                cur.next=cur.next.next;
            }else {

                cur=cur.next;
            }
        }
        return dummyNode.next;
    }
}