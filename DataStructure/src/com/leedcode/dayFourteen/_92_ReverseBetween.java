package com.leedcode.dayFourteen;

/**
 * @author lqw
 * @date 2022/5/7-5:14 下午
 */
public class _92_ReverseBetween {

    /**
     * 迭代法 进行求解
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head==null||head.next==null) return head;

        ListNode dummyNode=new ListNode(-999);

        dummyNode.next=head;
        //第一步找到left的前一个节点
        ListNode pre=dummyNode;
        for (int i = 0; i <left-1 ; i++) {
            pre=pre.next;
        }
        //得到left的开始节点
        ListNode leftNode=pre.next;
        //第二步找到 right的节点
        ListNode rightNode=leftNode;
        for (int i = 0; i <right-left; i++) {
            rightNode=rightNode.next;
        }
        //得到right的后一个节点
        ListNode postNode=rightNode.next;
        //进行节点的断开
        pre.next=null;
        rightNode.next=null;
        //进行链表的反转
        reverseList(leftNode);
        //进行链表的拼接
        pre.next=rightNode;
        leftNode.next=postNode;
        return dummyNode.next;
    }

    public void reverseList(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;
        ListNode temp=null;
        while(cur!=null){
            temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }

    }
}