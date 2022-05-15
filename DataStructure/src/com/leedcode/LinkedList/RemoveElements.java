package com.leedcode.LinkedList;

/** 移除链表元素--leedcode 203 题 简单
 * @author lqw
 * @date 2021/10/20-10:32 上午
 */
public class RemoveElements {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {

        if (head==null) return null;

        ListNode dummyHead=new ListNode(0);//创建一个虚拟头节点
        dummyHead.next=head;
        ListNode cur=dummyHead;

        while (cur!=null){

            if (cur.next.val==val){
                cur.next=cur.next.next;
            }else {

                cur=cur.next;
            }

        }

        return dummyHead.next;
    }
}