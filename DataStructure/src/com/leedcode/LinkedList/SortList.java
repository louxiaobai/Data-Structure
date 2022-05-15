package com.leedcode.LinkedList;


public class SortList {

    public static void main(String[] args) {

    }

    public static ListNode sort(ListNode head){

        if (head==null||head.next==null) return head;//�ݹ��������
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode rightHead=slow.next;
        slow.next=null;
        ListNode left=sort(head);
        ListNode right=sort(rightHead);
        //���й鲢����
        return merge(left,right);

    }

    /**
     * ������������鲢����
     * @param left
     * @param right
     * @return
     */
    private static ListNode merge(ListNode left, ListNode right) {
        if (left==null||right==null) return left==null? right:left;

        //����һ������ͷ�ڵ�
        ListNode dummyHead=new ListNode(-1);

        ListNode curr=dummyHead;
        while (left!=null&right!=null){

            if (left.val<=right.val){

                curr.next=left;
                left=left.next;
                curr=curr.next;
            }else{
                curr.next=right;
                right=right.next;
                curr=curr.next;
            }

        }

        if (left==null){

            curr.next=right;

        }
        if (right==null){

            curr.next=right;

        }

        return dummyHead.next;


    }


}