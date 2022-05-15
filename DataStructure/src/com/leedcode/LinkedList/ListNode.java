package com.leedcode.LinkedList;

/**链表节点
 * @author lqw
 * @date 2021/10/20-10:14 上午
 */
public class ListNode {

    int val;
    ListNode next;

    public ListNode(int val){

        this.val=val;
        this.next=null;

    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();

        ListNode curr=this;

        while (curr!=null){

            sb.append(curr.val).append("->");

            curr=curr.next;

        }

        sb.append("null");
        return sb.toString();
    }

    public static ListNode fromArray(int[] arr){

        if (arr==null||arr.length==0) return  null;

        ListNode head=new ListNode(arr[0]);

        ListNode curr=head;

        for (int i = 0; i <arr.length ; i++) {

            curr.next=new ListNode(arr[i]);
            curr=curr.next;

        }
        return head;

    }


}